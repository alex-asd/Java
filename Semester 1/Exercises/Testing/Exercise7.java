import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.Button;
public class Exercise7 {
	public static void main(String[] args)
	{
		double wheelCirc = 5.6 * Math.PI;
		double turn = 17 * 2 * Math.PI;
		double tachos = (turn / wheelCirc);
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		Button.waitForAnyPress();
		
		//1st 100cm 
		while(motorB.getTachoCount() < 2050)
		{
			motorB.controlMotor(100, 1);
			motorC.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		try
		{
		Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		motorB.resetTachoCount();
		
		
	// Turn 35
		while(motorB.getTachoCount() < (tachos * 145))
		{
			motorB.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		try
		{
		Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		motorB.resetTachoCount();
		
		
		//2nd 100cm 
		while(motorB.getTachoCount() < 2050)
		{
			motorB.controlMotor(100, 1);
			motorC.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		try
		{
		Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		motorB.resetTachoCount();
		
		//turn 72
		while(motorB.getTachoCount() < (tachos * 88))
		{
			motorB.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		try
		{
		Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		motorB.resetTachoCount();
		
	
	// 60 cm
		while(motorB.getTachoCount() < 1230)
		{
			motorB.controlMotor(100, 1);
			motorC.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		try
		{
		Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		motorB.resetTachoCount();
		
		
		//turn 72
		while(motorB.getTachoCount() < (tachos * 72))
		{
			motorB.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
	}
}