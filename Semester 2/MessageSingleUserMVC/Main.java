import system.controller.Controller;
import system.controller.MessageController;
import system.domain.mediator.Model;
import system.domain.mediator.ModelManager;
import system.view.MessageView;
import system.view.View;

public class Main
{
   public static void main(String args[])
   {
      try
      {
         Model model = new ModelManager();
         View view = new MessageView();
         Controller controller = new MessageController(model, view);

         view.start(controller);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
