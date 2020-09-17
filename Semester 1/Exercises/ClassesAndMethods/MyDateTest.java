import java.util.Scanner;

public class MyDateTest {
	public static void main(String[] args) {
		/**
		 * MyDate noOne = new MyDate(); MyDate someOne = new MyDate(22,02,2016);
		 * MyDate Aleksandra = new MyDate(); Aleksandra.setNewDate(11, 10,
		 * 2016); MyDate MyLove = new MyDate(); MyLove.setNewDate(12, 2, 1999);
		 * System.out.println("Date with my girl: " + Aleksandra.displayDate());
		 * System.out.println(noOne); System.out.println(someOne);
		 * System.out.println(Aleksandra.isLeapYear() + " " +
		 * Aleksandra.daysInMonth()); System.out.println(someOne.isLeapYear() +
		 * " " + someOne.daysInMonth()); System.out.println(MyLove.isLeapYear()
		 * + " " + MyLove.daysInMonth() + " " + MyLove.getAstroSign() + " " +
		 * MyLove.getMonthName());
		 * 
		 * Scanner input = new Scanner(System.in);
		 * System.out.println("Enter the 1st year"); int firstYear =
		 * input.nextInt(); System.out.println("Enter the end year"); int
		 * endYear = input.nextInt(); int years = 0; for(int i = firstYear; i <=
		 * endYear; i++) { MyDate leapYear = new MyDate(1,1,i);
		 * if(leapYear.isLeapYear()) { years++; } } System.out.println(years);
		 * 
		 * MyDate birthday = new MyDate(12,2,1999); MyDate current = new
		 * MyDate(14,9,2016); int number = 0; while(!((birthday.getDate() ==
		 * current.getDate()) && (birthday.getMonth() == current.getMonth()) &&
		 * birthday.getYear() == current.getYear())) { birthday.nextDay();
		 * number++; } System.out.println("I have lived: " + number);
		 **/
		
		/**	MyDate date1 = new MyDate(11, 10, 2016);
		MyDate date2 = new MyDate(11, 10, 2016);
		MyDate date3 = new MyDate(16, 10, 2016);
		MyDate date4 = date1.copy();
		MyDate date5 = new MyDate(date3);
		System.out.println(date4);
		System.out.println(date1);
		System.out.println(date5);
		date4.nextDays(60);
		date1.nextDays(3);
		date5.nextDays(16);

		/*
		 * if (date1.equals(date2))
		 * System.out.println("Date 1 and Date 2 are similar"); else
		 * System.out.println("Different");
		 * 
		 * if (date1.equals(date5))
		 * System.out.println("Date 1 and Date 5 are similar"); else
		 * System.out.println("Date 1 and Date 5 are different");
		 */
		
		/*MyDate date6 = new MyDate(12, 2, 1999);
		MyDate date7 = new MyDate();
		System.out.println(date6);
		date6.nextDays(7314);
		System.out.println(date6);
		System.out.println(MyDate.today());
		System.out.println(date7.isBefore(date6));
		date6.ne*/
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your birthday date");
		int date = input.nextInt();
		System.out.println("ent ur bday month");
		int month = input.nextInt();
		System.out.println("ent ur bday year");
		int year = input.nextInt();
		input.nextLine();
		System.out.println("ent ur name");
		String name = input.nextLine();
		
		 		MyDate birthday = new MyDate(date, month, year); 
		 		MyDate current = new MyDate(); 
		 		int number = 0; 
		 		while(!((birthday.getDate() ==
		 				current.getDate()) && (birthday.getMonth() == current.getMonth()) &&
		 				birthday.getYear() == current.getYear())) 
		 		{ 
		 			birthday.nextDay();
		 				number++; 
				}
		 		System.out.println(name + ", you have lived: " + number);
		
	}
}
