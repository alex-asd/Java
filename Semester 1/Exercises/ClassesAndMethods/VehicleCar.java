
public class VehicleCar extends Vehicle {
	
	private String regNo;
	
	public VehicleCar(String owner, double price, String regNo)
	{
		super(owner, price);
		this.regNo = regNo;
	}
	
	public String getRegNumber()
	{
		return regNo;
	}
	
	public void setRegNumber(String regNo)
	{
		this.regNo = regNo;
	}
	
	public String toString()
	{
		return super.toString() + " , Registration Number: " + regNo;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof VehicleCar))
			return false;
		VehicleCar car = (VehicleCar)obj;
		return super.equals(car) && regNo.equals(car.regNo);
	}
}
