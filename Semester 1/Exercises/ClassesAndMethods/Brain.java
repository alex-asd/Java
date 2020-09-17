
public class Brain {

	private String activeMemoryItem;
	private String passiveMemoryItemOne;
	private String passiveMemoryItemTwo;
	
	public Brain()
	{
		activeMemoryItem = "";
		passiveMemoryItemOne = "";
		passiveMemoryItemTwo = "";
	}
	
	public int getIQ()
	{
		if(isBrainDamaged())
			return 70;
		else if(((activeMemoryItem.length() > 20) 
						&& (passiveMemoryItemOne.length() > 10) 
						&& (passiveMemoryItemTwo.length() > 10)) 
				|| ((activeMemoryItem.length() > 10) 
						&& (passiveMemoryItemOne.length() > 20) 
						&& (passiveMemoryItemTwo.length() > 10))
				|| ((passiveMemoryItemTwo.length() > 20) 
						&& (passiveMemoryItemOne.length() > 10) 
						&& (activeMemoryItem.length() > 10)))
			return 130;
		
		else if((activeMemoryItem.length() > 10 ) 
				&& (passiveMemoryItemOne.length() > 10) 
				&& (passiveMemoryItemTwo.length() > 10))
			return 100;
		
		else if((activeMemoryItem.length() < 10) || (passiveMemoryItemOne.length() < 10) || (passiveMemoryItemTwo.length() < 10))
			return 70;
		return 0;
	}
	
	public boolean isBrainDamaged()
	{
		if((activeMemoryItem == null) || (passiveMemoryItemOne == null) || (passiveMemoryItemTwo == null))
			return true;
		else 
			return false;
	}
	
	public void remember(String info)
	{
		passiveMemoryItemTwo = passiveMemoryItemOne;
		passiveMemoryItemOne = activeMemoryItem;
		activeMemoryItem = info;
	}
	
	public void refreshMemory(String info)
	{
		if(info.equals(passiveMemoryItemOne))
		{
			passiveMemoryItemOne = activeMemoryItem;
			activeMemoryItem = info;
		}
		
		else if(info.equals(passiveMemoryItemTwo))
		{
			passiveMemoryItemTwo = activeMemoryItem;
			activeMemoryItem = info;
		}
	}

	public boolean recall(String info)
	{
		if(info.equals(activeMemoryItem)
				|| info.equals(passiveMemoryItemOne)
				|| info.equals(passiveMemoryItemTwo))
			return true;
		else
			return false;
	}
	
	public String recall()
	{
		return activeMemoryItem;
	}

	public String toString()
	{
		String str = "";
		if(activeMemoryItem != null)
			str = str + " " + activeMemoryItem + '\n';
		if(passiveMemoryItemOne != null)
			str = str + " " + passiveMemoryItemOne + '\n';
		if(passiveMemoryItemTwo != null)
			str = str + " " + passiveMemoryItemTwo + '\n';
		return str;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Brain))
			return false;
		Brain oth = (Brain)obj;
		return activeMemoryItem == oth.activeMemoryItem
				&& passiveMemoryItemOne == oth.passiveMemoryItemOne
				&& passiveMemoryItemTwo == oth.passiveMemoryItemTwo;
	}
}