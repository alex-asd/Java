package programChallenge;

public class ChallengeSix {
	public static void main(String args[])
	{
		double radius = 22.5;
		double circumference, area;
		double squareRadius = radius*radius;
		
		circumference = Math.PI*2*radius;
		area = Math.PI*squareRadius;
		
		System.out.println("circumference: " +circumference + " | area = " + area);
	}
}
