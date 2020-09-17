package Sorting;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main
{
   public static int[] t; 
   
   public static void merge(int[] t, int st, int dr, int m)
   {
      int current1 = st;
      int current2 = m + 1;
      int posToInsert = 0;
      
      int[] arr = new int[dr - st + 1];
      
      while (current1 <= m && current2 <= dr) {
         
         if (t[current1] < t[current2]) {
            
            arr[posToInsert] = t[current1]; current1++;
         } else {
            
            arr[posToInsert] = t[current2]; current2++;
            
         }
         
         posToInsert++;
         
      }
      
      while (current1 <= m) { arr[posToInsert] = t[current1]; current1++; posToInsert++; }
      
      while (current2 <= dr) { arr[posToInsert] = t[current2]; current2++; posToInsert++; }
      
      for (int i = st; i <= dr; i++) t[i] = arr[i - st];
   }
   
   public static void mergeSort(int[] t, int st, int dr)
   {
      if (st >= dr) return;
      
      int m = (st + dr) / 2;
      
      mergeSort(t, st, m);
      mergeSort(t, m + 1, dr);
      
      merge(t, st, dr, m);
   }
   
   public static int find(int[] t, int st, int dr)
   {
      int pivot = t[dr];
      int pos = st;
      
      for (int i = st; i < dr; i++)
         if (t[i] <= pivot) {
            
            int aux = t[pos]; t[pos] = t[i]; t[i] = aux;
            pos++;
         }
      
      int aux = t[pos]; t[pos] = t[dr]; t[dr] = aux;
      
      return pos;
   }
   
   public static void quickSort(int[] t, int st, int dr)
   {
      if (st >= dr) return;
      
      int m = find(t, st, dr);
      
      quickSort(t, st, m - 1);
      quickSort(t, m + 1, dr);
   }
   
   public static boolean change(int[] t, int st, int dr)
   {
      boolean swaped = false;
      
      for (int i = dr - 1; i >= st; i--)
         if (t[i] > t[i + 1]) {
            
            int aux = t[i]; t[i] = t[i + 1]; t[i + 1] = aux; swaped = true;
         }
      
      return swaped;
   }
   
   public static void bubbleSort(int[] t, int st, int dr)
   {
      boolean b = true;
      
      while (b && st < dr) {
         
         b = change(t, st, dr);
         
         st++;
      }
   }
   
   public static int findIndexMin(int[] t, int st, int dr)
   {
      int min = st;
      
      for (int i = st + 1; i <= dr; i++)
         if (t[i] < t[min]) min = i;
      
      return min;
   }
   
   public static void selectionSort(int[] t, int st, int dr)
   {
      for (int i = st; i < dr; i++) {
         
         int indexMin = findIndexMin(t, i, dr);
         
         int aux = t[i]; t[i] = t[indexMin]; t[indexMin] = aux;
      }
   }
   
   public static void insertionSort(int[] t, int st, int dr)
   {
      for (int i = st; i <= dr; i++) {
         
         int index = i;
         
         while (index > 0 && t[index] < t[index - 1])  {
            
            int aux = t[index]; t[index] = t[index - 1]; t[index - 1] = aux;
            
            index--;
         }
         
      }
   }
   
   public static void main(String[] args)
   {
      int[] t = new int[]{34, 678, 20, 100, 45, 12};
      
      //quickSort(t, 0, t.length - 1);
      //mergeSort(t, 0, t.length - 1);
      //bubbleSort(t, 0, t.length - 1);
      //selectionSort(t, 0, t.length - 1);
      insertionSort(t, 0, t.length - 1);
      
      for (int i = 0; i < t.length; i++) System.out.print(t[i] + " ");
   }
   
}
