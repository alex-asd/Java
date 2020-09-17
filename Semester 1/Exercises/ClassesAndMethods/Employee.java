
public class Employee {

	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	public void setName(String entName)
	{
		name = entName;
	}
	
	public void setIdNumber(int entIdNumber)
	{
		idNumber = entIdNumber;
	}
	
	public void setDepartment(String entDepartment)
	{
		department = entDepartment;
	}
	
	public void setPosition(String entPosition)
	{
		position = entPosition;
	}
	
	public String displayName()
	{
		return name;
	}
	
	public int displayIdNumber()
	{
		return idNumber;
	}
	
	public String displayDepartment()
	{
		return department;
	}
	
	public String displayPosition()
	{
		return position;
	}
	
}
