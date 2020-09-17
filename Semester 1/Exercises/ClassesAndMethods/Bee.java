
public class Bee extends Animal{

	private boolean isHoneyBee;
	
	public Bee(int age, boolean isHoneyBee) 
	{
		super(age);
		this.isHoneyBee = isHoneyBee;
	}


	public boolean isHoneyBee() 
	{
		return isHoneyBee;
	}


	public void setHoneyBee(boolean isHoneyBee) 
	{
		this.isHoneyBee = isHoneyBee;
	}


	public String speak() 
	{
		return "Bzzzz";
	}

}
