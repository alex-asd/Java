import java.util.ArrayList;

import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;


public class Ass3 {

	public static void main(String[] args)
	{
		MotorPort motorL = MotorPort.C;
		MotorPort motorR = MotorPort.B;
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
		ArrayList<Obj> objects = new ArrayList<Obj>();
		Commands com = new Commands();
		double wheelCirc = 5.6 * Math.PI;
		double wheelDist = 17 * 2 * Math.PI;
		double turn = (wheelDist / wheelCirc)*360;
		int num = 1;
		int angle = 0;
		
		
		Button.waitForAnyPress();
		while (motorR.getTachoCount() < turn) 
		{
			motorR.controlMotor(64, 1);
			if(us.getDistance() < 150)
			{
				
				Obj objective = new Obj(us.getDistance(), num, motorR.getTachoCount());
				objects.add(objective);
				num++;
				Sound.playTone(3000, 100);
				while(us.getDistance() < 170)
				{
					motorR.controlMotor(64, 1);
				}
			}
		}
		motorR.controlMotor(100, 3);
		
		for (int i = 0; i < objects.size(); i++) {
			LCD.drawInt(objects.get(i).getDistance(), 0, i);
			
			
		}
		motorR.resetTachoCount();
		com.sleep(1000);
		
		for(int i=0; i < objects.size(); i++)
		{
			while(motorR.getTachoCount()< objects.get(i).getTachos())
				{motorR.controlMotor(64, 1);}
				motorR.controlMotor(65, 3);
				
				Sound.playTone(7000, 1000);
				LCD.clear(i);
				com.sleep(1300);
				
				for (int z = 0; z < objects.size(); z++) {
					LCD.drawInt(objects.get(z).getDistance(), 0, z);
					
				}
		}
		Button.waitForAnyPress();
		
	}
}