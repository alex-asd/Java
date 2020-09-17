import java.util.ArrayList;

import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;

public class Sumo2
{
   public static void main(String[] args)
   {
      Commands com = new Commands();
      double wheelCirc = 5.6 * Math.PI;
      double wheelDist = 12.5 * 2 * Math.PI;
      double turn = (wheelDist / wheelCirc) * 180;
     
      
      
      UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
      MotorPort motorL = MotorPort.C;
      MotorPort motorR = MotorPort.B;

      Button.waitForAnyPress();
      //Light Sensor Calibration
      LightSensor frontLs = new LightSensor(SensorPort.S3);
      LCD.drawString("Cal. front Low", 0, 0);
      LCD.drawString("Press enter to calibrate", 0, 3);
      Button.ENTER.waitForPress();
      com.calibrate(frontLs, "low");
      
      LCD.clear();
      LCD.drawString("Low calibrated.", 0, 0);
      LCD.drawString("Cal. front high", 0, 3);
      Button.ENTER.waitForPress();
      com.calibrate(frontLs, "high");
      
      LCD.clear();
      LightSensor backLs = new LightSensor(SensorPort.S4);
      LCD.drawString("Front calibrated.", 0, 0);
      LCD.drawString("Cal. rear low", 0, 3);
      Button.ENTER.waitForPress();
      com.calibrate(backLs, "low");
      
      LCD.clear();
      LCD.drawString("Low calibrated", 0, 0);
      LCD.drawString("Cal. rear high", 0, 3);
      Button.ENTER.waitForPress();
      com.calibrate(backLs, "high");
      
      LCD.clear();
      LCD.drawString("LSens calibrated", 0, 0);
      //Calibration done.
      com.sing();
      Button.waitForAnyPress();
      com.sleep(3000); // wait 3 seconds before it starts the match.
      
      
      //spin 180°
      while (motorL.getTachoCount() < turn)
      {
         motorL.controlMotor(100, 1);
      }
      motorL.controlMotor(100, 3);
      com.sleep(200);
      motorL.resetTachoCount(); //Just in case
      
      //FIGHT!
      long startTime = System.currentTimeMillis() / 1000;
      long finish=0;
      while (finish < startTime + 90)
      {
         if (frontLs.readValue() < 60) {
            com.moveMotors(100, 2, 100, 2);
            com.sleep(400);
            com.moveMotors(100, 1, 100, 2);
            com.sleep(400);
         }
         if (backLs.readValue() < 60) {
           com.moveMotors(100, 1, 100, 1);
           com.sleep(100);
         }
         finish = System.currentTimeMillis() / 1000;
         LCD.clear();
         String sd = String.valueOf(finish);
         LCD.drawString(sd, 0, 0);
         

         if (us.getDistance() < 40)
         {
            motorL.controlMotor(84, 1);
            com.sleep(180);
            while(us.getDistance() < 40 && finish < startTime + 90){
               finish = System.currentTimeMillis() / 1000;
               com.moveMotors(100, 1, 100, 1);
            }
         } 
         
         else
         {
            motorL.controlMotor(100, 1);
            motorR.controlMotor(100, 3);
            if (frontLs.readValue() < 75) {
                com.moveMotors(100, 2, 100, 2);
                com.sleep(400);
                com.moveMotors(100, 1, 100, 2);
                com.sleep(400);
             }
             if (backLs.readValue() < 75) {
               com.moveMotors(100, 1, 100, 1);
               com.sleep(150);
             }
         }
         

      }  
      com.sing();
   }
}
