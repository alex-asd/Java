package system.domain.mediator;

import java.util.Observable;

import system.domain.model.Message;
import system.domain.model.MessageList;


public class ModelManager extends Observable implements Model
{
   private MessageList list;
 
   public ModelManager()
   {
      list = new MessageList();
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
