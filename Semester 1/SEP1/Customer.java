
public class Customer extends Person{

	private String phone;
	private String email;
	private int frequency;
	private String company;
	
	public Customer(String name, Address address, String phone, String email)
	{
		super(name, address);
		this.phone = phone;
		this.email = email;
		frequency = 0;
		company = null;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getCompany()
   {
      return company;
   }

   public void setCompany(String company)
   {
      this.company = company;
   }

   public int getFrequency()
   {
      return frequency;
   }

   public void addFrequency()
	{
	   frequency += 1;
	}
	
	public String toString()
	{
		return super.toString() + "  Phone: " + phone + "  E-mail: " + email;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Customer))
			return false;
		Customer cust = (Customer)obj;
		return super.equals(cust) && phone.equals(cust.phone) && email.equals(cust.phone);
	}
}
