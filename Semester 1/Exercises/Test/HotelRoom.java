
public class HotelRoom {

	private int roomNumber;
	private String name;
	private double rent;
	

	public HotelRoom(int roomNumber, String name, double rent) {
		super();
		this.roomNumber = roomNumber;
		this.name = name;
		this.rent = rent;
	}
	
	public HotelRoom(int roomNumber, double rent)
	{
		this.roomNumber = roomNumber;
		this.rent = rent;
		name = "No one";
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getName() {
		return name;
	}

	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	public boolean isAvailable()
	{
		if(name.equals("No one"))
			return true;
		else 
			return false;
	}
	
	public void checkIn(String name)
	{
		if(isAvailable())
			this.name = name;
	}
	
	public void checkOut()
	{
		this.name = "No one";
	}
	
	public String toString()
	{
		String user = "";
		if(!isAvailable())
			user = name;
		return "Room: " + roomNumber + "  Rent: " + rent + " " + user;
	}
}
