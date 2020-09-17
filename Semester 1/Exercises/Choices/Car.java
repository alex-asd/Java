
public class Car {

	private int yearModel;
	private String make;
	private int speed;
	
	public Car(int yearModel, String make)
	{
		this.yearModel = yearModel;
		this.make = make;
		this.speed = 0;
	}
	
	public int getYearModel()
	{
		return yearModel;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public int acc()
	{
		return speed = speed + 50;
	}
	
	public int br()
	{
		return speed = speed - 50;
	}
}
