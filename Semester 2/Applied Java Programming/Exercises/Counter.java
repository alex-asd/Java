
public class Counter {

	private long value;
	private long max;
	private long min;
	
	public Counter(long min, long max)
	{
		this.min = min;
		this.max = max;
		value = 0;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min;
	}
	
	public synchronized void increment() throws InterruptedException
	{
		if(value >= max)
			wait();
		value++;
		notifyAll();
		System.out.println(value + ": " + Thread.currentThread().getName());
	}
	
	public synchronized void decrement()
	{
		if(value <= min)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		value--;
		notifyAll();
		System.out.println(value + ": " + Thread.currentThread().getName());
	}
	
}
