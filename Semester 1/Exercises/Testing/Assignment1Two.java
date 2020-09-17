import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class Assignment1Two {
	public static void main(String[] args) {
		int close = 30;
		int fine = 60;
		int stop = 15;
		UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
		Commands com = new Commands();

		Button.waitForAnyPress();
		while (!Button.ENTER.isDown()) {
			if (us.getDistance() <= stop) {
				com.stopMotors();
				com.sleep(30);
				if (us.getDistance() < 30) {
					com.moveMotors(80, 1, 0, 1);
				}
			} else if (us.getDistance() <= close) {
				com.moveMotors(90, 1, 60, 1);
				com.sleep(30);
			} else if (us.getDistance() <= fine) {
				com.moveMotors(80, 1, 80, 1);
				com.sleep(30);
			} else if (us.getDistance() > fine) {
				com.moveMotors(60, 1, 90, 1);
				com.sleep(30);
			}

		}
	}
}