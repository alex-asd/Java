import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable
{
   ArrayList<Reservation> reservations;
   
   public ReservationList()
   {
      reservations = new ArrayList<Reservation>();
   }
   
   public void addReservation(Reservation res)
   {
      reservations.add(res);
   }
   
   public void removeReservation(Reservation res)
   {
      reservations.remove(res);
   }
   
   public int numberOfReservations()
   {
      return reservations.size();
   }
   
   public ChauffeurList getAllAvailableChauffeurs(Date from, Date to, ChauffeurList list)
   {
	   ChauffeurList result = new ChauffeurList();
	   

	   for(int i=0; i<reservations.size(); i++)
	   {
		   Chauffeur tempch = reservations.get(i).getTrip().getChauffeur();
		   if(reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(from)
				   && reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(to))
		   {
			   result.addChauffeur(tempch);
		   }
		   else if((!reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(from))
				   && !(reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(to)))
		   {
	           result.addChauffeur(tempch);
	        }  
	   }
	   
	   for (int i = 0; i < result.size(); i++) 
	   {
		   for (int j = 0; j < list.size(); j++) 
		   {
			   if(!(result.getChauffeurAtIndex(i).equals(list.getChauffeurAtIndex(j))))
					   result.addChauffeur(list.getChauffeurAtIndex(j));
		}
	}
	   return result;
   }
	   
	   
//      ArrayList<Chauffeur> temp = new ArrayList<Chauffeur>();
//      
//      for(int i=0; i<reservations.size(); i++)
//      {
//         Chauffeur tempch = reservations.get(i).getTrip().getChauffeur();
//         if(reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(from)
//            && reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(to))
//         {
//            temp.add(tempch);
//         }
//         else if((!reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(from))
//               && !(reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(to)))
//         {
//            temp.add(tempch);
//         }  
//      }
//      return temp;
   
   
   public Garage getAllAvailableBuses(Date from, Date to, Garage list)
   {
      Garage temp = new Garage();
      
      for (int i = 0; i < reservations.size(); i++)
      {
         Bus tempb = reservations.get(i).getTrip().getBus();
         if(reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(from)
               && reservations.get(i).getTrip().getFirstDestination().getDepartureTime().isBefore(to))
            {
               temp.addBus(tempb);
            }
         else if((!reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(from))
               && !(reservations.get(i).getTrip().getLastDestination().getDepartureTime().isBefore(to)))
         {
            temp.addBus(tempb);
         } 
      }
      for (int i = 0; i < temp.size(); i++) 
	   {
		   for (int j = 0; j < list.size(); j++) 
		   {
			   if(!(temp.getBusByIndex(i).equals(list.getBusByIndex(j))))
					   temp.addBus(list.getBusByIndex(j));
		}
	}
      return temp;
   }
   
   public String toString()
   {
      String str="";
      for (int i = 0; i < reservations.size(); i++)
      {
         str+= "Reservation " +i+"\n" + reservations.get(i).toString() + "\n";
      }
      return str;
   }
}
