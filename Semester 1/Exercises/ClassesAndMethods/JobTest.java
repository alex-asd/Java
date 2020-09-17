
public class JobTest {
	public static void main(String[] args)
	{
		Person jon = new Person("Jon Snow", "01/03/1654");
		Job engineer = new Job("Engineer", 2000, jon);
		
		Person goat = new Person("Maria", "Its a goat, no one knows when its been born");
		Job walkin = new Job("Mechanic", 1500);
		
		engineer.setJobTitle("IT Engineer");
		engineer.setSalary(6000.0);
		System.out.println("Job: " + engineer.getJobTitle());
		System.out.println("Salary: " + engineer.getSalary());
		System.out.println("Person: " + engineer.getEmployee());
		
		walkin.setEmployee(goat);
		System.out.println("Job: " + walkin.getJobTitle());
		System.out.println("Salary: " + walkin.getSalary());
		System.out.println("Person: " + walkin.getEmployee());
		
		engineer.setSalary(engineer.givePercentageRaise(40));
		System.out.println(engineer.getSalary());
	}
}
