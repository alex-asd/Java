public class Task2
{
   // Question 2.1
   public static int linearSearch(int[] arr, int key, int left, int right)
   {
      // precondition: arr is sorted and not empty, 0 <= left <= right <
      // arr.length
      // return: index of fist occurrence of key or -1 if not found

      for (int i = left; i <= right; i++)
      {
         if (arr[i] == key)
         {
            return i;
         }
         if (arr[i] > key)
         {
            return -1;
         }
      }
      return -1;
   }

   // Question 2.2
   public static int binarySearch(int[] arr, int key, int left, int right)
   {
      // precondition: arr is sorted and not empty, 0 <= left <= right <
      // arr.length
      // return: an index of the key or -1 if not found

      if (left > right)
      {
         return -1;
      }

      int mid = (left + right) / 2;
      if (arr[mid] == key)
      {
         return mid;
      }
      if (arr[mid] < key)
      {
         return binarySearch(arr, key, mid + 1, right);
      }
      else
      {
         return binarySearch(arr, key, left, mid - 1);
      }
   }

   // Question 2.3
   public static int binarySearchV2(int[] arr, int key, int left, int right)
   {
      // precondition: arr is sorted and not empty, 0 <= left <= right <
      // arr.length
      // return: an index of the key or -1 if not found

      if (right - left + 1 < 10)
      {
         return linearSearch(arr, key, left, right);
      }

      int mid = (left + right) / 2;
      if (arr[mid] == key)
      {
         return mid;
      }
      if (arr[mid] < key)
      {
         return binarySearchV2(arr, key, mid + 1, right);
      }
      else
      {
         return binarySearch(arr, key, left, mid - 1);
      }
   }
}
