import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Assignment2 {
	public static void main(String[] args) 
	{
		LightSensor ls = new LightSensor(SensorPort.S1);
		Commands com = new Commands();
		Button.LEFT.waitForPress();
		ls.calibrateLow();
		Button.RIGHT.waitForPress();
		ls.calibrateHigh();
		while (!Button.ENTER.isDown()) 
		{
			if (ls.readValue() <= 15) 
			{
				com.moveMotors(65, 1, 55, 1);
				// com.sleep(30);
			}
			if (ls.readValue() > 15)
			{
				com.moveMotors(55, 2, 65, 1);
				// com.sleep(30);
			}
		}
	}
}