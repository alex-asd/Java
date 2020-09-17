import java.util.Scanner;
public class PayrollTest {
	public static void main(String[] args)
	{
		Payroll Tester = new Payroll();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your name");
		Tester.setName(input.nextLine());
		System.out.println("Enter your hourly pay (in decimals)");
		Tester.setHourPay(input.nextDouble());
		System.out.println("Enter your work hours per week");
		Tester.setWorkHours(input.nextInt());
		
		System.out.println("Name: " + Tester.getName() + " you earn " + Tester.grossPay() + " per week");
		
	}
}
