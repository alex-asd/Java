import java.util.ArrayList;


public class TaskList
{
   private ArrayList<String> tasks;
   
   public TaskList()
   {
      tasks = new ArrayList<String>();
   }
   public synchronized void add(String task)
   {
      tasks.add(task);
   }
   public synchronized String getAndRemoveNextTask()
   {
      String task = null;
      if (tasks.size() > 0)
      {
         task = tasks.get(0);
         tasks.remove(0);
      }
      return task;
   }
   public int size()
   {
      return tasks.size();
   }

}
