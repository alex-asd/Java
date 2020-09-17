package guided.tour;

public class TestMuseum {

	public static void main(String[] args) {
		Museum m = new Museum();
		TourGuide g = new TourGuide(m);
		Thread realG = new Thread(g, "The real G");
		realG.start();
	}
}
