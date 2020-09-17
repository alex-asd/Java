import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.Button;
public class Exercise4 {
	public static void main(String[] args)
	{
		double wheelCirc = 5.6 * Math.PI;
		double turn = 17 * 2 * Math.PI;
		double tachos = (turn / wheelCirc)*360;
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		Button.waitForAnyPress();
		while(motorB.getTachoCount() < tachos)
		{
			motorB.controlMotor(100, 1);
		}
		
		motorB.controlMotor(100, 2);
		try
		{
		Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),11,1,1);
	}
}