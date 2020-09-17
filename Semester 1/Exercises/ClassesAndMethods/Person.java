
public class Person {
	private String name;
	private String birthday;
	
	public Person(String name, String birthday)
	{
		this.name = name;
		this.birthday = birthday;
	}

	public Person()
	{
		name = "Random";
		birthday = " ";
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void setBirthday(String newBirthday)
	{
		birthday = newBirthday;
	}
	
	public String getName()
	{
		return name;

	}
	
	public String getBirthday()
	{
		return birthday;
	}
	
	public String toString()
	{
		return "Name: " + name + " Birthday: " + birthday;
	}
}
