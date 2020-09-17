package guided.tour;

public class Visitor {

	private int tourNumber;
	
	public Visitor(int tourNumber)
	{
		this.tourNumber = tourNumber;
	}

	public int getTourNumber() 
	{
		return tourNumber;
	}

	public void setTourNumber(int tourNumber) 
	{
		this.tourNumber = tourNumber;
	}
	
	public String toString()
	{
		return "Vistor in tour group " + tourNumber;
	}
}
