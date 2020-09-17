public class TourGuide implements Runnable
{
   private Museum museum;

   public TourGuide(Museum museum)
   {
      this.museum = museum;
   }

   @Override
   public void run()
   {
      while (true)
      {
         museum.startTour();
         action("... GUIDED TOUR", 6000, 7000);
         museum.endTour();
      }
   }

   private void action(String action, int minTime, int maxTime)
   {
      // System.out.println("Action: " + action + " "
      // + Thread.currentThread().getName());
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
