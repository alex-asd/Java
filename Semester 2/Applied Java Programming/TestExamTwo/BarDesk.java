// Question 3.1 (about 15%)
public class BarDesk implements IBarDesk
{
   private int numberOfEmptyGlasses = 0;
   private int numberOfFullGlasses = 50;

   public synchronized void takeFullGlass()
   {
      while (numberOfFullGlasses <= 0)
      {
         try
         {
            System.out.println("--| " + Thread.currentThread().getName()
                  + " is waiting for a glass");
            wait();
         }
         catch (InterruptedException e)
         {
         }
      }
      numberOfFullGlasses--;
      System.out.println("--> " + Thread.currentThread().getName()
            + " takes a glass of beer (" + numberOfFullGlasses
            + " full glasses)");
   }

   public synchronized void placeEmptyGlass()
   {
      numberOfEmptyGlasses++;
      notifyAll();
      System.out.println("--> " + Thread.currentThread().getName()
            + " finished drinking and places the glass on the desk (" + numberOfEmptyGlasses
            + " empty glasses)");
   }

   public synchronized void takeEmptyGlass()
   {
      while (numberOfEmptyGlasses <= 0)
      {
         try
         {
            System.out.println("--| " + Thread.currentThread().getName()
                  + " is waiting to clean a glass");
            wait();
         }
         catch (InterruptedException e)
         {
         }
      }
      System.out.println("--> " + Thread.currentThread().getName()
            + " cleanes a glass (" + numberOfEmptyGlasses
            + " empty glasses)");
      numberOfEmptyGlasses--;
   }

   public synchronized void placeFullGlass()
   {
      numberOfFullGlasses++;
      notifyAll();
      System.out.println("--> " + Thread.currentThread().getName()
            + " filles a glass (" + numberOfFullGlasses
            + " full glasses)");
   }
}
