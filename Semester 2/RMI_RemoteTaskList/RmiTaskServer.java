import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiTaskServer extends UnicastRemoteObject implements RemoteTaskList
{
   private TaskList taskList;

   public RmiTaskServer() throws RemoteException
   {
      super();
      taskList = new TaskList();
   }

   public static void main(String[] args)
   {
      try
      {
         Registry reg = LocateRegistry.createRegistry(1099);
         RemoteTaskList server = new RmiTaskServer();
         Naming.rebind("tasks", server);
         System.out.println("Starting server...");
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void add(String task) throws RemoteException
   {
      taskList.add(task);
      System.out.println("add " + task);
    }

   @Override
   public String remove() throws RemoteException
   {
      String task = taskList.getAndRemoveNextTask();
      System.out.println("remove " + task);
      return task;
   }

   @Override
   public int size() throws RemoteException
   {
      System.out.println("size ");
      return taskList.size();
   }

 
}
