import lejos.nxt.*;
public class Forward {
	public static void main(String[] args) 
	{
		Commands command = new Commands();
		SoundSensor micR = new SoundSensor(SensorPort.S3);
		SoundSensor micL = new SoundSensor(SensorPort.S4);
		
		while(!Button.ENTER.isDown())
		{
			LCD.drawString("Listening", 0, 0);
			LCD.drawInt(micR.readValue(), 0, 1);
			LCD.drawInt(micL.readValue(), 0, 2);
			if(micR.readValue() > 50)
			{
				command.moveMotors(100, 1, 0, 1);
			}
			else if(micL.readValue() > 50)
			{
				command.moveMotors(0, 1, 100, 1);
			}
			else if((micR.readValue() < 60) && (micL.readValue() < 60))
				command.moveMotors(100, 3, 100, 3);
			LCD.clear();
		}
		
	}
}
