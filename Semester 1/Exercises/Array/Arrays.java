import java.util.Scanner;
public class Arrays {

	public static void main(String[] args)
	{
		int[] arr1 = {1, 2, 3, 4 ,5};
		int[] arr2 = new int[arr1.length];
		int[] arr3 = new int[arr2.length * 2];
		
		for(int i=0; i < arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
			arr1[i] = arr1[i] * 2;
		}
		System.out.println(" ");
		for (int i = 0; i < arr1.length; i++) 
		{
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println(" ");
		
		for (int i = 0; i < arr2.length; i++) 
		{
			arr2[i] = arr1[i];
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println(" ");
		
		for (int i = 0; i < arr2.length; i++) 
		{
			arr3[i] = arr2[i];
		}
		
		for (int i = 0; i < arr3.length; i++) 
		{
			System.out.print(arr3[i] + " ");
		}
		
		System.out.println(" ");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		int[] arr4 = new int[5];
		for (int i = 0; i < arr4.length; i++) 
		{
			arr4[i] = input.nextInt();
		}
		
		int total = 0;
		for (int i = 0; i < arr4.length; i++) 
		{
			total = total + arr4[i];
		}
		System.out.println("Avarage = " + total/arr4.length);
	}
}
