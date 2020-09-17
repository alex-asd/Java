
public class Owner {

	private String firstName;
	private String lastName;
	
	public Owner(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String toString()
	{
		return "First name: " + firstName + '\t' + "Last name: " + lastName;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Owner))
			return false;
		Owner owner = (Owner)obj;
		return firstName.equals(owner.firstName) && lastName.equals(owner.lastName);
	}
}
