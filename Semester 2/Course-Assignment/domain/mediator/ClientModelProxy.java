package CourseAssignment.domain.mediator;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientModelProxy
{
   public ClientModelProxy()
   {
      final int PORT = 9090;
      final String HOST = "localhost";
      
      Scanner in = new Scanner(System.in);
      
      try
      {
         System.out.println("Plese specify the client name ...");
         
         String name = in.nextLine();
         
         System.out.println("Client " + name + " connected to server...");
         
         Socket socket = new Socket(HOST, PORT);
         
         ClientReceiver clientTh = new ClientReceiver(socket);
         
         Thread cThread = new Thread(clientTh);
         
         cThread.start();
      }
      catch (UnknownHostException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
   
   public void addInHistory(String action)
   {
      
   }
}
