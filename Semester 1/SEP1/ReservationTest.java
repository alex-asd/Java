
public class ReservationTest
{
   public static void main(String[] args)
   {
      Address naIco = new Address("Zornica", "8", "Yambol");
      Chauffeur ico = new Chauffeur("Hristo", naIco, "MyId", "myEmail@abv.bg", "08999");
      
      Address naSashko = new Address("Kvartal", "3a", "Pernik");
      Chauffeur sashko = new Chauffeur("Alexander", naSashko, "moitoId", "GeinaKonnik@abv.bg", "09833");
      
      ico.addPreference("sex"); sashko.addPreference("sex");
      ico.addPreference("motori"); sashko.addPreference("jhin");
      Bus b1 = new Bus("party", 4, "A9881KH");
      Garage garage = new Garage();
      garage.addBus(b1);
      
      ChauffeurList cl = new ChauffeurList();
      cl.addChauffeur(ico); cl.addChauffeur(sashko);
      
      Date d1 = new Date(16, 12, 2016, 1, 0); Date d3 = new Date(16, 12, 2016, 15, 00);
      Date d2 = new Date(16, 12, 2016, 13, 00); Date d4 = new Date(16, 12, 2016, 16, 00);
      
      Destination bg = new Destination(d1, d2, "DK");
      Destination pernik = new Destination(d3, d4, "Pernik");
      
      Trip tr = new Trip("dovkyshti", b1, ico);
      tr.addDestination(bg); tr.addDestination(pernik);
      bg.setStartingPoint(true); pernik.setEndingPoint(true);;
      garage.removeBus(b1);
      
      Customer sasho = new Customer("Sasho", naSashko, "+35989", "mail@abv.bg");
      
      Reservation r1 = new Reservation(tr);
      r1.addCustomer(sasho, true);
      
      System.out.println(r1);
      
      
   }
}
