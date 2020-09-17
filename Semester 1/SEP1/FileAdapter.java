import java.io.FileNotFoundException;
import java.io.IOException;

public class FileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   public FileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   // Use the MyFileIO class to retrieve a StudentList object with all Students
   public ChauffeurList getAllChauffeurs()
   {
      ChauffeurList chauffeurs = new ChauffeurList();

      try
      {
         chauffeurs = (ChauffeurList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return chauffeurs;
   }

   // Use the MyFileIO class to retrieve a StudentList object with all Students
   // from the given country
   public ChauffeurList getChauffeursWithPref(String preference)
   {
      ChauffeurList chauffeurs = new ChauffeurList();

      try
      {
         ChauffeurList result = (ChauffeurList) mfio
               .readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            for (int j = 0; j < result.getChauffeurAtIndex(i).getNumberOfPref(); j++)
            {
               if (result.getChauffeurAtIndex(i).preferenceByIndex(j)
                     .equals(preference))
               {
                  chauffeurs.addChauffeur(result.getChauffeurAtIndex(i));
               }
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return chauffeurs;
   }

   // Use the MyFileIO class to save all Students in the StudentList object
   public void saveChauffeurs(ChauffeurList chauffeurs)
   {
      try
      {
         mfio.writeToFile(fileName, chauffeurs);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

   public ReservationList getAllReservations()
   {
      ReservationList reserv = new ReservationList();

      try
      {
         reserv = (ReservationList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return reserv;
   }

   public void saveReservations(ReservationList reservations)
   {
      try
      {
         mfio.writeToFile(fileName, reservations);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
   
   public void saveGarage(Garage garage)
   {
      try
      {
         mfio.writeToFile(fileName, garage);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

   public CustomerList getAllCustomers()
   {
      CustomerList cust = new CustomerList();

      try
      {
         cust = (CustomerList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return cust;
   }
   
   public void saveCustomers(CustomerList customers)
   {
      try
      {
         mfio.writeToFile(fileName, customers);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

   public Garage getBussesWithType(String type)
   {
      Garage busses = new Garage();

      try
      {
         Garage temp = (Garage) mfio.readObjectFromFile(fileName);
         busses = temp.bussesByType(type);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return busses;
   }
   
   public Garage getAllBusses()
   {
      Garage gar = new Garage();

      try
      {
         gar = (Garage) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return gar;
   }

   // Add more methods to the adapter depending on what you wish to do
}
