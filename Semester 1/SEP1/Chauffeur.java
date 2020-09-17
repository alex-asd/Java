import java.util.ArrayList;
import java.io.Serializable;

public class Chauffeur extends Person implements Serializable{

	private String id;
	private String email;
	private String phone;
	private ArrayList<String> preferences;
	
	public Chauffeur(String name, Address address, String id, String email, String phone)
	{
		super(name, address);
		this.id = id;
		this.email = email;
		this.phone = phone;
		preferences = new ArrayList<String>();
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
//	public Chauffeur copy()
//	{
//		return (Chauffeur)
//	}
	
	public void addPreference(String pref)
	{
		preferences.add(pref);
	}
	
	public int getNumberOfPref()
	{
		return preferences.size();
	}
	
//	public Chauffeur checkReferences(String type)
//	{
//		Chauffeur obj = 
//		for (int i = 0; i < preferences.size(); i++) {
//			if(type.equals(preferences.get(i)))
//				return (Chauffeur)
//		}
//	}
	
	public String preferenceByIndex(int index)
	{
	   return preferences.get(index);
	}
	
	public String toString()
	{
		return super.toString() + " / "+ id + " / " + email + " / " + phone + "\n";
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Chauffeur))
			return false;
		Chauffeur chauffeur = (Chauffeur)obj;
		return super.equals(obj) && id.equals(chauffeur.id) && email.equals(chauffeur.email)
				&& phone.equals(chauffeur.phone);
	}
}
