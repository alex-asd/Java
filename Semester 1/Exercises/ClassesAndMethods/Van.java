
public class Van extends VehicleCar{
	
	private int maxLoad;

	public Van(String owner, double price, String regNo, int maxLoad) {
		super(owner, price, regNo);
		// TODO Auto-generated constructor stub
		this.maxLoad = maxLoad;
	}
	
	public int getMaxLoad()
	{
		return maxLoad;
	}
	
	public String toString()
	{
		return super.toString() + " , Maximum load: " + maxLoad + " kg";
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Van))
			return false;
		Van van = (Van)obj;
		return super.equals(van) && maxLoad == van.maxLoad;
	}
}
