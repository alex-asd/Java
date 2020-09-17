
public class Child {
	
	private String name;
	private int age;
	
	public Child(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Child))
			return false;
		Child kid = (Child)obj;
		return name.equals(kid.name) && age == kid.age;
	}
	
	public String toString()
	{
		return "Name: " + name + "  " + "Age: " + age;
	}
}
