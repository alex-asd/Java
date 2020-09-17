import java.util.Scanner;
public class Exercise4 {
	public static void main(String[] args)
	{
		String name;
		int age; 
		double money;
		Scanner input = new Scanner(System.in);
		System.out.print("age?");
		age = input.nextInt();
		System.out.print("money?");
		money = input.nextDouble();
		System.out.print("name?");
		input.nextLine();
		name = input.nextLine();
		System.out.println("Hi " + name + " , ur " + age + " , u earn " + money);
	}
}
