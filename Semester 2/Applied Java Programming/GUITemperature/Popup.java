import model.*;
public class Popup {
	public static void main(String[] args)
	{
		Clock clock = new Clock();
		Timer timer = new Timer(clock);
		timer.setTime("11:43:50");
		timer.start();
	}
}
