package guided.tour;

public class Museum {

	private int count;
	private BoundedArrayQueue<Visitor> visitors;
	private boolean guiding;
	
	public Museum()
	{
		count = 0;
		visitors = new BoundedArrayQueue<Visitor>(10);
		guiding = false;
	}
	
	public synchronized void enter(Visitor v)
	{
		while(visitors.isFull() || guiding)
		{
			System.out.println("The guide is on tour, visitor is waiting");
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		visitors.enqueue(v);
		count++;
		if(count == 1)
			notifyAll();
		while(!guiding)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(guiding)
		{
			System.out.println("On a tour: " + Thread.currentThread().getName() + " guiding = " + guiding + " " + count);
		}
	}
	
	public synchronized void startTour()
	{
		while(count <= 0)
		{
			System.out.println("WAITIN FOR VISITORS: ");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		guiding = true;
		System.out.println("starting the tour");
		notifyAll();
	}
	
	public int endTour()
	{
		guiding = false;
		BoundedArrayQueue<Visitor> newQ = new BoundedArrayQueue<Visitor>(10);
		visitors = newQ;
		System.out.println("The tour has ended");
		int count1 = count;
		count = 0;
		System.out.println(Thread.currentThread().getName() + " is starting another tour");
		return count1;
	}
	
	public boolean isFull()
	{
		return visitors.isFull();
	}
}
