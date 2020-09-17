package Client;

import Client.GUI.GeneralModel;
import Common.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Georgi Sariev
 * @author Vito ilchev
 */

public class RMIClient extends UnicastRemoteObject implements ClientObserver {
    private ServerSubject server;
    private String currentSessionID;
    private GeneralModel generalModel;


    public String getCurrentSessionID() {
        return currentSessionID;
    }

    public RMIClient(GeneralModel generalModel) throws RemoteException {
        super();
        this.generalModel = generalModel;
    }

    public void lookup(String hostname, int port) {
        try {
            server = (ServerSubject) Naming.lookup("rmi://"+hostname+":"+port+"/RemoteService");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public synchronized ServerSubject getServer() {
        return server;
    }


    public String login(String username, String password) throws RemoteException {
        this.currentSessionID = server.login(username, password);
        server.register(this, this.currentSessionID);
        return this.currentSessionID;
    }

    @Override
    public void notify(Holder holder) {
        if (holder instanceof  MessageHolder) {
            MessageHolder messageHolder = (MessageHolder) holder;
            Task<Void> messageAdder = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Platform.runLater(() ->
                            generalModel.getMessages().add(messageHolder.createdBy + ": " + messageHolder.messageText));
                    return null;
                }
            };
            Thread messageAdderThread = new Thread(messageAdder);
            messageAdderThread.start();
        } else if (holder instanceof  TaskHolder) {
            updateTaskLists((TaskHolder) holder);
        }
    }

    @Override
    public void remove(TaskHolder taskHolder) throws RemoteException {
        Task<Void> taskListItemRemover = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> {
                    if (taskHolder.TASK_TYPE.equals("TODO")) {
                        generalModel.getToDoList().getItems().remove(taskHolder);
                    } else if (taskHolder.TASK_TYPE.equals("DOIN")) {
                        generalModel.getDoingList().getItems().remove(taskHolder);
                    } else if (taskHolder.TASK_TYPE.equals("DONE")) {
                        generalModel.getDoneList().getItems().remove(taskHolder);
                    }
                });
                return null;
            }
        };
        Thread updateThread = new Thread(taskListItemRemover);
        updateThread.start();
    }

    public void updateTaskLists(TaskHolder taskHolder) {
        Task<Void> taskListUpdater = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> {
                    if (taskHolder.TASK_TYPE.equals("TODO")) {
                        generalModel.getToDoList().getItems().add(taskHolder);
                    } else if (taskHolder.TASK_TYPE.equals("DOIN")) {
                        generalModel.getDoingList().getItems().add(taskHolder);
                        generalModel.getToDoList().getItems().remove(taskHolder);
                    } else if (taskHolder.TASK_TYPE.equals("DONE")) {
                        generalModel.getDoneList().getItems().add(taskHolder);
                        generalModel.getDoingList().getItems().remove(taskHolder);
                    }
                });
                return null;
            }
        };

        Thread updateThread = new Thread(taskListUpdater);
        updateThread.start();
    }

    public void sendMessage(MessageHolder messageHolder) throws RemoteException {
        server.addMessage(messageHolder, getCurrentSessionID());
    }

    public List<MessageHolder> getAllMessages(String sessionID) {
        try {
            return server.getAllMessages(sessionID);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTask(TaskHolder taskHolder) {
        try {
            server.addTask(taskHolder, getCurrentSessionID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void getAllTasks(String sessionID) {
        try {
            List<TaskHolder> taskHolders = (List<TaskHolder>) server.getAllTasks(sessionID);
            for (TaskHolder tH : taskHolders) {
                updateTaskLists(tH);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setTask(TaskHolder taskHolder) {
        try {
            server.setTask(taskHolder, getCurrentSessionID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(TaskHolder taskHolder) {
        try {
            server.deleteTask(taskHolder, getCurrentSessionID());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void loadExistingItems() {
        new Thread(new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> {
                    getAllTasks(getCurrentSessionID());
                });
                return null;
            }
        }).start();

        new Thread (new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                List<MessageHolder> messageHolders = getAllMessages(getCurrentSessionID());
                for (MessageHolder mH : messageHolders) {
                    generalModel.getMessages().add(mH.toString());
                }
                return null;
            }
        }).start();
    }
}
