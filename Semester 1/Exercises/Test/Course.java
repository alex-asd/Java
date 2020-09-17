
public class Course {
	private String name;
	private String numberOfStudents;
	private boolean electiveCourse;
	
	public Course(String name, String numberOfStudents, boolean electiveCourse)
	{
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.electiveCourse = electiveCourse;
	}
	
	public Course(String name, boolean electiveCourse)
	{
		this.name = name;
		this.numberOfStudents = "0";
		this.electiveCourse = electiveCourse;
	}
	
	public Course()
	{
		this.name = "John";
		this.numberOfStudents = "0";
		this.electiveCourse = false;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNumberOfStudents()
	{
		return numberOfStudents;
	}
	
	public boolean getElective()
	{
		return electiveCourse;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setNumber(String numberOfStudents)
	{
		this.numberOfStudents = numberOfStudents;
	}
	
	public void setCourse(boolean electiveCourse)
	{
		this.electiveCourse = electiveCourse;
	}
	
	public String toString()
	{
		return "Name: " + name + '\n' + "Number of students: " + numberOfStudents + '\n' + "Elective course: "
				+ electiveCourse;
	}
}
