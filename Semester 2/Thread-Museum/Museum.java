public class Museum
{
   private int maxNumberInGroup;
   private boolean guiding;
   private int groupSize;

   public Museum(int maxNumberInGroup)
   {
      this.maxNumberInGroup = maxNumberInGroup;
      this.guiding = false;
      this.groupSize = 0;
   }

   public synchronized void enter()
   {
      while (guiding || groupSize >= maxNumberInGroup)
      {
         try
         {
            System.out.println("WAITING FOR A GUIDED TOUR: "
                  + Thread.currentThread().getName() + " guiding=" + guiding
                  + ", size=" + groupSize);
            wait();
         }
         catch (InterruptedException e)
         {
            // nothing
         }
      }
      groupSize++;
      if (groupSize == 1)
      {
         notifyAll();
      }
      while (!guiding)
      {
         try
         {
            System.out.println("WAITING IN A GROUP: "
                  + Thread.currentThread().getName() + " guiding=" + guiding
                  + ", size=" + groupSize);
            wait();
         }
         catch (InterruptedException e)
         {
            // nothing
         }
      }
      while (guiding)
      {
         try
         {
            System.out.println("ON A GUIDED TOUR: "
                  + Thread.currentThread().getName() + " guiding=" + guiding
                  + ", size=" + groupSize);
            wait();
         }
         catch (InterruptedException e)
         {
            // nothing
         }
      }
   }

   public synchronized void startTour()
   {
      while (groupSize <= 0)
      {
         try
         {
            System.out.println("--| WAITING FOR VISITORS: "
                  + Thread.currentThread().getName() + " guiding=" + guiding
                  + ", size=" + groupSize);
            wait();
         }
         catch (InterruptedException e)
         {
            // nothing
         }
      }
      this.guiding = true;
      notifyAll();
      System.out.println("--> STARTING THE GUIDED TOUR: "
            + Thread.currentThread().getName() + " guiding=" + guiding
            + ", size=" + groupSize);
   }

   public synchronized int endTour()
   {
      this.guiding = false;
      notifyAll();
      System.out.println("<-- ENDING THE GUIDED TOUR: "
            + Thread.currentThread().getName() + " guiding=" + guiding
            + ", size=" + groupSize);
      int size = groupSize;
      groupSize=0;
      return size;
   }

}
