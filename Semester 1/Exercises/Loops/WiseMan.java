public class WiseMan {
	public static void main(String[] args) {

		int board = 8 * 8;
		double grane = 1;
		double granes = 1;

		for (int i = 0; i < board; i++) 
		{
			grane = grane * 2;
			granes += grane;
		}
		System.out.println(granes);
	}
}
