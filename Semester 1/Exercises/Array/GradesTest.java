
public class GradesTest {

	public static void main(String[] args)
	{
		GradesList list = new GradesList(15);
		
		list.setGrade(-3, 0);
		list.setGrade(12, 1);
		list.setGrade(10, 2);
		list.setGrade(4, 3);
		list.setGrade(10, 4);
		GradesList list2 = new GradesList(15);
		list2.setGrade(-3, 0);
		list2.setGrade(12, 1);
		list2.setGrade(10, 2);
		list2.setGrade(4, 3);
		list2.setGrade(10, 4);
		list2.setGrade(10, 6);
		System.out.println(list.getNumberOfGrades());
		System.out.println(list.getGrade(0));
		System.out.println(list.getGrade(4));
		System.out.println(list);
		System.out.println(list.getAverage());
		System.out.println(list.equals(list2));
		
	}
}
