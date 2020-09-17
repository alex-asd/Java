import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.Button;
public class Exercise3 {
	public static void main(String[] args)
	{
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		Button.waitForAnyPress();
		
		while(motorB.getTachoCount() <= 2050)
		{
			motorB.controlMotor(100, 1);
			motorC.controlMotor(100, 1);
		}
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),11,1,1);
		Button.waitForAnyPress();
	}
}