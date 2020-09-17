
public class Person {

	private String name;
	private String gender;
	private int age;
	private boolean engaged;
	
	public Person(String name, String gender, int age)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		engaged = false;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setEngaged(boolean tf)
	{
		engaged = tf;
	}
	
	public boolean getEngaged()
	{
		return engaged;
	}
	
	
	
	public boolean equals(Object nameOfObject)
	{
		if(!(nameOfObject instanceof Person))
			return false;
		Person ps = (Person)nameOfObject;
		return name.equals(ps.name) && gender.equals(ps.gender) && age == ps.age;
	}
	
	public String toString()
	{
		return "Name: " + name + '\n' + "Gender: " + gender + '\n' + "Age: " + age;
	}
	
	public void engagedTwoPersons(Person person)
	{
		if(getEngaged() == false && person.getEngaged() == false)
		{
			engaged = true;
			person.engaged = true;
		}
	}
	
	public String canHeGoOutWithOtherFuckinGirls(Person person)
	{
		if(getEngaged() == true)
			return "You are engaged u dumb prick";
		else 
			return "Yeah, u can totally have sex with them";
	}
}
