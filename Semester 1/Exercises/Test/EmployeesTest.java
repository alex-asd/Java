
public class EmployeesTest {

	public static void main(String[] args)
	{
		EmployeeList list = new EmployeeList(5);
		EmployeeList listTwo = new EmployeeList(5);
		Date d1 = new Date(11,2,1970);
		Date d2 = new Date(19,7,1963);
		Date d3 = new Date(1,3,2000);
		Date d4 = new Date(8,12,1);
		Date d5 = new Date(10,3,1969);
		SalariedEmployee p1 = new SalariedEmployee("Nicolas", d1, 3000);
		SalariedEmployee p2 = new SalariedEmployee("Peter", d2, 4900);
		SalariedEmployee p3 = new SalariedEmployee("Kurcho", d3, 10000);
		HourlyEmployee p4 = new HourlyEmployee("Kaci", d4, 11, 50);
		HourlyEmployee p5 = new HourlyEmployee("Jhon", d5, 12, 29);
		
		list.addEmployee(p1);list.addEmployee(p2);list.addEmployee(p3);list.addEmployee(p4);list.addEmployee(p5);
		listTwo.addEmployee(p1);listTwo.addEmployee(p2);listTwo.addEmployee(p3);listTwo.addEmployee(p4);listTwo.addEmployee(p5);
		
		System.out.println(p1);
		System.out.println(list);
		System.out.println(list.equals(listTwo));
		listTwo.removeEmployee(p2);
		System.out.println(list.equals(listTwo));
		System.out.println(list.getNumberOfEmployees() + " " + listTwo.getNumberOfEmployees());
		System.out.println(list.getTotalEarningsPerWeek() + " " + listTwo.getTotalEarningsPerWeek());
		
	}
}
