
public class ChauffeurListTest {

	public static void main(String[] args)
	{
		Address naIco = new Address("Ulica", "34a", "Yambol", "Bulgaria");
		Chauffeur ico = new Chauffeur("Icaka", naIco, "4aC4ID", "icaka69@abv.bg", "0869696969");
		ico.addPreference("party");
		
		Address st = new Address("Street", "5as42s", "Sofia", "Sofia");
		Chauffeur Andon = new Chauffeur("Andon", st, "s4123123", "sasas@sasa.bg", "203021301");
		Andon.addPreference("party");
		
		Address naJhon = new Address("Ulica", "34c", "Yambol", "Bulgaria");
		Chauffeur jhon = new Chauffeur("Jhon", naJhon, "4a45ID", "icaka69@abv.bg", "0869696969");
		jhon.addPreference("party");
		jhon.addPreference("kurci");
		jhon.addPreference("sex");
		
		Address naBoris = new Address("Ulica", "34d", "Yambol", "Bulgaria");
		Chauffeur boris= new Chauffeur("Boris", naBoris, "5aC4ID", "icaka69@abv.bg", "0869696969");
		boris.addPreference("kurci");
		
		Address naJhin = new Address("Ulica", "34e", "Yambol", "Bulgaria");
		Chauffeur jhin = new Chauffeur("Jhin", naJhin, "four4u", "icaka44@abv.bg", "4444444444");
		jhin.addPreference("party");
		jhin.addPreference("kurci");
		jhin.addPreference("sex");
		
		ChauffeurList list = new ChauffeurList();
		list.addChauffeur(jhin);
		list.addChauffeur(boris);
		list.addChauffeur(jhon);
		list.addChauffeur(ico);
		list.addChauffeur(Andon);
		
		System.out.println(list.getChauffeursByPreference("party"));
		System.out.println("sex nadolo");
		System.out.println(list.getChauffeursByPreference("sex"));
		System.out.println("kurci nadolo");
		System.out.println(list.getChauffeursByPreference("kurci"));
	}
}
