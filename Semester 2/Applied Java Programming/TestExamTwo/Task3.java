// Question 3.3 (about 5%)
public class Task3
{
   private static final int NO_BARTENDERS = 2;
   private static final int NO_CUSTOMERS = 20;

   public static void main(String[] args)
   {
      IBarDesk bar = new BarDesk();

      for (int i = 0; i < NO_BARTENDERS; ++i)
      {
         new Thread(new Bartender(bar), "Bartender" + (i + 1)).start();
      }
      for (int i = 0; i < NO_CUSTOMERS; ++i)
      {
         new Thread(new Customer(bar), "Customer" + (i + 1)).start();
      }
   }
}
