public abstract class Person
{
   private String name;
   private Address address;

   public Person(String name, Address address)
   {
      this.name = name;
      this.address=address;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Address getAddress()
   {
      return address;
   }

   public String getShortAddress()
   {
      return address.getStreet() + " " + address.getNumber();
   }

   public void setAddress(Address address)
   {
      this.address = address;
   }

   public String toString()
   {
      return name + " / " + address;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof Person))
      {
         return false;
      }
      Person other = (Person) obj;
      return name == other.name && address == other.address;

   }

}
