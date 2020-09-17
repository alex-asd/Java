import java.io.Serializable;
import java.util.ArrayList;

public class Garage implements Serializable
{
   ArrayList<Bus> busses;
   
   public Garage()
   {
      busses =new ArrayList<Bus>();
   }
   
   public void addBus(Bus bus)
   {
      busses.add(bus);
   }
   
   public void removeBus(Bus bus)
   {
      busses.remove(bus);
   }
   
   public Bus getBusByIndex(int index)
   {
	   return busses.get(index);
   }
   
   public ArrayList<Bus> busByType(String type)
   {
      ArrayList<Bus> temp = new ArrayList<Bus>();
      
      for (int i = 0; i < busses.size(); i++)
      {
         if(busses.get(i).getType().equals(type))
            temp.add(busses.get(i));
      }
      return temp;
   }
   
   public Garage bussesByType(String type)
   {
      Garage temp = new Garage();
      
      for (int i = 0; i < busses.size(); i++)
      {
         if(busses.get(i).getType().equals(type))
            temp.addBus(busses.get(i));
      }
      return temp;
   }
   
   public ArrayList<Bus> busByCapacity(int capac)
   {
      ArrayList<Bus> temp = new ArrayList<Bus>();
      
      for (int i = 0; i < busses.size(); i++)
      {
         if(busses.get(i).getCapacity()>=capac)
            temp.add(busses.get(i));
      }
      return temp;
   }
   
   public ArrayList<Bus> busByTypeNCapacity(String type, int capac)
   {
      ArrayList<Bus> temp = new ArrayList<Bus>();
      
      for (int i = 0; i < busses.size(); i++)
      {
         if(busses.get(i).getCapacity()>=capac && busses.get(i).getType().equals(type))
            temp.add(busses.get(i));
      }
      return temp;
   }
   
   public String toString()
   {
      String str="";
      for (int i = 0; i < busses.size(); i++)
      {
         str+=busses.get(i).toString() + "\n";
      }
      return str;
   }

   public int size() 
   {
	   return busses.size();
   }
   
}
