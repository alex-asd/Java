
public class PersonTest {
	public static void main(String[] args)
	{
		Person noOne = new Person();
		Person someOne = new Person("Aleksandar", "22/02/1997");
		Person pesho = new Person();
		pesho.setName("Pesho Peshof");
		pesho.setBirthday("11.01.1990");
		
		Person koza = new Person();
		koza.setName("Maria");
		koza.setBirthday("Its a fuckin animal, who cares");
		
		System.out.println("Name: " + pesho.getName() + ";" + " Birthday: " + pesho.getBirthday());
		System.out.println("Name: " + koza.getName() + ";" + " Birthday: " + koza.getBirthday());
		System.out.println(noOne);
		System.out.println(someOne);
	}
}
