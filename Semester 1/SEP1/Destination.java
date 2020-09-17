
public class Destination
{
   private Date departureTime;
   private Date arrivalTime;
   private String location;
   private boolean startingPoint;
   private boolean endingPoint;
   
   public Destination(Date departureTime, Date arrivalTime, String location)
   {
      startingPoint = false;
      endingPoint = false;
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
      this.location = location;
   }

   public Date getDepartureTime()
   {
      return departureTime;
   }

   public void setDepartureTime(Date departureTime)
   {
      this.departureTime = departureTime;
   }

   public Date getArrivalTime()
   {
      return arrivalTime;
   }

   public void setArrivalTime(Date arrivalTime)
   {
      this.arrivalTime = arrivalTime;
   }

   public String getLocation()
   {
      return location;
   }

   public void setLocation(String location)
   {
      this.location = location;
   }
   
   public void setStartingPoint(boolean startingPoint)
   {
      this.startingPoint = startingPoint;
   }
   
   public void setEndingPoint(boolean endingPoint)
   {
      this.endingPoint = endingPoint;
   }
   
   public String toString()
   {
         if(startingPoint){
            return "Location: " + location +"\n"+
                   "Departure: " + departureTime;
         }
         
         else if(endingPoint) {
            return "Location: " + location +"\n"+
                   "Arrival: " + arrivalTime+"\n";
         }
         
         else{
            return "Location: " + location +"\n"+
                   "Arrival: " + arrivalTime+"\n"+
                   "Departure: " + departureTime+"\n";   
         }
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Destination))
         return false;
      
      Destination other = (Destination)obj;
      return departureTime.equals(other.departureTime) && arrivalTime.equals(other.arrivalTime)
            && location.equals(other.location);
   }
     
}
