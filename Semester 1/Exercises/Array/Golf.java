
public class Golf {

	public static void main(String[] args)
	{
		int[] shots = {3, 5, 1, 3, 3, 2, 4, 2, 3};
		int holeInOne = 0, total = 0;
		for (int i = 0; i < shots.length; i++) 
		{
			if (shots[i] == 1) 
				holeInOne++;
			else
				total+= shots[i];
		}
		System.out.println("Total hits: " + (total + holeInOne));
		System.out.println("Average hits per hole: " + (total + holeInOne)/shots.length);
		System.out.println("Oneshots: " + holeInOne);
	}
}
