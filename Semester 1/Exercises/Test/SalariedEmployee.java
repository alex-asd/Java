
public class SalariedEmployee extends Employee{

	private double weeklySalary;
	
	public SalariedEmployee(String name, Date birthday, double weeklySalary) {
		super(name,birthday);
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() 
	{
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) 
	{
		this.weeklySalary = weeklySalary;
	}

	public String toString() 
	{
		return super.toString() + " Weekly Salary: " + weeklySalary;
	}
	
	public double earningsPerWeek()
	{
		return weeklySalary;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof SalariedEmployee))
			return false;
		SalariedEmployee emp = (SalariedEmployee)obj;
		return super.equals(emp) && weeklySalary == emp.weeklySalary;
	}
}
