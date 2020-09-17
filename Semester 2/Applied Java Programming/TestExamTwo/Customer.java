// Question 3.2 (about 10% for both Customer and Bartender)
public class Customer implements Runnable
{
   private IBarDesk bar;

   public Customer(IBarDesk bar)
   {
      this.bar = bar;
   }

   public void run()
   {
      action("WALKING", 10000, 30000);

      System.out.println(Thread.currentThread().getName() + ": enters the bar");
      for (int i = 0; i < 10; i++)
      {
         bar.takeFullGlass();
         System.out.println(Thread.currentThread().getName() + ": starts drinking a beer");

         action("DRINKING", 10000, 30000);

         System.out.println(Thread.currentThread().getName() + ": returns an empty glass");
         bar.placeEmptyGlass();
      }
      System.out.println(Thread.currentThread().getName() + ": leaves the bar");
   }
   
   private void action(String action, int minTime, int maxTime)
   {
      System.out.println(Thread.currentThread().getName() + ": " + action);
      int time = (int)(Math.random()*(maxTime-minTime) + minTime);
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