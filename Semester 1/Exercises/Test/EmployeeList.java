import java.util.ArrayList;

public class EmployeeList {

	private int size;
	private ArrayList<Employee> employees;
	
	public EmployeeList(int maxNumberOfEmployees)
	{
		size = maxNumberOfEmployees ;
		employees = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee)
	{
		if(size > employees.size())
			employees.add(employee);
	}
	
	public void removeEmployee(Employee employee)
	{
		employees.remove(employee);
	}
	
	public int getNumberOfEmployees()
	{
		return employees.size();
	}
	
	public Employee[] getAllEmployees()
	{
		Employee[] arrEmp = new Employee[employees.size()];
		arrEmp = employees.toArray(arrEmp);
		return arrEmp;
	}
	
	public double getTotalEarningsPerWeek()
	{
		double total = 0;
		for (int i = 0; i < employees.size(); i++) 
		{
			total += employees.get(i).earningsPerWeek();
		}
		return total;
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < getAllEmployees().length; i++) 
		{
			str+= "Employee: " + getAllEmployees()[i].getName() + "  " 
					+ "Birthday: " + getAllEmployees()[i].getBirthday() + "  "
					+ "earns per week: " + getAllEmployees()[i].earningsPerWeek() + '\n';
		}
		return str;
	}
	
	public boolean equals(Object obj)
	{
		boolean bol = true;
		if(!(obj instanceof EmployeeList))
			return false;
		EmployeeList list = (EmployeeList)obj;
		if(employees.size() != list.employees.size())
			return false;
		for(int i=0; i<employees.size(); i++)
		{
			if(!(employees.get(i).equals(list.employees.get(i))))
				bol = false;
		}
		return size == list.size && bol;
	}
}
