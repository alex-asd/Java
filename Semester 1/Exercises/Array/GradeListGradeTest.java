
public class GradeListGradeTest {

	public static void main(String[] args)
	{
		GradesListGrade list = new GradesListGrade(10);
		list.setGrade(10, 0, "SDJ1");
		list.setGrade(12, 1, "RWD1");
		list.setGrade(3, 2, "SMTHN");
		list.setGrade(4, 3, "KUREC");
		list.setGrade(0, 4, "CSE1");
		list.setGrade(3, 9, "LoL");
		GradesListGrade list2 = new GradesListGrade(10);
		list2.setGrade(10, 0, "SDJ1");
		list2.setGrade(12, 1, "RWD1");
		list2.setGrade(3, 2, "SMTHN");
		list2.setGrade(4, 3, "KUREC");
		list2.setGrade(0, 4, "CSE1");
		list2.setGrade(3, 9, "LoL");
		System.out.println(list2.equals(list));
	}
}
