
public class PersonTwo {
	
	private String name;
	private String address;
	private MyDate birthday;
	private Brain brain;
	
	public PersonTwo(String name, String address, MyDate birthday)
	{
		this.name = name;
		this.address = address;
		this.birthday = birthday.copy();
		this.brain = new Brain();
	}
	
	public PersonTwo(String name, MyDate birthday)
	{
		this.name = name;
		this.birthday = birthday.copy();
		address = null;
	}
	
	public PersonTwo(MyDate birthday)
	{
		this.birthday = birthday.copy();
		name = null;
		address = null;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public MyDate getBirthday() 
	{
		return birthday.copy();
	}

	public void setBirthday(MyDate birthday) 
	{
		this.birthday = birthday.copy();
	}
	
	public int getAge()
	{
		MyDate bday = birthday.copy();
		if(!bday.isBefore(MyDate.today()))
		{
			return -1;
		}
		else
		{
			if((bday.getMonth() > MyDate.today().getMonth()))
				return MyDate.today().getYear() - (bday.getYear() + 1);
			else if((bday.getMonth() == MyDate.today().getMonth()) 
					&& (bday.getDate() > MyDate.today().getDate()))
				return MyDate.today().getYear() - (bday.getYear() + 1);
			else
				return MyDate.today().getYear() - bday.getYear();
		}
		
	}
	
	public String toString()
	{
		String str = "";
		if(name != null)
			str = str + " Name: " + name + '\n';
		if(address != null)
			str = str + " Address: " + address + '\n';
		if(birthday != null)
			str = str + " Birthday: " + birthday + '\n';
		return str;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof PersonTwo))
			return false;
		PersonTwo obj2 = (PersonTwo)obj;
		return name == obj2.name
				&& address == obj2.address
				&& birthday.equals(obj2);
	}
	
	public boolean doYouRemember(String topic)
	{
		if(brain.recall(topic))
			return true;
		else 
			return false;
	}
	
	public void rememberThis(String topic)
	{
		if(!brain.recall(topic))
			brain.remember(topic);
		else
			brain.refreshMemory(topic);
	}

	public String whatAreYouThinkingAbout()
	{
		return brain.recall();
	}

	public int getIQ()
	{
		return brain.getIQ();
	}
}
