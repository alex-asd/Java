
public class PersonTest {

	public static void main(String[] args)
	{
		Person Aleksandra = new Person("Aleksandra", "Female", 17);
		Person Aleksandar = new Person("Aleksandar", "Male", 19);
		Person Jane = new Person("Jane", "Female", 17);
		Person Dimcho = new Person("Jane", "Female", 17);
		
		System.out.println(Dimcho.equals(Aleksandar));
		System.out.println(Jane.equals(Dimcho));
		System.out.println(Aleksandar.getName() + " " + Aleksandra.getName());
		Jane.setName("Penka");
		System.out.println(Jane.equals(Dimcho));
		System.out.println(Aleksandra);
		System.out.println(Aleksandar.canHeGoOutWithOtherFuckinGirls(Aleksandar));
		System.out.println(Aleksandar.getEngaged());
		Aleksandar.engagedTwoPersons(Aleksandra);
		System.out.println(Aleksandar.getEngaged());
		System.out.println(Aleksandar.canHeGoOutWithOtherFuckinGirls(Aleksandar));
	}
}
