package Common;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Methods implemented by the client for the server to call. The notify method is part of the Observer
 * pattern.
 * @author Apinayan Mohanathas
 */

public interface ClientObserver extends Remote {

    /**
     * Notifies the client about the presence of a new Holder object. Part of a standard implementation of the Observer
     * pattern.
     *
     * @param holder is the holder that has been created/Changed
     * @throws RemoteException
     */
    void notify(Holder holder) throws RemoteException;

    /**
     * Notifies the client about the removal of a TaskHolder object.
     * @param taskHolder is the task holder that has been deleted
     * @throws RemoteException
     */
    void remove(TaskHolder taskHolder) throws RemoteException;
}
