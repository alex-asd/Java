
public class EmployeeTest {
	public static void main(String[] args)
	{
		Employee Mark = new Employee();
		Mark.setName("Mark Jones");
		Mark.setDepartment("IT");
		Mark.setIdNumber(39119);
		Mark.setPosition("Programmer");
		
		Employee Susan = new Employee();
		Susan.setName("Susan Meyers");
		Susan.setDepartment("Accounting");
		Susan.setIdNumber(47899);
		Susan.setPosition("Vice President");
		
		Employee Joy = new Employee();
		Joy.setName("Joy Rogers");
		Joy.setDepartment("Manufacturing");
		Joy.setIdNumber(81774);
		Joy.setPosition("Engineer");
		
		System.out.println("Employee: " + Susan.displayName() + " ; ID Number:" + 
		Susan.displayIdNumber() + " ; Department: " + Susan.displayDepartment()
		 + " ; Position: " + Susan.displayPosition());
		
		System.out.println("Employee: " + Mark.displayName() + " ; ID Number:" + 
		Mark.displayIdNumber() + " ; Department: " + Mark.displayDepartment()
		 + " ; Position: " + Mark.displayPosition());
		
		System.out.println("Employee: " + Joy.displayName() + " ; ID Number:" + 
		Joy.displayIdNumber() + " ; Department: " + Joy.displayDepartment()
		 + " ; Position: " + Joy.displayPosition());
	}
}
