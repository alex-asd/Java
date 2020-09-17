
public abstract class Employee {
	private String name;
	private Date birthday;

	public Employee(String name, Date birthday) 
	{
		this.name = name;
		this.birthday = birthday.copy();
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Date getBirthday()
	{
		return birthday.copy();
	}
	
	public String toString()
	{
		return "Name: " + name + '\t' +"birthday: " + birthday.copy();
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Employee))
			return false;
		Employee emp = (Employee)obj;
		return name.equals(emp.name) && birthday.copy().equals(emp.birthday.copy());
	}
	
	public abstract double earningsPerWeek();
}
