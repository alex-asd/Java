public class Task1
{
   // Question 1.1
   public static double golden1(int n)
   {
      if (n <= 0)
      {
         return 1.0;
      }
      else
      {
         return 1.0 + 1.0 / golden1(n - 1);
      }
   }

   // Question 1.2
   public static double golden2(int n)
   {
      double result = 1.0;
      for (int i=1; i<=n; i++)
      {
         result = 1.0 + 1.0 / result;
      }
      return result;
   }

   public static void main(String[] args)
   {
      for (int i = 0; i < 10; i++)
      {
         System.out.printf("f(%d)=%f (%f)\n",i,golden1(i), golden2(i));
      }
   }
}
