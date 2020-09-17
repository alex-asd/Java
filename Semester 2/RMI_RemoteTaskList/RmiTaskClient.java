import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RmiTaskClient extends UnicastRemoteObject
{
   private RemoteTaskList tasks;

   public RmiTaskClient() throws RemoteException
   {
      super();
      try
      {
         tasks = (RemoteTaskList) Naming
               .lookup("rmi://localhost:1099/tasks");
         System.out.println("client = " + this);

       }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public void start() throws RemoteException

   {
      Scanner input = new Scanner(System.in);
      System.out
            .println("Add tasks on the console...(count = size of task list)");
      while (true)
      {
         String task = input.nextLine();
         if (task.equalsIgnoreCase("count"))
            System.out.println("Task size = " + tasks.size());
         else if (task.equalsIgnoreCase("get"))
            System.out.println("You got the task: " + tasks.remove());
         else
            tasks.add(task);
      }

   }

   public static void main(String[] args) throws RemoteException
   {
      RmiTaskClient client = new RmiTaskClient();
      client.start();
   }
}
