import java.util.ArrayList;
public class Trip
{
   private String type;
   private ArrayList<Destination> destinations;
   private Bus bus;
   private Chauffeur chauffeur;
   
   public Trip(String type, Bus bus, Chauffeur chauffeur)
   {
      this.chauffeur = chauffeur;
      this.type = type;
      destinations = new ArrayList<Destination>();
      this.bus = bus;
   }
   
   public String getType()
   {
      return type;
   }
   
   public Bus getBus()
   {
      return bus;
   }
   
   public Chauffeur getChauffeur()
   {
      return chauffeur;
   }

   public Date from()
   {
      return destinations.get(0).getDepartureTime();
   }
   
   public Date to()
   {
      return destinations.get(destinations.size()-1).getArrivalTime();
   }
   
   public void addDestination(Destination destination)
   {
      destinations.add(destination);
   }
   
   public void removeDestinationByIndex(int index)
   {
      destinations.remove(index);
   }
   
   public int numberOfDestinations()
   {
      return destinations.size();
   }
   
   public void setStartAndFinishDestination()
   {
      for(int index=0; index<destinations.size(); index++)
      {
         destinations.get(index).setStartingPoint(false);
         destinations.get(index).setEndingPoint(false);
      }
      destinations.get(0).setStartingPoint(true);
      destinations.get(destinations.size()-1).setEndingPoint(true);
   }
   
   public Destination getLastDestination()
   {
      return destinations.get(destinations.size()-1);
   }
   
   public Destination getFirstDestination()
   {
      if(destinations.size()>=1){
      return destinations.get(0);
      } else {
         return null;
      }
   }
   
   public String toString()
   {
      String str="Type: " + type +"\n" +
                 "Chauffeur: " + chauffeur +"\n"+
                 "Bus: " + bus +"\n";

      for (int i = 0; i < destinations.size(); i++)
      {
         str += destinations.get(i).toString() + "\n" + "\n";
      }
      return str;
   }
   
}
