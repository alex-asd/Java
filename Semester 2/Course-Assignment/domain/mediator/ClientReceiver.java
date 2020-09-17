package CourseAssignment.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import CourseAssignment.Date;
import CourseAssignment.Interval;
import CourseAssignment.RouteList;

public class ClientReceiver implements Runnable
{
   private ObjectInputStream input;
   private ObjectOutputStream output;
   
   public ClientReceiver(Socket socket)
   {
      try
      {
         output = new ObjectOutputStream(socket.getOutputStream());
         input = new ObjectInputStream(socket.getInputStream());  
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   private Date toDate(String s)
   {
      return new Date((s.charAt(0) - 48) * 10 + s.charAt(1) - 48, (s.charAt(3) - 48) * 10 + s.charAt(4) - 48,
            (s.charAt(6) - 48) * 1000 + (s.charAt(7) - 48) * 100 + (s.charAt(8) - 48) * 10 + s.charAt(9) - 48);
   }
   
   private boolean digit(char c)
   {
      return c >= '0' && c <= '9';
   }
   
   private boolean isGood(String s)
   {
      if (s.length() != 10) return false;
      
      return digit(s.charAt(0)) && digit(s.charAt(1)) && digit(s.charAt(3)) && digit(s.charAt(4)) && digit(s.charAt(6)) && digit(s.charAt(7)) && digit(s.charAt(8)) && digit(s.charAt(9));
   }
   
   @Override
   public void run()
   {
      Scanner in = new Scanner(System.in);
      
      System.out.println("           You are in       \n");
      System.out.println("----------------------------\n");
      
      while (true) {
         
         String startDate;
         
         do {
            
            System.out.println("Starting date...");
            
            startDate = in.nextLine();
            
         } while (!isGood(startDate));
         
         String endDate;
         
         do {
            
            System.out.println("End date...");
               
            endDate = in.nextLine();
         
         } while (!isGood(endDate));
            
         Interval interval = new Interval(toDate(startDate), toDate(endDate));
         
         try
         {
            output.writeObject(interval);
            
            RouteList routes = (RouteList)input.readObject();
            
            for (int i = 0; i < routes.size(); i++)
               System.out.println((i + 1) + ". " + routes.getRoute(i));
            
            if (routes.size() == 0) System.out.println("No routes in this interval " + interval);
            
            System.out.println("----------------------------");
         }
         catch (Exception e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }
   }
   
}
