import java.util.GregorianCalendar;
public class Date
{
   private int date;
   private int month;
   private int year;
   private int hour;
   private int minutes;
   
   
   
   GregorianCalendar currentDate = new GregorianCalendar();
   int currentDay = currentDate.get(GregorianCalendar.DATE);
   int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
   int currentYear = currentDate.get(GregorianCalendar.YEAR); 
   
   public Date(int date, int month, int year, int hour, int minutes)
   {
      this.date = date;
      this.month = month;
      this.year = year;
      this.hour = hour;
      this.minutes = minutes;
   }
   
   public Date(int date, int month, int year)
   {
      this.date = date;
      this.month = month;
      this.year = year;
      hour = -1;
      minutes = -1;
   }

   public Date()
   {
      date = currentDay;
      month = currentMonth;
      year = currentYear;
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
   
   public String getHourAndMinuts()
   {
      return hour + ":" + minutes;
   }
   
   public int getHour()
   {
      return hour;
   }
   
   public int getMinutes()
   {
      return minutes;
   }

   public void setNewDate(int newDate, int newMonth, int newYear)
   {
      date = newDate;
      month = newMonth;
      year = newYear;
   }

   public String displayDate()
   {
      return (date + "/" + month + "/" + year);
   }

   public String toString()
   {
      String str = date + "/" + month + "/" + year+" ";
      if(hour==-1){
      return str;
      } else {
         if(hour<10){
            
            str+="0"+hour;
         }
         else
         {
            str+=hour;
         }
         if(minutes<10){
            
            str+=":0"+minutes;
         }
         else
         {
            str+=":"+minutes;
         }
         return str;  
      }
   }
   
   public boolean isLeapYear()
   {
      if (this.year % 4 == 0)
         return true;
      else
         return false;
   }

   public int daysInMonth()
   {
      if (this.month == 1)
         return 31;

      else if (this.month == 2)
      {
         if (isLeapYear())
         {
            return 29;
         }
         else
         {
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

   public String getMonthName()
   {
      switch (month)
      {
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

         default:
            return "Error";
      }
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Date))
      {
         return false;
      }
      Date other = (Date)obj;
      if(hour==-1 || minutes==-1){
         return date == other.date && month == other.month && year == other.year;
      } else {
         return date == other.date && month == other.month && year == other.year &&
               hour == other.hour && minutes == other.minutes;
      }
   }

   public void nextDay() {
      this.date++;
      if (this.date > daysInMonth()) 
      {
         date = 1;
         month++;
      }

      if (this.month > 12) 
      {
         month = 1;
         year++;
      }
   }

   public Date copyWithClock()
   {
      return new Date(date, month, year, hour, minutes);
   }
   
   public Date copy()
   {
      return new Date(date, month, year);
   }

   public void  nextDays(int days)
   {
      for (int i = 1; i <= days; i++)
      {
         nextDay();
      }
   }
   
   public boolean isBefore(Date date2)
   {
      if(hour!=-1 && date2.getHour() != -1){
         return year<date2.year && month<date2.month && date<date2.date && hour<date2.hour 
            && minutes<date2.minutes;
      }     
      return year<date2.year && month<date2.month && date<date2.date;           
   }

   public static Date today()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR); 
      
      return new Date(currentDay, currentMonth, currentYear);
   }


}