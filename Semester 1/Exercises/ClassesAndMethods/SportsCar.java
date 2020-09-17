
public class SportsCar extends VehicleCar{

	private int maxVelocity;
	
	public SportsCar(String owner, double price, String regNo, int maxVelocity)
	{
		super(owner, price, regNo);
		this.maxVelocity = maxVelocity;
	}
	
	public int getMaxVelocity()
	{
		return maxVelocity;
	}

	@Override
	public String toString() 
	{
		return super.toString() + " , Maximum speed: " + maxVelocity;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof SportsCar))
			return false;
		SportsCar car = (SportsCar)obj;
		return super.equals(car) && maxVelocity == car.maxVelocity;
	}
}
