package programChallenge;

public class ChallangTwo {
	public static void main(String args[])
	{
		String firstName, middleName, lastName;
		char firstInitial, middleInitial, lastInitial;
		
		firstName = "Aleksandar";
		middleName = "Stoyanov";
		lastName = "Dinev";
		firstInitial = 'A';
		middleInitial = 'S';
		lastInitial = 'D';
		
		System.out.print("I am " +firstName);
		System.out.print(" " + middleName);
		System.out.println(" " + lastName);
		System.out.println("My initials are: " + firstInitial + " " + middleInitial + " " +lastInitial);
	}
}
