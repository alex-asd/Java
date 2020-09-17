
public class Student {
	private String name;
	private int id;
	private char gender;
	
	public Student(String name, char gender, int id)
	{
		this.name = name;
		this.gender = gender;
		this.id = id;
	}
	
	public Student(String name, char gender)
	{
		this.name = name;
		this.gender = gender;
		this.id = 0;
	}
	
	public void setNumber(int number)
	{
		id = number;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public char getGender()
	{
		return gender;
	}
	
	public int getId()
	{
		return id;
	}
}
