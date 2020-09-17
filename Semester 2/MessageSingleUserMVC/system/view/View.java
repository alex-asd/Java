package system.view;

import java.util.Observer;

import system.controller.Controller;

public interface View extends Observer
{
   public void start(Controller controller);
   public String getAndRemoveInput();
}
