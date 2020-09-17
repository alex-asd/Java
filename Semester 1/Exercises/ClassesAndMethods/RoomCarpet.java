
public class RoomCarpet {

	private RoomDimension size;
	private double cost;
	
	public RoomCarpet(RoomDimension dim, double cost)
	{
		size = dim;
		this.cost = cost;
	}
	
	public double getTotalCost()
	{
		return size.getArea() * cost;
	}
	
	public String toString()
	{
		String str = "";
		str += " Cost per square foot: " + cost + '\n';
		str += " Area of the room: " + size.getArea() + '\n';
		str += " Total price: " + getTotalCost();
		return str;
	}
	
}
