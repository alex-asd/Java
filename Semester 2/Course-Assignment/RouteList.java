package CourseAssignment;

import java.io.Serializable;
import java.util.ArrayList;

public class RouteList implements Serializable
{
   public ArrayList<Route> routes;
   
   public RouteList(int x)
   {
      if (x == 0) {
         
         routes = new ArrayList<Route>();
         
         return;
         
      }
      
      routes = new ArrayList<Route>();
      
      routes.add(new Route("Horsens", "Billund", new Date(20, 4, 2017), new Date(24, 4, 2017), "Aleksandar", "luxury-bus"));
      routes.add(new Route("Billund", "Horsens", new Date(25, 4, 2017), new Date(26, 4, 2017), "Hristo", "bus"));
      routes.add(new Route("Horsens", "Hamburg", new Date(18, 4, 2017), new Date(23, 4, 2017), "Robert", "luxury-bus"));
      routes.add(new Route("Horsens", "Paris", new Date(28, 4, 2017), new Date(29, 4, 2017), "Andrei", "luxury-bus"));
      routes.add(new Route("Horsens", "Vejle", new Date(10, 5, 2017), new Date(14, 5, 2017), "Hristo", "mini-bus"));
      routes.add(new Route("Horsens", "Arhus", new Date(2, 5, 2017), new Date(3, 5, 2017), "Robert", "bus"));
      routes.add(new Route("Horsens", "Frankfurt", new Date(1, 5, 2017), new Date(3, 5, 2017), "Valentin", "luxury-bus"));
      routes.add(new Route("Horsens", "Alburg", new Date(28, 4, 2017), new Date(1, 5, 2017), "Valentin", "bus"));
      routes.add(new Route("Horsens", "Dublin", new Date(27, 4, 2017), new Date(27, 4, 2017), "Andrei", "bus"));
      routes.add(new Route("Arhus", "Billund", new Date(3, 5, 2017), new Date(3, 5, 2017), "Hristo", "luxury-bus"));
   }
   
   public void addRoute(Route route)
   {
      routes.add(route);
   }
   
   public int size()
   {
      return routes.size();
   }
   
   public Route getRoute(int index)
   {
      return routes.get(index);
   }
}
