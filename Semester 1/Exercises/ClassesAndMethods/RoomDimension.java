
public class RoomDimension {

	private double lenght;
	private double width;
	
	public RoomDimension(double len, double w)
	{
		lenght = len;
		width = w;
	}
	
	public double getArea()
	{
		return lenght * width;
	}
	
	public String toString()
	{
		String str = "";
		str += " Width: " + width;
		str += " Lenght: " + lenght;
		return str;
	}
}
