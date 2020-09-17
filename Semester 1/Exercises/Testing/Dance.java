import lejos.nxt.Button;
import lejos.nxt.MotorPort;
public class Dance {

	public static void main(String[] args)
	{
		Commands cmd = new Commands();
		Button.waitForAnyPress();
		while(!Button.ENTER.isDown())
		{
			cmd.dance(100, 1);
		}
	}
}
