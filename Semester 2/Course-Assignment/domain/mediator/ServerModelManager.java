package CourseAssignment.domain.mediator;

import java.util.Observable;

import CourseAssignment.domain.model.History;

public class ServerModelManager extends Observable implements Model
{
   private History history;

   public ServerModelManager()
   {
      Thread serverConnection = new Thread(new Server(this));
      
      serverConnection.start();
   }

   @Override
   public void addInHistory(String action)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void notifyAboutChange()
   {
      // TODO Auto-generated method stub
      
   }
}
