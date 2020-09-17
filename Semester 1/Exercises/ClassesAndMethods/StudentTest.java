
public class StudentTest {
	public static void main(String[] args)
	{
		Student pesho = new Student("Pesho", 'M', 393939);
		Student ivan = new Student("Ivan", 'M');
		Student koza = new Student("Its a fuckin goat man", 'F', 123321);
		System.out.println(pesho.getName() + pesho.getGender() + pesho.getId());
		System.out.println(ivan.getName() + ivan.getGender() + ivan.getId());
		System.out.println(koza.getName() + koza.getGender() + koza.getId());
		ivan.setNumber(111111);
		System.out.println("Ivan has a new ID:" + ivan.getId());
		koza.setName("Petra");
		System.out.println("Now our goat who is a student has a name: " + koza.getName());
	}
}
