
public class Clock {

	private int hour;
	private int min;
	private int sec;
	public int getHour() {
		return hour;
	}
	
	public Clock() {
		hour = 00;
		min = 00;
		sec = 00;
	}
	public void set(int hour, int min, int sec)
	{
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public String toString()
	{
		return " " + hour + ":" + min + ":" + sec;
	}
	
	public void updateClock()
	{
		sec++;
		if(sec == 60)
		{
			sec = 0;
			min++;
		}
		if(min == 60)
		{
			min = 0;
			hour++;
		}
	}
}
