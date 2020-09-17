
public class CourseTest {
	public static void main(String[] args)
	{
		Course it = new Course("IT","50",true );
		Course math = new Course("Math", true );
		Course language = new Course();
		
		it.setName("Information Technology");
		it.setNumber("49");
		
		math.setCourse(false);
		
		System.out.println(it);
		System.out.println(math);
		System.out.println(language);
	}
}
