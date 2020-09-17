import lejos.nxt.MotorPort;
import lejos.nxt.Button;
import lejos.nxt.LCD;
public class Exercise1 {
	public static void main(String[] args)
	{
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		
		motorC.controlMotor(100,1);
		motorB.controlMotor(100,1);
		
		try
		{
		Thread.sleep(1040);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		
		motorC.controlMotor(0,3);
		motorB.controlMotor(0, 3);
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),10,1,1);
		Button.waitForAnyPress();
		
	}
}
