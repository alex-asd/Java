package CourseAssignment.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

import CourseAssignment.ServerConnection;

public class Server implements Runnable
{
   private Model model;
   
   public Server(Model model)
   {
      this.model = model;
   }
   
   public void run()
   {
      try
      {
         ServerSocket welcomeSocket = new ServerSocket(9090);
         
         System.out.println("Starting server ...\n");
         
         while (true) {
            
            System.out.println("Waiting for client");

            Socket socket = welcomeSocket.accept();
            
            ServerConnection con = new ServerConnection(socket);
            
            Thread thread = new Thread(con);
            
            thread.start();
            
         }
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
