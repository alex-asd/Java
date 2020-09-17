package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>
{
   private static final int DEFAULT_CAPACITY = 100;
   private int front;
   private int count;
   private T[] queue;

   public ArrayQueue(int initialCapacity)
   {
      queue = (T[]) new Object[initialCapacity];
      front = 0;
      count = 0;
   }

   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < count; i++)
      {
         int index = (i + front) % queue.length;
         s += queue[index];
         if (i < count -1)
         {
            s += ", ";
         }
      }
      s += "}";
      return s;
   }

   private void expandCapacity()
   {
      T[] tmp = (T[]) new Object[queue.length * 2];
      for (int i = 0; i < count; i++)
      {
         int index = (i + front) % queue.length;
         tmp[i] = queue[index];
      }
      queue = tmp;
      front = 0;
   }

   @Override
   public void enqueue(T element)
   {
      if (count >= queue.length)
      {
         expandCapacity();
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
      return false;
   }
   
   @Override
   public int size()
   {
      return count;
   }

}
