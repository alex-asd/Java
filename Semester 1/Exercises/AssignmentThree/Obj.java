public class Obj
{

   private int distance;
   private int objNumber;
   private int tachos;
   private double angle;

   public int getTachos()
   {
      return tachos;
   }

   public void setTachos(int tachos)
   {
      this.tachos = tachos;
   }

   public Obj(int distance, int objNumber, int tachos,double angle)
   {
      this.distance = distance;
      this.objNumber = objNumber;
      this.tachos = tachos;
      this.angle=angle;
   }

   public int getDistance()
   {
      return distance;
   }

   public void setDistance(int distance)
   {
      this.distance = distance;
   }

   public int getObjNumber()
   {
      return objNumber;
   }

   public void setName(int objNumber)
   {
      this.objNumber = objNumber;
   }

   public double getAngle()
   {
      return angle;
   }

   public void setAngle(int angle)
   {
      this.angle = angle;
   }

}
