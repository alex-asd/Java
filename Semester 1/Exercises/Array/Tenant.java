
public class Tenant {

	private String name;
	private String phone;
	private double rentDue;
	
	public Tenant(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
		rentDue = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getRentDue() {
		return rentDue;
	}
	public void setRentDue(double rentDue) {
		this.rentDue = rentDue;
	}
	
	public Tenant copy()
	{
		return new Tenant(name, phone);
	}
	
	public String toString()
	{
		String str = "";
		str += "Name: " + name + '\t' + " Phone: " + phone + '\t' + " Rent: " + rentDue;
		return str;
	}
	
	
	
}
