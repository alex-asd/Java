package CourseAssignment;

import java.io.Serializable;

public class Route implements Serializable
{
   private String from;
   private String to;
   private Date startOnDate;
   private Date endOnDate;
   private String chauffeurName;
   private String busType;
   
   public Route(String from, String to, Date startOnDate, Date endOnDate, String chauffeurName, String busType)
   {
      this.from = from;
      this.to = to;
      this.startOnDate = startOnDate;
      this.endOnDate = endOnDate;
      this.chauffeurName = chauffeurName;
      this.busType = busType;
   }
   
   public Date getStartOnDate()
   {
      return startOnDate;
   }
   
   public Date GetEndOnDate()
   {
      return endOnDate;
   }
   
   public String toString()
   {
      return "Route " + from + " - " + to + "\n" +
             startOnDate + "-" + endOnDate + "\n" +
            "Chauffeur Name : " + chauffeurName + "\n" + 
             "Bus Type : " + busType;
   }
}
