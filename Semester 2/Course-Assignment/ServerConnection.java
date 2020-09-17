package CourseAssignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Observable;

public class ServerConnection implements Runnable
{
   private ObjectInputStream input;
   private ObjectOutputStream output;
   private RouteList routeList;
   
   public ServerConnection(Socket socket)
   {
      try
      {
         input = new ObjectInputStream(socket.getInputStream());
         output = new ObjectOutputStream(socket.getOutputStream());
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void run()
   {
      routeList = new RouteList(1);
      
      while (true) {
         
         RouteList routes = new RouteList(0);
         
         try
         {
            Interval interval = (Interval)input.readObject();
            
            for (int i = 0; i < routeList.size(); i++)
               if ((new Interval(routeList.getRoute(i).getStartOnDate(), routeList.getRoute(i).GetEndOnDate())).inInterval(interval)) {
                  
                  routes.addRoute(routeList.getRoute(i));
               }
            
            output.writeObject(routes);
         }
         catch (ClassNotFoundException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         catch (IOException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      }
      
   }

}
