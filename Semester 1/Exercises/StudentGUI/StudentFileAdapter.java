import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the students file, making it easy to retrieve and store information.
 * @author Allan Henriksen
 * @version 1.0
 */ 
public class StudentFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where students will be saved and retrieved
    */
   public StudentFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   
   /**
    * Uses the MyFileIO class to retrieve a StudentList object with all Students.
    * @return a StudentList object with all stored students
    */
   public StudentList getAllStudents()
   {
      StudentList students = new StudentList();

      try
      {
         students = (StudentList)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return students;
   }

   /**
    * Use the MyFileIO class to retrieve all students from a given country.
    * @param fromCountry the country to retrieve students from
    * @return a StudentList object with students from the given country
    */
   public StudentList getStudentsFrom(String fromCountry)
   {
      StudentList students = new StudentList();

      try
      {
         StudentList result = (StudentList)mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getCountry().equals(fromCountry))
            {
               students.add(result.get(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return students;
   }
  
   /**
    * Use the MyFileIO class to save some students.
    * @param students the list of students that will be saved
    */
   public void saveStudents(StudentList students)
   {
      try
      {
         mfio.writeToFile(fileName, students);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
  
   /**
    * Uses the MyFileIO class to change the country of a student with 
    * the given first name and last name.
    * @param firstName the first name of the student
    * @param lastName the last name of the student
    * @param country the student's new country
    */
   public void changeCountry(String firstName, String lastName, String country)
   {
      StudentList students = getAllStudents();

      for (int i = 0; i < students.size(); i++)
      {
         Student student = students.get(i);

         if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
         {
            student.setCountry(country);
         }
      }

      saveStudents(students);
   }

   // Add more methods to the adapter depending on what you wish to do
}
