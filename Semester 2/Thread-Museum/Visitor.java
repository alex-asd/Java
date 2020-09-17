public class Visitor implements Runnable
{
   private Museum museum;

   public Visitor(Museum museum)
   {
      this.museum = museum;
   }

   @Override
   public void run()
   {
      museum.enter();
   }
}
