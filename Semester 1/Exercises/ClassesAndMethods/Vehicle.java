
public class Vehicle {

	private String owner;
	private double price;
	
	public Vehicle(String owner, double price)
	{
		this.owner = owner;
		this.price = price;
	}

	public String getOwner() 
	{
		return owner;
	}

	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle owner: " + owner + ", price: " + price;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Vehicle))
			return false;
		Vehicle veh = (Vehicle)obj;
		return owner == veh.owner && price == veh.price;
	}
	
	
}
