package chat.domain.mediator;

import java.util.Observable;

import chat.domain.model.Message;
import chat.domain.model.MessageList;


public class ServerModelManager extends Observable implements Model
{
   private MessageList list;
   private RemoteModelProxy server;
 
   public ServerModelManager()
   {
      list = new MessageList();
      this.server = new RemoteModelProxy(this);
      new Thread(server, "Server").start();
   }

   @Override
   public void addMessage(Message message)
   {
      list.add(message);
      notifyAboutMessage(message);
   }

   @Override
   public void notifyAboutMessage(Message message)
   {
      super.setChanged();
      super.notifyObservers(message);
   }

 
}
