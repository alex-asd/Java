package CourseAssignment.controller;

import CourseAssignment.domain.mediator.ClientModelManager;
import CourseAssignment.domain.mediator.Model;
import CourseAssignment.view.ClientView;
import CourseAssignment.view.View;

public class ClientController implements Controller
{
   private ClientModelManager model;
   private View view;
   
   public ClientController(Model model, ClientView view)
   {
      this.model = (ClientModelManager)model;
      this.view = (ClientView)view;
   }
   
   
}
