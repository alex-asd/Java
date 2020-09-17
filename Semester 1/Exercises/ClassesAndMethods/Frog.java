
public class Frog extends Animal{

	private String color;
	
	public Frog(int age, String color) 
	{
		super(age);
		this.color = color;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public String speak()
	{
		return "Ribbit";
	}
}
