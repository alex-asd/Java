package system.domain.mediator;

import system.domain.model.Message;

public interface Model
{
   public void addMessage(Message message);
   public void notifyAboutMessage(Message message);
}
