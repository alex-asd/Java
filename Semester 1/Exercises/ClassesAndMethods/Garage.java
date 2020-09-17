
public class Garage {

	private Car car;
	private Car car2;
	
	public Garage()
	{
		car = null;
		car2 = null;
	}
	
	public boolean isParkingAreaTaken(int position)
	{
		if(position == 1 && car == null)
			return false;
		else if(position == 2 && car2 == null)
			return false;
		else
			return true;
	}
	
	public void park(Car car, int position)
	{
		if(!isParkingAreaTaken(position) && position == 1)
			this.car = car;
		
		if(!isParkingAreaTaken(position) && position == 2)
			this.car2 = car;
	}
	
	public Car leaveGarage(int position)
	{
		Car temp = car;
		Car temp2 = car2;
		
		if(car != null && position == 1)
			{
				car = null;
				return temp;
			}


		if(car2 != null && position == 2)
		{
			car2 = null;
			return temp2;
		}
		return null;	
	}
	
	public String toString()
	{
		String str = "";
			str = str + " Car: " + car + '\n';
			str = str + " Car2: " + car2 + '\n';
		return str;
	}
	
	public boolean equals(Object obj)
	{	
		if(!(obj instanceof Garage))
			return false;
		
		Garage obj2 = (Garage)obj;
		return car == obj2.car 
				&& car2 == obj2.car2;
	}
}
