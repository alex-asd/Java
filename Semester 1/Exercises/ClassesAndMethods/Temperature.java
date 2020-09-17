
public class Temperature {
	
	private double ftemp;
	
	public Temperature(double ftemp)
	{
		this.ftemp = ftemp;
	}
	
	public void setFtemp(double newFtemp)
	{
		ftemp = newFtemp;
	}
	
	public double getFtemp()
	{
		return ftemp;
	}
	
	public double getCelsius()
	{
		return (ftemp - 32)*(5.0/9);
	}
	
	public double getKelvin()
	{
		return (((5.0/9)*(ftemp - 32)) + 273);
	}
}
