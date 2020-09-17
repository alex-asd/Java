package utility.collection;

/**
 * ListADT defines the interface to a list collection - the abstract data type
 * List. Elements are referenced by contiguous numeric indices. The list should
 * allow duplicate elements and could allow <code>null</code> elements.
 *
 * @author Steffen Vissing Andersen
 * @version 1.3, 9/2/2017
 * @version (Version 1.0, 8/12/2008 by Lewis and Chase)
 * @param <T>
 *           the data type of elements in the collection
 */
public interface ListADT<T>
{
   /**
    * Inserts the specified element at the specified index.
    * 
    * @param index
    *           the index into the array to which the element is to be inserted.
    *           Legal values from 0 to the list size, both inclusive.
    * @param element
    *           the element to be inserted into the list
    * @exception IllegalStateException
    *               if the list is full and trying to insert at the end
    * @exception IndexOutOfBoundsException
    *               if the index is out of bounds
    * @exception IllegalArgumentException
    *               if there is a mismatch in the input, e.g. if a null element
    *               is not allowed
    */
   public void add(int index, T element);

   /**
    * Adds the specified element to the rear end of this list.
    * 
    * @param element
    *           the element to be added to the rear end of the list
    * @exception IllegalStateException
    *               if the list is full
    * @exception IllegalArgumentException
    *               if there is a mismatch in the input, e.g. if a
    *               <code>null</code> element is not allowed
    */
   public void add(T element);

   /**
    * Sets the element at the specified index
    * 
    * @param index
    *           the index into the array to which the element is to be set.
    *           Legal values from 0 to the list size-1, both inclusive.
    * @param element
    *           the element to be set into the list at <code>index</code>
    * @exception IndexOutOfBoundsException
    *               if the index is out of bounds
    * @exception IllegalArgumentException
    *               if there is a mismatch in the input, e.g. if a
    *               <code>null</code> element is not allowed
    */
   public void set(int index, T element);

   /**
    * Returns a reference to the element at the specified index.
    * 
    * @param index
    *           the index to which the reference is to be retrieved from. Legal
    *           values from 0 to the list size-1, both inclusive.
    * @exception IndexOutOfBoundsException
    *               if the index is out of bounds
    * @return a reference to the element at the specified index
    */
   public T get(int index);

   /**
    * Removes and returns the element at the specified index.
    * 
    * @param index
    *           the index of the element to be removed from the list. Legal
    *           values from 0 to list size-1, both inclusive.
    * @exception IndexOutOfBoundsException
    *               if the index is out of bounds
    * @return the removed element
    */
   public T remove(int index);

   /**
    * Removes and returns the specified element from this list. 
    * 
    * @param element
    *           the element to be removed from the list
    * @exception IllegalStateException
    *               if the element is not in the list
    * @return the removed element
    */
   public T remove(T element);

   /**
    * Returns the index of the specified element.
    * 
    * @param element
    *           the element for the index is to be retrieved
    * @return the integer index for this element
    */
   public int indexOf(T element);

   /**
    * Returns <code>true</code> if this list contains the specified target element.
    * 
    * @param element
    *           the element that is being sought in the list
    * @return <code>true</code> if this list contains the elements. Otherwise, <code>false</code>
    */
   public boolean contains(T element);

   /**
    * Returns <code>true</code> if this list contains no elements.
    * 
    * @return <code>true</code> if this list contains no elements. Otherwise, <code>false</code>
    */
   public boolean isEmpty();

   /**
    * Returns <code>true</code> if this list is full.
    * 
    * @return boolean whether or not this list is full
    */
   public boolean isFull();

   /**
    * Returns the number of elements in this list
    * 
    * @return the integer representation of number of elements in this list
    */
   public int size();
}
