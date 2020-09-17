package guided.tour;


public class LinkedQueue<T> implements QueueATD<T>{

	private LinearNode<T> front;
	private LinearNode<T> rear;
	private int count;
	
	public LinkedQueue()
	{
		front = null;
		rear = null;
		count = 0;
	}
	
	@Override
	public void enqueue(T element) {
		if(element == null)
			throw new IllegalArgumentException("No null elements");
		if(count == 0)
		{
			front = new LinearNode<T>(element, front);
			rear = front;
		}
		else
		{
			LinearNode<T> prev = getNode(count); // rear !!!!!!!!!!!!!!!!!!!!!!
			rear = new LinearNode<T>(element, prev.getNext());
			prev.setNext(rear);
		}
		count++;
	}

	@Override
	public T dequeue() {
		if(isEmpty())
			throw new IllegalStateException("The q is empty");
		T ret = front.getElement();
		front = front.getNext();
		count--;
		return ret;
	}

	@Override
	public T first() {
		if(isEmpty())
			throw new IllegalStateException("there is nothing there");
		else
			return front.getElement();
	}

	@Override
	public int indexOf(T element) 
	{
		if(element == null)
			throw new IllegalArgumentException("No nulls pall");
		LinearNode<T> current = front;
		for (int i = 0; i < count; i++) 
		{
			if(element.equals(current.getElement()))
				return i;
		}
		current = current.getNext();
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int size() {
		return count;
	}
	
	private LinearNode<T> getNode(int index)
	   {
	      LinearNode<T> current = front;
	      for (int i = 1; i < index; i++)
	      {
	         current = current.getNext();
	      }
	      return current;
	   }

	public String toString()
	{
	     LinearNode<T> current = front;
	      String s = "{";
	      for (int i= 0 ; i < count; i++)
	      {
	         s += current.getElement();
	         if (i < count - 1)
	         {
	            s += ", ";
	         }
	         current = current.getNext();
	      }
	      s += "}";
	       return s;
	}
	
}
