package Server;

import Common.*;
import Server.DataLayer.Message;
import Server.DataLayer.Project;
import Server.DataLayer.Task;
import Server.DataLayer.User;

import javax.management.remote.rmi.RMIConnection;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.ConnectIOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Implements the ServerSubject interface. The private method notifyObservers (part of the subject in the Observer
 * pattern) is here wrapped by more client-friendly methods.
 *
 * Some of the I/O-heavy void methods in this class spawns a separate thread instead of blocking.
 *
 * @author Apinayan Mohanthas
 */

public class RMIServer extends UnicastRemoteObject implements ServerSubject {

    private AuthService authService;

    /**
     * Thread-friendly list of the Observers/clients.
     */
    private CopyOnWriteArrayList<ClientObserver> clients;

    public RMIServer(int port) throws RemoteException, MalformedURLException {
        super();
        Registry registry = LocateRegistry.createRegistry(port);
        Naming.rebind("RemoteService", this);
        System.out.println("starting...");
        authService = new AuthService();
        clients = new CopyOnWriteArrayList<>();
    }

    @Override
    public String login(String username, String password) throws RemoteException {
        try {
            return authService.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void register(ClientObserver observer, String sessionID) {
            if (authService.validSession(sessionID)) {
                clients.add(observer);
            }
            try {
                System.out.println(getClientHost());
            } catch (ServerNotActiveException e) {
                e.printStackTrace();
            }
    }

    /**
     * Notifies observers, part of the Observer pattern but is only called by other client-friendly methods.
     *
     * @param holder is the holder that has been created/changed
     * @throws RemoteException
     */
    private void notifyObservers(Holder holder) throws RemoteException {
        Thread notifyObserversThread = new Thread(() -> {
            for (ClientObserver client : clients) {
                try {
                    client.notify(holder);
                } catch (ConnectException e) {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        notifyObserversThread.start();
    }

    /**
     * Notifies the clients about the removal of a task.
     *
     * @param taskHolder is the Taskholder that has been deleted
     * @throws RemoteException
     */
    private void notifyObserversAboutRemoval(TaskHolder taskHolder) throws RemoteException {
        Thread notifyObserversThread = new Thread(() -> {
            for (ClientObserver client : clients) {
                try {
                    client.remove(taskHolder);
                } catch (ConnectException e) {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        notifyObserversThread.start();
    }

    @Override
    public List<MessageHolder> getAllMessages(String sessionID) throws RemoteException {
        System.out.println("getAllmessages started");
        ArrayList<MessageHolder> messageHolders = new ArrayList<>();
        if (authService.validSession(sessionID)) {
            try {
                ArrayList<Message> messages = Message.getAll();
                for (Message m : messages) {
                    MessageHolder messageHolder = new MessageHolder(m.messageText);
                    messageHolder.createdBy = m.createdBy.username;
                    messageHolder.createdAt = m.createdAt;
                    messageHolders.add(messageHolder);
                }
                System.out.println("getAllMessages done");
                return messageHolders;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<TaskHolder> getAllTasks(String sessionID) throws RemoteException {
        System.out.println("getAllTasks started");
        List<TaskHolder> taskHolders = new ArrayList<>();
        if (authService.validSession(sessionID)) {
            try {
                ArrayList<Task> tasks = Task.getAll();
                for (Task t : tasks) {
                    TaskHolder taskHolder = new TaskHolder(t.TASK_TYPE, t.taskText);
                    taskHolder.createdBy = t.createdBy.username;
                    taskHolder.createdAt = t.createdAt;
                    taskHolder.taskID = t.taskID;
                    taskHolders.add(taskHolder);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("getAllTasks done");
            return taskHolders;
        }
        return null;
    }

    @Override
    public TaskHolder addTask(TaskHolder taskHolder, String sessionID) throws RemoteException {
        try {
            Task task = Task.create(Project.find(1), taskHolder.TASK_TYPE,
                    authService.getUserBySessionID(sessionID), LocalDateTime.now(), taskHolder.taskText);
            taskHolder.taskID = task.taskID;
            System.out.println("addTask: " + taskHolder.taskID);
            this.notifyObservers(taskHolder);
            return taskHolder;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setTask(TaskHolder taskHolderWithID, String sessionID) throws RemoteException {
        Runnable setTask = () -> {
            if (taskHolderWithID.taskID != -1 && authService.validSession(sessionID)) {

                try {
                    notifyObservers(taskHolderWithID);
                    if (taskHolderWithID.TASK_TYPE.equals("DOIN")) {
                        Task.setTaskToDoing(taskHolderWithID.taskID);
                    } else if (taskHolderWithID.TASK_TYPE.equals("DONE")) {
                        Task.setTaskToDone(taskHolderWithID.taskID);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        };

        Thread setTaskThread = new Thread(setTask);
        setTaskThread.start();
    }

    @Override
    public void deleteTask(TaskHolder taskHolderWithID, String sessionID) throws RemoteException {
        Runnable deleteTask = () -> {
            if (authService.validSession(sessionID)) {
                try {
                    notifyObserversAboutRemoval(taskHolderWithID);
                    Task.delete(taskHolderWithID.taskID);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread deleteTaskThread = new Thread(deleteTask);
        deleteTaskThread.start();
    }

    @Override
    public void addMessage(MessageHolder messageHolder, String sessionID) throws RemoteException {

        if (authService.validSession(sessionID)) {
            messageHolder.createdBy = authService.getUserBySessionID(sessionID).username;
            try {
                Message.create(User.find(messageHolder.createdBy), messageHolder.messageText, LocalDateTime.now(),
                        Project.find(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.notifyObservers(messageHolder);
        }
    }
}
