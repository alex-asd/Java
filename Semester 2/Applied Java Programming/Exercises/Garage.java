
public class Garage implements ParkingPlace{

	private int slots;
	
	public Garage()
	{
		slots = 4;
	}
	
	
	@Override
	public void arrive() 
	{
		while(slots < 1)
		{
			try 
			{
				wait();
			} 
			catch (InterruptedException e) {
				// nth
			}
		}
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int freePlaces() 
	{
		return slots;
	}

}
