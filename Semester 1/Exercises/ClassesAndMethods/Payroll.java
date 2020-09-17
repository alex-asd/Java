
public class Payroll {

	private String employeeName;
	private double hourPay;
	private int workHours;
	
	public void setName(String personName)
	{
		employeeName = personName;
	}
	
	public void setHourPay(double newHourPay)
	{
		hourPay = newHourPay;
	}
	
	public void setWorkHours(int newWorkHours)
	{
		workHours = newWorkHours;
	}
	
	public String getName()
	{
		return employeeName;
	}
	
	public double grossPay()
	{
		return(hourPay * workHours);
	}
}
