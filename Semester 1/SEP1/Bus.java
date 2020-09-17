
public class Bus
{
   private String type;
   private int capacity;
   private String regNo;
   
   public Bus(String type, int capacity, String regNo)
   {
      this.type = type;
      this.capacity = capacity;
      this.regNo = regNo;
   }

   public String getType()
   {
      return type;
   }

   public int getCapacity()
   {
      return capacity;
   }
   
   public String getRegNo()
   {
      return regNo;
   }
   
   public boolean equals(Object obj)
   {
      if(!(obj instanceof Bus))
         return false;
      
      Bus other = (Bus)obj;
      return regNo.equals(other.regNo);
   }
   
   public String toString()
   {
      return type + " " + "(" + capacity + ")";
   }
  
}
