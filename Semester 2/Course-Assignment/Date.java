package CourseAssignment;

import java.io.Serializable;

public class Date implements Serializable
{
   private int day;
   private int month;
   private int year;
   
   public Date(int day, int month, int year)
   {
      this.day = day;
      this.month = month; 
      this.year = year;
   }
   
   public int getDay()
   {
      return day;
   }
   
   public int getMonth()
   {
      return month;
   }
   
   public int getYear()
   {
      return year;
   }
   
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
   
   public int compareTo(Date date)
   {
      if (day == date.getDay() && month == date.getMonth() && year == date.getYear()) return 0;
      
      if (year > date.getYear()) return 1;
      
      if (month > date.getMonth() && year == date.getYear()) return 1;
      
      if (day > date.getDay() && month == date.getMonth() && year == date.getYear()) return 1;
      
      return -1;
   }
}
