
public class Passenger extends Person{

	private Date birthday;
	
	public Passenger(String name, Address address)
	{
		super(name, address);
		birthday = null;
	}

	public Date getBirthday() 
	{
		return birthday;
	}

	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}
	
	public String toString()
	{
		if(birthday != null)
			return super.toString() + "  Birthday: " + birthday;
		else 
			return super.toString() ;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Passenger))
			return false;
		Passenger pass = (Passenger)obj;
		if(birthday == null && pass.birthday != null)
			return false;
		else if(birthday != null && pass.birthday == null)
			return false;
		else if(birthday != null && pass.birthday != null)
			return super.equals(pass) && birthday.equals(pass.birthday);
		else
			return super.equals(pass);
	}
}
