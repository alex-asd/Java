package CourseAssignment.view;

import javax.naming.ldap.Control;

import CourseAssignment.controller.ClientController;
import CourseAssignment.controller.Controller;

public class ClientView implements View
{
   private ClientController controller;

   public ClientView()
   {
   }
   
   public void start(Controller controller)
   {
      this.controller = (ClientController)controller;
   }
}
