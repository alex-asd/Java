package system.controller;

import java.util.Observable;

import system.domain.mediator.Model;
import system.domain.model.*;
import system.view.View;


public class MessageController implements Controller
{
   private Model model;
   private View view; 

   public MessageController(Model model, View view)
   {
      this.model = model;
      this.view = view;   
      ((Observable) this.model).addObserver(view);
   }

   public void execute(String what)
   {
      switch (what)
      {
         case "Send":
            String input = view.getAndRemoveInput();
            if (input.length() > 0)
            {
               model.addMessage(new Message(input));
            }
            break;
         case "Quit":
            System.exit(0);
      }
   }

}