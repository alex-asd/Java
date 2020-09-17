package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class ServerMain {
    public static void main(String[] args) {

        int port = 1099;

        for (String arg : args) {
            port = Integer.valueOf(arg);
        }

        try {
            RMIServer rmiServer = new RMIServer(port);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
