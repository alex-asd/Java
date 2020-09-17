package CourseAssignment;

import java.io.Serializable;

public class Interval implements Serializable
{
   private Date startDate;
   private Date endDate;
   
   public Interval(Date startDate, Date endDate)
   {
      this.startDate = startDate;
      this.endDate = endDate;
   }
   
   public Date getStartDate()
   {
      return startDate;
   }
   
   public Date getEndDate()
   {
      return endDate;
   }
   
   public boolean inInterval(Interval interval)
   {
      return startDate.compareTo(interval.getStartDate()) >= 0 && endDate.compareTo(interval.getEndDate()) <= 0;
   }
   
   public String toString()
   {
      return startDate + " - " + endDate; 
   }
}
