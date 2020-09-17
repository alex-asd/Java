import java.util.Scanner;
public class Array2 {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int[] arr1 = new int[4];
		int[] arr2 = new int[4];
		int[] arr3 = new int[arr1.length];
		
		for (int i = 0; i < arr1.length; i++) 
		{
			System.out.println("Enter number");
			arr1[i] = input.nextInt();
		}
		System.out.println("Enter 4 more");
		for (int i = 0; i < arr2.length; i++) 
		{
			arr2[i] = input.nextInt();
		}
		
		/*boolean isTrue = true;
		if(arr1.length != arr2.length)
			isTrue = false;
		else
		{
			for (int i = 0; i < arr2.length; i++) 
			{
				if(arr1[i] != arr2[i])
				{
					isTrue = false;
					break;
				}
				else
					isTrue = true;
					
			}
			
		System.out.println(isTrue);
		}
		*/
			
		for (int i = 0; i < arr3.length; i++) 
		{
			arr3[i] = arr2[i] + arr1[i];
		}
		System.out.println(" ");
		for (int i = 0; i < arr3.length; i++) 
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println(" ");
		for (int i = 0; i < arr3.length; i++) 
		{
			System.out.print(arr1[i] + " ");
		}
		System.out.println(" ");
		for (int i = 0; i < arr3.length; i++) 
		{
			System.out.print(arr3[i] + " ");
		}
		
	}
}
