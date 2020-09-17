public class Address
{
   private String street;
   private String number;

   private String city;

   public Address(String str, String no, String ci)
   {
      street = str;
      number = no;
      city = ci;

   }

   public Address()
   {
      street = "";
      number = "";
      city = "";

   }

   public String getStreet()
   {
      return street;
   }

   public void setStreet(String street)
   {
      this.street = street;
   }

   public String getNumber()
   {
      return number;
   }

   public void setNumber(String number)
   {
      this.number = number;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public String toString()
   {
      return street + " " + number + " " + city;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Address))
      {
         return false;
      }
      Address other = (Address) obj;

      return street == other.street && number == other.number
            && city == other.city;
   }
}
