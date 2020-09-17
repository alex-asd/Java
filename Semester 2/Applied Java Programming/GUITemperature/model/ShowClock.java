package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ShowClock implements Runnable {
	private JLabel jlab;
	private Clock clock;

	public ShowClock(JLabel jlab, Clock clock) 
	{
		this.jlab = jlab;
		this.clock = clock;
	}

	public void run() 
	{
		while(true)
		{
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			jlab.setText(format.format(new Date()));
		}
	}
}