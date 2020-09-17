import java.util.ArrayList;
import java.io.Serializable;

public class ChauffeurList implements Serializable{

	private ArrayList<Chauffeur> chauffeurList;
	
	public ChauffeurList()
	{
		chauffeurList = new ArrayList<Chauffeur>();
	}

	public void addChauffeur(Chauffeur chauffeur) 
	{
		chauffeurList.add(chauffeur);
	}
	
	public void removeChauffeur(Chauffeur chauffeur)
	{
		chauffeurList.remove(chauffeur);
	}
	
	public int size()
	{
		return chauffeurList.size();
	}
	
	
	public boolean checkIfChauffeurIsInList(Chauffeur chauffeur)
	{
		for (int i = 0; i < chauffeurList.size(); i++) {
			if(chauffeur.equals(chauffeurList.get(i)))
				return true;
		}
		return false;	
	}
	
	public Chauffeur getChauffeur(Chauffeur chauffeur)
	{
		for (int i = 0; i < chauffeurList.size(); i++) {
			if (checkIfChauffeurIsInList(chauffeur))
				return chauffeur;
		}
		return null;
	}
	
	public Chauffeur getChauffeurAtIndex(int index)
	{
		return chauffeurList.get(index);
	}
	
	public ArrayList<Chauffeur> getChauffeursByPreference(String type)
	{
		ArrayList<Chauffeur> targets = new ArrayList<Chauffeur>();
		for (int i = 0; i < chauffeurList.size(); i++) {
			for (int j = 0; j < chauffeurList.get(i).getNumberOfPref(); j++) {
				if(chauffeurList.get(i).preferenceByIndex(j).equals(type))
					targets.add(chauffeurList.get(i));
			}
		}
		return targets;
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < chauffeurList.size(); i++) {
			str += chauffeurList.get(i).toString() + '\n';
		}
		return str;
	}
	
}
