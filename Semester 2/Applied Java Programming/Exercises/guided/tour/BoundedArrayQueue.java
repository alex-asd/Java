package guided.tour;

public class BoundedArrayQueue<T> implements QueueATD<T>{

	private int front;
	private int count;
	private T[] queue;

	public BoundedArrayQueue(int capacity)
	{
		front = 0;
		count = 0;
		queue = (T[]) new Object[capacity];
	}
	
	public String toString()
	{
		String str = " ";
		
		for (int i = front; i < count; i++) {
			str += queue[i] + " ";
		}
		
		return str;
	}

	public void enqueue(T element) 
	{
		if(isFull())
			throw new IllegalStateException();
		
		if(isEmpty())
		{
			front = 0;
			queue[front] = element;
			count++;
		}
		else
		{
			int rear = (count + front) % queue.length;
			queue[rear] = element;
			count++;
		}
	}

	public T dequeue() 
	{
		if(isEmpty())
			throw new IllegalStateException();
		T temp = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		count--;
		return temp;
	}


	public T first() 
	{
		if(isEmpty())
			throw new IllegalStateException();
		else
		{
			T temp = queue[front];
			return temp;
		}
	}

	public int indexOf(T element) 
	{
			for (int i = 0 ; i < count; i++)
			{	
				if (queue[(i + front) % queue.length].equals(element))
					return i;
			}
			return -1;
	}

	public boolean isEmpty() 
	{
		for (int i = 0; i < queue.length; i++) 
		{
			if(queue[i] != null)
				return false;
		}
		return true;
	}


	public boolean isFull() 
	{
		int rear = (count + front) % queue.length;
		if(!(isEmpty()) && (front == rear))
				return true;
		return false;
	}

	public int size() 
	{
		return count;
	}
	
	
	
	
}