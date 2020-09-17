// Question 3.2 (about 10% for both Customer and Bartender)
public class Bartender implements Runnable
{
   private IBarDesk bar;

   public Bartender(IBarDesk bar)
   {
      this.bar = bar;
   }

   public void run()
   {
      System.out.println(Thread.currentThread().getName() + ": is at work");
      while (true)
      {
         bar.takeEmptyGlass();
         System.out.println(Thread.currentThread().getName() + ": starts cleaning an empty glass");

         action("CLEAN GLASS", 10000, 20000);

         System.out.println(Thread.currentThread().getName() + ": has cleaned and filled a glass");
         bar.placeFullGlass();
      }
   }

   private void action(String action, int minTime, int maxTime)
   {
      System.out.println(Thread.currentThread().getName() + ": " + action);
      int time = (int) (Math.random() * (maxTime - minTime) + minTime);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }

}