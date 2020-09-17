import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.Button;
public class Exercise5 {
	public static void main(String[] args)
	{
		double wheelCirc = 5.6 * Math.PI;
		double turn = 17 * 2 * Math.PI;
		double tachos = (turn / wheelCirc)*90;
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		Button.waitForAnyPress();
		while(motorB.getTachoCount() < 2050)
		{
			motorB.controlMotor(100, 1);
			motorC.controlMotor(100, 1);
		}
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),11,1,1);
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		Button.waitForAnyPress();
		motorB.resetTachoCount();
		
		while(motorB.getTachoCount() < tachos)
		{
			motorB.controlMotor(100, 1);
		}
		
		motorB.controlMotor(100, 2);
		try
		{
		Thread.sleep(70);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),11,1,1);
	}
}