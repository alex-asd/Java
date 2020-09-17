import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
public class ClockTest {
	
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		
		int totalTimeInSeconds = input.nextInt();
		Clock clock1 = new Clock(totalTimeInSeconds);
		Clock clock2 = new Clock(1, 30, 40);
		System.out.println(clock1.getHour() + " " + clock1.getMin() + " " + clock1.getSec());
		clock1.tic();
		System.out.println(clock1.getHour() + " " + clock1.getMin() + " " + clock1.getSec());
		System.out.println(clock1.isBefore(clock2));
		System.out.println(clock1.timeInSecondsTo(clock2));
		System.out.println(clock1.timeTo(clock2));
		
	}
}
