package CourseAssignment.view;

import CourseAssignment.controller.Controller;
import CourseAssignment.controller.ServerController;

public class ServerView implements View
{
   private ServerController controller;
   
   public void ServerView()
   {
   }
   
   @Override
   public void start(Controller controller)
   {
      this.controller = (ServerController)controller;
   }
   
}
