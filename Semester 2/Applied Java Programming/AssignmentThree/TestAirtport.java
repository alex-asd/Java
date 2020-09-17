
public class TestAirtport {

	public static void main(String[] args) {
		AirportQueue usaQueue = new AirportQueue();
		AirportQueue nonUsaQueue = new AirportQueue();

		Guide g = new Guide(usaQueue, nonUsaQueue);
		Thread guide = new Thread(g, "Guide Koza");
		guide.start();
		
		PassportController c1 = new PassportController(usaQueue);
		PassportController c2 = new PassportController(nonUsaQueue);
		
		Thread controllerUsa = new Thread(c1, "Controller Jhon");
		Thread controllerNonUsa = new Thread(c2, "Controller Uewuweuwew Osass");
		controllerUsa.start();
		controllerNonUsa.start();
		
	}
}
