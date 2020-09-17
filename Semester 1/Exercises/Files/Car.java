
public class Car {

	private String regNumber;
	private String make;
	private String model; 
	private int year;
	private Owner owner;
	
	public Car(String regNumber, String make, String model, int year, Owner owner) 
	{
		this.regNumber = regNumber;
		this.make = make;
		this.model = model;
		this.year = year;
		this.owner = owner;
	}

	public String getRegNumber() 
	{
		return regNumber;
	}

	public void setRegNumber(String regNumber) 
	{
		this.regNumber = regNumber;
	}

	public String getMake() 
	{
		return make;
	}

	public void setMake(String make) 
	{
		this.make = make;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public int getYear() 
	{
		return year;
	}

	public void setYear(int year) 
	{
		this.year = year;
	}

	public Owner getOwner() 
	{
		return owner;
	}

	public void setOwner(Owner owner) 
	{
		this.owner = owner;
	}
	
	public String toString()
	{
		return owner + " " + model + " " + make + " " + regNumber + " " + year;
	}

	public boolean equals(Object obj) 
	{
		if(!(obj instanceof Car))
			return false;
		Car car = (Car)obj;
		return owner.equals(car.owner) && model.equals(car.model) 
				&& make.equals(car.make) && regNumber.equals(car.regNumber) 
				&& year == car.year;
	}
	
}
