public class Test2Main
{
   public static void main(String[] args)
   {
      int[] arr1 = { 14 };
      int[] arr2 = { 6, 7, 8, 14, 14, 15, 18, 24, 30 };
      int[] arr3 = new int[25];
      for (int i = 0; i < arr3.length; i++)
      {
         arr3[i] = i + 6;
      }
      System.out.println("is there");
      System.out.println(Task2.linearSearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearchV2(arr1, 14, 0, arr1.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr2, 14, 0, arr2.length - 1));
      System.out.println(Task2.binarySearch(arr2, 14, 0, arr2.length - 1));
      System.out.println(Task2.binarySearchV2(arr2, 14, 0, arr2.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr3, 14, 0, arr3.length - 1));
      System.out.println(Task2.binarySearch(arr3, 14, 0, arr3.length - 1));
      System.out.println(Task2.binarySearchV2(arr3, 14, 0, arr3.length - 1));
      System.out.println();

      // not there
      System.out.println("not there");
      System.out.println(Task2.linearSearch(arr1, 90, 0, arr1.length - 1));
      System.out.println(Task2.binarySearch(arr1, 90, 0, arr1.length - 1));
      System.out.println(Task2.binarySearchV2(arr1, 90, 0, arr1.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr2, 90, 0, arr2.length - 1));
      System.out.println(Task2.binarySearch(arr2, 90, 0, arr2.length - 1));
      System.out.println(Task2.binarySearchV2(arr2, 90, 0, arr2.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr3, 90, 0, arr3.length - 1));
      System.out.println(Task2.binarySearch(arr3, 90, 0, arr3.length - 1));
      System.out.println(Task2.binarySearchV2(arr3, 90, 0, arr3.length - 1));
 
      // first
      System.out.println("first");
      System.out.println(Task2.linearSearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearchV2(arr1, 14, 0, arr1.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr2, 6, 0, arr2.length - 1));
      System.out.println(Task2.binarySearch(arr2, 6, 0, arr2.length - 1));
      System.out.println(Task2.binarySearchV2(arr2, 6, 0, arr2.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr3, 6, 0, arr3.length - 1));
      System.out.println(Task2.binarySearch(arr3, 6, 0, arr3.length - 1));
      System.out.println(Task2.binarySearchV2(arr3, 6, 0, arr3.length - 1));

      // last
      System.out.println("last");
      System.out.println(Task2.linearSearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearch(arr1, 14, 0, arr1.length - 1));
      System.out.println(Task2.binarySearchV2(arr1, 14, 0, arr1.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr2, 30, 0, arr2.length - 1));
      System.out.println(Task2.binarySearch(arr2, 30, 0, arr2.length - 1));
      System.out.println(Task2.binarySearchV2(arr2, 30, 0, arr2.length - 1));
      System.out.println();

      System.out.println(Task2.linearSearch(arr3, 30, 0, arr3.length - 1));
      System.out.println(Task2.binarySearch(arr3, 30, 0, arr3.length - 1));
      System.out.println(Task2.binarySearchV2(arr3, 30, 0, arr3.length - 1));

   }

}
