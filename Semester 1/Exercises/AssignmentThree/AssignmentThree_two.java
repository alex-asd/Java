import java.util.ArrayList;
import lejos.nxt.LCD;
import lejos.nxt.Button;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;

public class Assignment3
{

   public static void main(String[] args)
   {
      MotorPort motorL = MotorPort.C;
      MotorPort motorR = MotorPort.B;
      UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
      ArrayList<Obj> objects = new ArrayList<Obj>();
      Commands com = new Commands();
      double wheelCirc = 5.6 * Math.PI;
      double wheelDist = 17 * 2 * Math.PI;
      double turn = (wheelDist / wheelCirc) * 360;
      int num = 1;

      Button.waitForAnyPress();
      while (motorR.getTachoCount() < turn)
      {
         motorR.controlMotor(64, 1);
         if (us.getDistance() < 70)
         {
            motorR.controlMotor(64, 1);
            com.sleep(40);
            Obj objective = new Obj(us.getDistance(), num, motorR.getTachoCount(),((motorR.getTachoCount() / turn) * 360));
            objects.add(objective);
            if(objects.size()>1)
            {
               for(int i=objects.size()-1; i>0; i--)
               {
                     if(objects.get(i).getAngle()-objects.get(i-1).getAngle()<=30)
                     {
                        objects.remove(i);
                        num--;
                     }
               }
            }
            num++;
            Sound.playTone(3000, 100);
            while (us.getDistance() < 80)
            {
               motorR.controlMotor(64, 1);
            }
         }
      }
      motorR.controlMotor(100, 3);
      LCD.drawString("obj", 0, 0);
      LCD.drawString("dist", 5, 0);
      LCD.drawString("ang", 11, 0);

      for (int i = 0; i < objects.size(); i++)
      {
         LCD.drawInt(objects.get(i).getObjNumber(), 0, i + 1);
         LCD.drawInt(objects.get(i).getDistance(), 5, i + 1);
         LCD.drawInt((int) objects.get(i).getAngle(), 11, i + 1);
      }
      motorR.resetTachoCount();
      com.sleep(1000);

      for (int i = 0; i < objects.size(); i++)
      {
         while (motorR.getTachoCount() < objects.get(i).getTachos())
         {
            motorR.controlMotor(64, 1);
         }
         motorR.controlMotor(84, 1);
         com.sleep(240);
         motorR.controlMotor(65, 3);

         Sound.playTone(7000, 1000);
         LCD.clear(i + 1);
         com.sleep(1300);

      }
      Button.waitForAnyPress();

   }
}