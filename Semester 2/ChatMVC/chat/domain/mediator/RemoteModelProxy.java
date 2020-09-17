package chat.domain.mediator;

import java.net.ServerSocket;
import java.net.Socket;

public class RemoteModelProxy implements Runnable
{
   private static final int PORT = 2910;
   private Model model;

   public RemoteModelProxy(Model model)
   {
      this.model = model;
   }

   public void run()
   {
      int count = 1;
      try
      {
         System.out.println("Starting Server...");

         // create welcoming socket at specified port
         ServerSocket welcomeSocket = new ServerSocket(PORT);
         while (true)
         {
            System.out.println("Waiting for a client...");

            // Wait, on welcoming socket for contact by client
            Socket connectionSocket = welcomeSocket.accept();

            // Start a thread with the client communication
            ServerCommunication c = new ServerCommunication(
                  connectionSocket, model);
            new Thread(c, "Communication #" + count).start();
            count++;

         }
      }
      catch (Exception e)
      {
         System.out.println("Exception in connection to server: "
               + e.getMessage());
         // e.printStackTrace();
      }
   }

}