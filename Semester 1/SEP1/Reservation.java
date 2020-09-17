import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable
{
   private Trip trip;
   private ArrayList<Customer> customers;
   private ArrayList<Passenger> passengers;
   
   public Reservation(Trip trip)
   {
      this.trip = trip;
      customers = new ArrayList<Customer>();
      passengers = new ArrayList<Passenger>();
   }
   
   public int maxCapacity()
   {
      return trip.getBus().getCapacity();
   }
   
   public String addPassenger(Object pass)
   {
      if(pass instanceof Customer)
      {
         Passenger temp = new Passenger(((Customer) pass).getName(), ((Customer) pass).getAddress());
         if(passengers.size()<maxCapacity())
         {
            passengers.add(temp);
            return "Passenger added"; 
         }
      }
      if(passengers.size()<maxCapacity())
         {
            passengers.add((Passenger)pass);
            return "Passenger added"; 
         }
      return "Sorry, capacity reached"; 
   }
   
   
   public String addCustomer(Customer cust, boolean isAPassenger)
   {
      if(isAPassenger)
      {
         addPassenger(cust);
         customers.add(cust);
         return "";
      }
      else
      {
        customers.add(cust);
        return "Customer added!"; 
      }
   }
   
   public void setTrip(Trip trip)
   {
      this.trip = trip;
   }
   
   public Trip getTrip()
   {
      return trip;
   }
   
   public String toString()
   {
      String str="";
      str +=trip.toString();
      
      str += "\n" + "Customers" + "\n";
       for (int i = 0; i < customers.size(); i++)
      {
         str+= customers.get(i).toString() + "\n";
      }     
       str+="Passengers" + "\n";
       for (int i = 0; i < passengers.size(); i++)
      {
         str+= passengers.get(i).toString() + "\n";
      }
       return str;     
   }
  
}
