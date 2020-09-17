package CourseAssignment.domain.model;

import java.util.ArrayList;

public class History
{
   private ArrayList<String> history;
   
   public History()
   {
      history = new ArrayList<String>();
   }
   
   public void addAction(String s)
   {
      history.add(s);
   }
}
