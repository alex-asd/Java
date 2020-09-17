public class ReadWriteSafe implements ReadWrite {
	private int readers;
	private int writers;
	private int waitingWriters;

	public ReadWriteSafe() 
	{
		readers = 0;
		writers = 0;
	}

	@Override
	public synchronized void acquireRead() 
	{
		while (writers > 0 || waitingWriters > 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Reader acquired!");
		readers++;
	}

	@Override
	public synchronized void releaseRead() 
	{
		readers--;
		System.out.println("Reader released!");
		if(readers == 0)
			notify();
	}

	@Override
	public synchronized void acquireWrite() 
	{
		waitingWriters++;
		while(readers > 0 || writers > 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		waitingWriters--;
		writers++;
		System.out.println("Writer acquired!");
	}

	@Override
	public synchronized void releaseWrite() 
	{
		writers--;
		System.out.println("Writer released!");
		notifyAll();
	}
}