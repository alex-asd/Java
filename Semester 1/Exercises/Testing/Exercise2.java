import lejos.nxt.LCD;
import lejos.nxt.MotorPort;
import lejos.nxt.Button;
public class Exercise2 {
	public static void main(String[] args) throws InterruptedException
	{
		MotorPort motorC = MotorPort.C;
		MotorPort motorB = MotorPort.B;
		
		Button.waitForAnyPress();
		motorC.controlMotor(100,1);
		motorB.controlMotor(100,1);
		Button.waitForAnyPress();
		motorB.controlMotor(0, 3);
		motorC.controlMotor(0, 3);
		LCD.drawString("Distance:", 0, 0);
		LCD.drawInt(motorB.getTachoCount(),10,1,1);
		Button.waitForAnyPress();
	}
}
