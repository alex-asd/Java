package chat.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

import chat.domain.model.*;

public class ClientModelProxy implements Model, Observer
{
   private ObjectInputStream inFromServer;
   private ObjectOutputStream outToServer;
   private Model model;
   private Socket socket;

   private static final String HOST = "localhost";
   private static final int PORT = 2910;

   public ClientModelProxy(Model model) throws IOException
   {
      this.model = model;
      try
      {
         socket = new Socket(HOST, PORT);
         outToServer = new ObjectOutputStream(socket.getOutputStream());
         inFromServer = new ObjectInputStream(socket.getInputStream());
         ClientReceiver reciever = new ClientReceiver(inFromServer, model);
         new Thread(reciever, "Reciever").start();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

   }

   @Override
   public void update(Observable arg0, Object arg1)
   {
      try
      {
         Message message = (Message) arg1;
         outToServer.writeObject(message);
      }
      catch (Exception e)
      {
         // no client connection
         System.out.println("DEBUG: Exception for client broadcast " + " - "
               + e.getMessage());
         ((Observable) model).deleteObserver(this);
         Message m = new Message("DEBUG: Server> A client has been disconnected");
         System.out.println("DEBUG: " + m);
         model.addMessage(m);
      }
   }

   @Override
   public void addMessage(Message message)
   {
      try
      {
         outToServer.writeObject(message);
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      System.out.println("DEBUG: Proxy Add: " + message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      // nothing   
   }
}
