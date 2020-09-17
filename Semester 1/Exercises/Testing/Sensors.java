import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.LCD;
import lejos.nxt.Button;
public class Sensors {
	public static void main(String[] args)
	{
		LightSensor light = new LightSensor(SensorPort.S1);
		
		while(!Button.ENTER.isDown())
		{
			LCD.drawString("Light: ", 0, 3);
			LCD.drawInt(light.getLightValue(), 0, 4);
			
			try
			{
			Thread.sleep(400);
			}
			catch (InterruptedException e)
			{
			e.printStackTrace();
			}
			LCD.clear();
		}
		
		
	}
}
