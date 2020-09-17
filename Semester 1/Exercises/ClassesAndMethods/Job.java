
public class Job {
	
	private String jobTitle;
	private double salary;
	private Person employee;
	
	public Job(String jobTitle, double salary, Person employee)
	{
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.employee = employee;
	}
	
	public Job(String jobTitle, double salary)
	{
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.employee = null;
	}
	
	public String getJobTitle()
	{
		return jobTitle;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Person getEmployee()
	{
		return employee;
	}
	
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	public void setEmployee(Person employee)
	{
		this.employee = employee;
	}
	
	public double givePercentageRaise(double percentage)
	{
		return (percentage/100 * salary) + salary;
	}
}
