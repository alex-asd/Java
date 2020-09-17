import java.io.*;

public class Student implements Serializable{
	private String fName;
	private String lName;
	private String country;
	
	public Student(String fName, String lName, String country)
	{
		this.fName = fName;
		this.lName = lName;
		this.country = country;
	}

	public String getfName() 
	{
		return fName;
	}

	public void setfName(String fName) 
	{
		this.fName = fName;
	}

	public String getlName() 
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}
	
	public String toString()
	{
		return "First name: " + fName + '\t' + "Last name: " + lName + '\t' + "Country: " + country;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			return false;
		Student std = (Student)obj;
		return fName.equals(std.fName) && lName.equals(std.lName) && country.equals(std.country);
	}
}
