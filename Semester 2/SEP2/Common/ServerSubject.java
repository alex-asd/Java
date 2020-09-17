package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Methods implemented by the server for the client to call. The register method is
 * part of the Observer pattern. Note that the notifyObservers method is internally implemented in the server-side
 * class implementing this interface and is here wrapped by more client-friendly methods.
 * wrapped by methods more meaningful
 *
 * @author Apinayan Mohanathas
 */

public interface ServerSubject extends Remote {

    /**
     * Validates the user and returns a sessionID.
     * @param username is the username of a given user
     * @param password is the password of a given user
     * @return
     * @throws RemoteException
     */
    String login(String username, String password) throws RemoteException;

    /**
     * Registers the client as an observer if given a valid sessionID.
     * @param observer is the observer that needs to be added to the observer list
     * @param sessionID is the ID that identifies the session
     * @throws RemoteException
     */
    void register(ClientObserver observer, String sessionID) throws RemoteException;

    /**
     * Returns all messages as a list of MessageHolders if given a valid sessionID;
     * @param sessionID is the ID that identifies the session
     * @return list of MessageHolders
     * @throws RemoteException
     */
    List<MessageHolder> getAllMessages(String sessionID) throws RemoteException;

    /**
     * Returns all tasks as a list of TaskHolders if given a valid sessionID.
     * @param sessionID is the ID that identifies the session
     * @return list of TaskHolders
     * @throws RemoteException
     */
    List<TaskHolder>  getAllTasks(String sessionID) throws RemoteException;

    /**
     * Adds a new Task to the database and calls notifyObservers if given a TaskHolder and a valid sessionID.
     * @param taskHolder is the list of tasks
     * @param sessionID is the ID that identifies the session
     * @return TaskHolder
     * @throws RemoteException
     */
    TaskHolder addTask(TaskHolder taskHolder, String sessionID)
            throws RemoteException;

    /**
     * Sets the type (todos, doing, done) of an existing task if given a valid sessionID
     * @param taskHolderWithID is the unique ID that identifies the task holder
     * @param sessionID is the ID that identifies the session
     * @throws RemoteException
     */
    void setTask(TaskHolder taskHolderWithID, String sessionID) throws RemoteException;

    /**
     * Deletes an existing task if given a valid sessionID.
     * @param taskHolderWithID is the unique ID that identifies the task holder
     * @param sessionID is the ID that identifies the session
     * @throws RemoteException
     */
    void deleteTask(TaskHolder taskHolderWithID, String sessionID) throws RemoteException;

    void addMessage(MessageHolder messageHolder, String sessionID) throws RemoteException;
}
