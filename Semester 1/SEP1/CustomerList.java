import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
   private ArrayList<Customer> customers;
   
   public CustomerList()
   {
      customers = new ArrayList<Customer>();
   }
   
   public void addCustomer(Customer cust)
   {
      customers.add(cust);
   }
   
   public void removeCustomer(Customer cust)
   {
      customers.remove(cust);
   }
   
   public int getCustomerFrequency(Customer cust)
   {
      return cust.getFrequency();
   }
   
   public void addFrequency(Customer cust)
   {
      cust.addFrequency();
   }
   
   public int size()
   {
      return customers.size();
   }
   
}
