
public class Clock {

	private int hour;
	private int min;
	private int sec;
	
	public Clock(int h, int m, int s)
	{
		hour = h;
		min = m;
		sec = s;
	}
	
	public Clock(int totalTimeInSeconds)
	{
		hour = totalTimeInSeconds / 3600;
		min = ((totalTimeInSeconds % 3600) / 60);
		sec = ((totalTimeInSeconds % 3600) % 60);
	}
	
	public void set(int h, int m, int s)
	{
		hour = h;
		min = m;
		sec = s;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public void tic()
	{
		this.sec += 1;
		if(sec == 60)
		{
			min++;
			sec = 0;
		}
		
		if( min == 60)
		{
			min = 0;
			hour++;
		}
	}
	
	public int convertToSeconds()
	{
		return (hour * 3600) + (min * 60) + sec;
	}
	
	public boolean isBefore(Clock time)
	{
		if(convertToSeconds() < time.convertToSeconds())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int timeInSecondsTo(Clock time)
	{
		if(isBefore(time))
			return time.convertToSeconds() - convertToSeconds();
		else
			return 24*3600 - time.convertToSeconds();
	}
	
	public Clock timeTo(Clock time)
	{
		return new Clock(timeInSecondsTo(time));
	}
	
	public String toString()
	{
		return hour + ":" + min + ":" + sec;
	}
}