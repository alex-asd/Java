
public class PersonTest {

	public static void main(String[] args)
	{
		Address naIco = new Address("Ulica", "34a", "Yambol", "Bulgaria");
		Chauffeur ico = new Chauffeur("Icaka Tapaka", naIco, "4aC4ID", "icaka69@abv.bg", "0869696969");
		
		Address naMarti = new Address("Prilep", "69", "Pernik", "Bulgaria");
		Customer marti = new Customer("Martin Stoyanov aka Batmano aka The Flash", naMarti, "0896932313", "martis0721@abv.bg");
		
		Address naLucho = new Address("Banicharnicata", "999", "Pernik", "Bulgaria");
		Passenger lucho = new Passenger("Lachaka Debelaka", naLucho);
		Passenger lucho2 = new Passenger("Lachaka Debelaka", naLucho);
		Date birthday = new Date(6,12,1997);
		lucho2.setBirthday(birthday);
		
		Passenger luci = lucho;
		
		
		System.out.println(ico);
		System.out.println(marti);
		System.out.println(lucho);
		System.out.println(lucho2);
		System.out.println(lucho.equals(lucho2));
		System.out.println(lucho.equals(luci));
	}
}
