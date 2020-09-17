package CourseAssignment.domain.mediator;

public class ClientModelManager implements Model
{
   private ClientModelProxy proxy;
   
   public ClientModelManager()
   {
      proxy = new ClientModelProxy();
   }

   @Override
   public void addInHistory(String action)
   {
      proxy.addInHistory(action);
      
   }

   @Override
   public void notifyAboutChange()
   {
      // TODO Auto-generated method stub
      
   }
}
