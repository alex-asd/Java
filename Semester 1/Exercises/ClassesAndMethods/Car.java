
public class Car {
	private String make;
	private String model;
	private String color;
	private String licenseNumber;
	private int year;

	

	public Car(String make, String model, String color, String licenseNumber,
			int year) 
	{
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.licenseNumber = licenseNumber;
		this.year = year;
	}
	
	public Car(String make, String model, String color, int year)
	{
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.licenseNumber = null;
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
	
	public String getColor() 
	{
		return color;
	}
	
	public void setColor(String color) 
	{
		this.color = color;
	}
	
	public String getLicenseNumber() 
	{
		return licenseNumber;
	}
	
	public void setLicenseNumber(String licenseNumber) 
	{
		this.licenseNumber = licenseNumber;
	}
	
	public int getYear() 
	{
		return year;
	}
	
	public void setYear(int year) 
	{
		this.year = year;
	}
	
	public String toString() 
	{
		String str = "";
		str = str +" Make: " + make;
		str = str + " Model: " + model;
		str = str + " Color: " + color;
		if(licenseNumber != null)
		{
			str = str + " License Number: " + licenseNumber;
		}
		str = str + " Year: " + year;
		return str;
	}
	
	public Car copy()
	{
		return new Car(make, model, color, licenseNumber, year);
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Car))
			return false;
		Car other = (Car)obj;
		return(make == other.make 
				&& model == other.model
				&& color == other.model
				&& licenseNumber == other.licenseNumber
				&& year == other.year);
	}
}
