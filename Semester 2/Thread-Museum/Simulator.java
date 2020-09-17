public class Simulator
{

   public static void main(String[] args)
   {
      final int NUMBER_OF_VISITORS = 12;
      final int MAX_NUMBER_OF_VISITOR_PER_GROUP = 5;

      Museum museum = new Museum(MAX_NUMBER_OF_VISITOR_PER_GROUP);
      
      Thread tourThread = new Thread(new TourGuide(museum), "Guide");
      tourThread.start();

      Thread[] visitorThreads = new Thread[NUMBER_OF_VISITORS];
      for (int i = 0; i < visitorThreads.length; i++)
      {
         Visitor visitor = new Visitor(museum);
         visitorThreads[i] = new Thread(visitor, "Visitor " + (i + 1));
         visitorThreads[i].start();
      }

   }
}
