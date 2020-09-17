package CourseAssignment;

import CourseAssignment.controller.ClientController;
import CourseAssignment.controller.Controller;
import CourseAssignment.domain.mediator.ClientModelManager;
import CourseAssignment.view.ClientView;
import CourseAssignment.view.View;

public class ClientMain
{
   public static void main(String[] args)
   {
      ClientModelManager model = new ClientModelManager();
      
      View view = new ClientView();
      
      Controller controller = new ClientController(model, view);
      
      view.start(controller);
   }
}
