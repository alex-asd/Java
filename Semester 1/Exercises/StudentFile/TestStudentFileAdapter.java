public class TestStudentFileAdapter
{
	public static void main(String[] args)
	{
	   StudentFileAdapter sfa = new StudentFileAdapter("students.bin");
  	      
      // Get all students from the file and print them out
   	StudentList list = sfa.getAllStudents();
		System.out.println("All students:");
		System.out.println("------------------------------------------------------------");
		System.out.println(list);
  
		// Get all Polish students from the file and print them out
		list = sfa.getStudentsFrom("Poland");
		System.out.println("Polish students:");
		System.out.println("------------------------------------------------------------");
		System.out.println(list);
		
	   // Get all Italian students from the file and print them out
      list = sfa.getStudentsFrom("Italy");
      System.out.println("Italian students:");
      System.out.println("------------------------------------------------------------");
      System.out.println(list);

      // Change student's country
		sfa.changeCountry("Roberto", "Sannazzaro", "Poland");
	
      // Get all Polish students from the file and print them out
      list = sfa.getStudentsFrom("Poland");
      System.out.println("Polish students:");
      System.out.println("------------------------------------------------------------");
      System.out.println(list);
      
      // Get all Italian students from the file and print them out
      list = sfa.getStudentsFrom("Italy");
      System.out.println("Italian students:");
      System.out.println("------------------------------------------------------------");
      System.out.println(list);
	}
}
