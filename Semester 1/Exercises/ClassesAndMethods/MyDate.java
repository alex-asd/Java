import java.util.GregorianCalendar;
public class MyDate {
	private int date;
	private int month;
	private int year;

	public MyDate(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}

	public MyDate() 
	{
		date = today().date;
		month = today().month;
		year = today().year;
	}
	
	public MyDate(MyDate obj)
	{
		date = obj.date;
		month = obj.month;
		year = obj.year;
	}

	public void setNewDate(int newDate, int newMonth, int newYear) {
		date = newDate;
		month = newMonth;
		year = newYear;
	}

	public String displayDate() {
		return (date + "/" + month + "/" + year);
	}

	public String toString() {
		return "Date: " + date + " Month: " + month + " Year: " + year;
	}

	public boolean isLeapYear() {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}

	public int daysInMonth() {
		if (this.month == 1)
			return 31;

		else if (this.month == 2) {
			if (isLeapYear()) {
				return 29;
			} else {
				return 28;
			}
		}

		else if (this.month == 3)
			return 31;

		else if (this.month == 4)
			return 30;

		else if (this.month == 5)
			return 31;

		else if (this.month == 6)
			return 30;

		else if (this.month == 7)
			return 31;

		else if (this.month == 8)
			return 31;

		else if (this.month == 9)
			return 30;

		else if (this.month == 10)
			return 31;

		else if (this.month == 11)
			return 30;

		else if (this.month == 12)
			return 31;

		else
			return 0;

	}

	public String getAstroSign() 
	{
		if ((this.date >= 21 && this.month == 3)
				|| (this.date <= 19 && this.month == 4))
			return "Aries";

		else if ((this.date >= 20 && this.month == 4)
				|| (this.date <= 20 && this.month == 5))
			return "Taurus";

		else if ((this.date >= 21 && this.month == 5)
				|| (this.date <= 20 && this.month == 6))
			return "Gemini";

		else if ((this.date >= 21 && this.month == 6)
				|| (this.date <= 22 && this.month == 7))
			return "Cancer";

		else if ((this.date >= 23 && this.month == 7)
				|| (this.date <= 22 && this.month == 8))
			return "Leo";

		else if ((this.date >= 23 && this.month == 8)
				|| (this.date <= 22 && this.month == 9))
			return "Virgo";

		else if ((this.date >= 23 && this.month == 9)
				|| (this.date <= 22 && this.month == 10))
			return "Libra";

		else if ((this.date >= 23 && this.month == 10)
				|| (this.date <= 21 && this.month == 11))
			return "Scorpio";

		else if ((this.date >= 22 && this.month == 11)
				|| (this.date <= 21 && this.month == 12))
			return "Sagittarius";

		else if ((this.date >= 22 && this.month == 12)
				|| (this.date <= 19 && this.month == 1))
			return "Capricorn";

		else if ((this.date >= 20 && this.month == 1)
				|| (this.date <= 18 && this.month == 2))
			return "Aquarius";

		else if ((this.date >= 19 && this.month == 2)
				|| (this.date <= 20 && this.month == 3))
			return "Pisces";
		else
			return "You entered something wrong";
	}

	public String getMonthName() 
	{
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";

		}
		return "Error";
	}

	public void nextDay() 
	{
		this.date++;
		if (this.date > daysInMonth()) {
			date = 1;
			month++;
		}

		if (this.month > 12) {
			month = 1;
			year++;
		}
	}

	public int getDate() 
	{
		return date;
	}

	public int getMonth() 
	{
		return month;
	}

	public int getYear() 
	{
		return year;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof MyDate))
		{
			return false;
		}
		MyDate fixed = (MyDate)obj;
		return (date == fixed.date &&
				month == fixed.month &&
				year == fixed.year);
	}
	
	public MyDate copy()
	{
		return new MyDate(date, month, year);
	}
	
	public void nextDays(int days)

	{
		int i = 0;
		while(i < days)
		{
			nextDay();
			i++;
		}
		/**date = date + days;
		int difference = daysInMonth() - date;
		if(difference < 0)
		{
			date = difference * -1;
			month++;
		}
		
		else if(difference <= 31)
		{
			
		}
		
		else if(difference == 0)
			date = 1;
		
		else if(difference > 0)
		29 + 4 = 33; 31 - 33 = -3
			10 + 30 = 40; 31 .. 9
	 		29 + 2 = 31; 31-31;
			29 + 1 = 30; 31 - 30;
			**/
	}
	
	public static MyDate today()
	{
		GregorianCalendar currentDate = new GregorianCalendar();
		int currentDay = currentDate.get(GregorianCalendar.DATE);
		int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
		int currentYear = currentDate.get(GregorianCalendar.YEAR); 
		
		return new MyDate(currentDay, currentMonth, currentYear);
	}
	
	public boolean isBefore(MyDate date2)
	{
		if(year < date2.year)
			return true;
		else if(month < date2.month)
			return true;
		else if(date < date2.date)
			return true;
		else 
			return false;
	}
	
}
