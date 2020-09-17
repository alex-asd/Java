package utility.collection;

public class BoundedArrayQueue<T> implements QueueADT<T>
{
   private int front;
   private int count;
   private T[] queue;

   public BoundedArrayQueue(int maxCapacity)
   {
      queue = (T[]) new Object[maxCapacity];
      front = 0;
      count = 0;
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < count; i++)
      {
         int index = (i + front) % queue.length;
         s += queue[index];
         if (i < count - 1)
         {
            s += ", ";
         }
      }
      s += "}";
      return s;
   }

   @Override
   public void enqueue(T element)
   {
      if (count >= queue.length)
      {
         throw new IllegalStateException("Queue is full");
      }
      int rear = (count + front) % queue.length;
      queue[rear] = element;
      count++;
   }

   @Override
   public T dequeue()
   {
      T tmp = first();
      queue[front] = null; // clean up
      front = (front + 1) % queue.length;
      count--;
      return tmp;
   }

   @Override
   public T first()
   {
      if (isEmpty())
      {
         throw new IllegalStateException("Queue is empty");
      }
      return queue[front];
   }

   @Override
   public int indexOf(T element)
   {
      if (element == null)
      {
         for (int i = 0; i < count; i++)
         {
            int index = (i + front) % queue.length;
            if (element == (queue[index]))
            {
               return i;
            }
         }
      }
      else
      {
         for (int i = 0; i < count; i++)
         {
            int index = (i + front) % queue.length;
            if (element.equals(queue[index]))
            {
               return i;
            }
         }
      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public boolean isFull()
   {
      return count >= queue.length;
   }
   
   @Override
   public int size()
   {
      return count;
   }

}
