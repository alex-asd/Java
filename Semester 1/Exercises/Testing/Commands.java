import lejos.nxt.MotorPort;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.LCD;
import lejos.nxt.Button;

public class Commands {
	private MotorPort motorL = MotorPort.C;
	private MotorPort motorR = MotorPort.B;
	private UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
	/*
	private MotorPort motorA = MotorPort.A;
	private TouchSensor touch = new TouchSensor(SensorPort.S2);
	private LightSensor light = new LightSensor(SensorPort.S3);
	public Commands(MotorPort motorL, MotorPort motorR, UltrasonicSensor us)
	{
		this.motorL = motorL;
		this.motorR = motorR;
		this.us = us;
	}
	*/
	
	public void moveMotors(int powerL, int directionL, int powerR, int directionR)
	{
		motorL.controlMotor(powerL, directionL);
		motorR.controlMotor(powerR, directionR);
	}
	
	public void stopMotors()
	{
		motorL.controlMotor(0, 3);
		motorR.controlMotor(0, 3);
	}
	
	public void sleep(int n)
	{
		try
		{
		Thread.sleep(n);
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
	}
	
	public int getRange()
	{
		return us.getDistance();
	}
	
	public void spinTo(double tachos)
	{
		while (motorR.getTachoCount() < tachos) {
			motorR.controlMotor(70, 1);
		}
	}
	
	public int getTachoCount(MotorPort motor)
	{
		return motor.getTachoCount();
	}
	
	public void calibrate(LightSensor lsens, String highOrLow)
	{
	   if(highOrLow.equals("high"))
	   {
	      lsens.calibrateHigh();
	   }
	   else if(highOrLow.equals("low"))
	   {
	      lsens.calibrateLow();
	   }
	   
	}
	public void sing()
	{
	   Sound.playTone(880, 250);
      sleep(200);
      Sound.playTone(1174, 250);
      sleep(200);
      Sound.playTone(880, 250);
      sleep(200);
      Sound.playTone(1174, 250);
      sleep(200);
      Sound.playTone(880, 1000);
      sleep(800);
      Sound.playTone(698, 500);
      sleep(400);
      Sound.playTone(783, 500);
      sleep(400);
      Sound.playTone(587, 1000);
      sleep(800);
      Sound.playTone(880, 250);
      sleep(200);
      Sound.playTone(1174, 250);
      sleep(200);
      Sound.playTone(880, 250);
      sleep(200);
      Sound.playTone(1174, 250);
      sleep(200);
      Sound.playTone(880, 1000);
      sleep(800);
      Sound.playTone(698, 500);
      sleep(400);
      Sound.playTone(783, 500);
      sleep(400);
      Sound.playTone(1046, 1000);
      sleep(800);
	}
	
	/*
	public void claw(int powerA, int dirA)
	{
		motorA.controlMotor(powerA, dirA);
		sleep(30);
	}
	*/
	
	
}
