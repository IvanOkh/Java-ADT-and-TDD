package utility;

import java.util.NoSuchElementException;


/**
 * 
 * Class description: my version of an array list.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyArrayList <E> implements ListADT <E>
{	
	private static final int defaultSize = 10;
	private  E [] array;
	private int currentSize;
	
	public MyArrayList ()
	{
		array = (E[]) new Object [defaultSize];
		currentSize = 0;
	}
	
	public MyArrayList (int newSize) 
	{
		array = (E[]) new Object [newSize];
		currentSize = 0;
	}

	
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 * @Override
	 */
	public int size()
	{
		return currentSize;
	}

	
	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 * @Override
	 */	
	public void clear()
	{		
        for (int i = 0; i < array.length; i++)
        {
            array[i] = null;
        }

        currentSize = 0;			
	}

	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index
	 * 			The index at which the specified element is to be inserted.
	 * 			The element is inserted before the existing element at [index],
	 * 			or at the end if index is equal to the 
	 * 			size (<code>size()</code>).
	 * @param toAdd
	 * 			The element to be inserted.
	 * @return <code>true</code> if the element is added successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index > size()</code>).
	 * @Override
	 */
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException
	{
		
		if (index < 0 || index > currentSize) 
		{
			throw new IndexOutOfBoundsException();
	    }

	    if (toAdd == null) 
	    {
	    	throw new NullPointerException();
	    }
	    
	    else if  (index  >=0 && index < array.length) 
	    {
		    for (int i = currentSize; i > index; i--) 
		    {	        								
		    	array[i] = array [i-1];
		    }
	
		    array[index] = (E) toAdd;
		    currentSize++;
		    
		    return true;
	    }
	    
	    return false;	  
	}

	
	/**
	 * Appends the specified element to the end of this list.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be added to this list. In particular, some
	 * implementations will refuse to add <code>null</code> elements.
	 * List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * @param toAdd
	 * 			Element to be appended to this list.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the list
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index > size()</code>).
	 * @Override
	 */
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException
	{		
	    if (toAdd == null) 
	    {
	    	throw new NullPointerException();
	    }
	    
	    if (currentSize == array.length)
	    {
	    	throw new IndexOutOfBoundsException();
	    }
	    
	    else if (currentSize < array.length)
	    {
	    	array[currentSize] = (E) toAdd;
	    	currentSize++;
	    	return true;
	    }
	    
	    return false;
	}

	
	/**
	 * Appends all of the elements in the specified 
	 * <code>java.utilCollection</code> to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's <code>Iterator</code>. The behaviour of this operation
	 * is unspecified if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the
	 * specified collection is this list, and it's nonempty.)
	 * 
	 * @param toAdd
	 * 			The new sub list to be added.
	 * @return true
	 * 			If the operation is successful.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @Override
	 */
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException
	{
		
		MyArrayList b = (MyArrayList) toAdd;
		int t = b.size();
		int cap = currentSize + t;
		
		if (cap > array.length)
		{
			throw new NullPointerException();
		}
		else if (cap <= array.length)
		{
			for (int i=0; i < t; i++)
			{
				E a = (E) b.get(i);
				array[currentSize] = a;
				currentSize++;
			}
			return true;
		}
    
		return false;
	}

	
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * 			Index of element to return.
	 * @return The element at the specified position in this list.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 * @Override
	 */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= currentSize) 
	    {
	    	throw new IndexOutOfBoundsException();
	    }
		if (index >= 0 && index < currentSize) 
		{
			return array[index];
		}
		
		return null;
	}

	
	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 * 
	 * @param index
	 * 			The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 * @Override
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= currentSize) 
	    {
	    	throw new IndexOutOfBoundsException();
	    }

		if (index >= 0 && index < currentSize) 
		{
			E t = array[index];
			
			for (int i = index; i < currentSize-1; i++)
			{
				array[i] = array[i+1];				
			}
			
			currentSize--;		
			return t;
		}
		
		return null;
	}

	
	/**
	 * Removes the first occurrence in this list of the specified element. If
	 * this list does not contain the element, it is unchanged. More formally,
	 * removes the element with the lowest index <code>i</code> such that
	 * <code>o.equals(get(i))</code> (if such an element exists).
	 * 
	 * @param toRemove
	 * 			The element to be removed from this list.
	 * @return The element which is being removed, or null if the list does
	 * 			not contain the element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @Override
	 */
	public E remove(E toRemove) throws NullPointerException
	{
		if (toRemove  == null) 
	    {
	    	throw new NullPointerException();
	    }

		for (int i = 0; i <array.length; i++)
		{
			if (array[i] == toRemove || array[i].equals(toRemove) )
			{
				for (int o = i; o < currentSize-1; o++)
				{
					array[o] = array[o+1];				
				}
				
				currentSize--;
				return toRemove;
			}
			
		}
		
		return null;
	}

	
	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index
	 * 			The index of the element to replace.
	 * @param toChange
	 * 			Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the 
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 * @Override
	 */
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
	{		
		if (toChange  == null) 
	    {
	    	throw new NullPointerException();
	    }
		if (index < 0 || index >=  currentSize) 
	    {
	    	throw new IndexOutOfBoundsException();
	    }
		
		else if (index >= 0)
		{
			E holder = array[index];
			
			array[index] = toChange;				
								
			return holder;
		}
		
	return null;
	}
	
	
	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 * @Override
	 */
	public boolean isEmpty()
	{
		if (currentSize == 0)
		{
			return true;
		}
		return false;
	}

	
	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one 
	 * element <code>e</code> such that <code>toFind.equals(e)</code>.
	 * 
	 * @param toFind
	 * 			The element whose presence in this list is to be tested.
	 * @return <code>true</code> if this list contains the specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 * @Override
	 */
	public boolean contains(E toFind) throws NullPointerException
	{
		if (toFind  == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		for (int i = 0; i < currentSize; i++)
		{
			if(array[i] == toFind || array[i].equals(toFind))	
			{
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param toHold
	 *			The array into which the elements of this list are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 * @Override
	 */
	public E[] toArray(E[] toHold) throws NullPointerException
	{
		if (toHold  == null) 
	    {
	    	throw new NullPointerException();	
	    }
		
		int itSize = toHold.length;
		
		if (itSize < currentSize) 
		{
			toHold = (E[]) new Object [currentSize];

			for( int i = 0; i <currentSize; i++)
			{
				toHold[i] = array[i];
			}
			return toHold;			
		}		
		else if (itSize > currentSize || itSize == currentSize)
		{
			for( int i = 0; i <currentSize; i++)
			{
				toHold[i] = array[i];
			}
			return toHold;	
		}
		
		return null;		
	}

	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the 
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this list in proper
	 * 			sequence.
	 * @Override
	 */
	public Object[] toArray()
	{		
		E [] container = (E[]) new Object [currentSize];
		
		for( int i = 0; i <currentSize; i++)
		{
			container[i] = array[i];
		}
		return container;	
	}

	
	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 * @Override
	 */
	public Iterator <E> iterator()
	{
		return new Iterator<E>();
	}
	
	private class Iterator<E> implements utility.Iterator<E>
    {
		int position = 0;
		
		/**
		 * Returns <code>true</code> if the iteration has more elements. 
		 * (In other words, returns <code>true</code> if <code>next()</code> 
		 * would return an element rather than throwing an exception.)
		 * 
		 * @return <code>true</code> if the iterator has more elements.
		 * @Override
		 */
        public boolean hasNext()
        {
        	if (position < currentSize)
        	{
        		return true;
        	}
        	else
        	{
        		return false;
        	}
        }

        
        /**
    	 * Returns the next element in the iteration.
    	 * 
    	 * @return The next element in the iteration.
    	 * @throws NoSuchElementException
    	 * 			If the iteration has no more elements.
    	 * @Override
    	 */
        public E next() throws NoSuchElementException
        {
        	 if (this.hasNext())
        	 {
                 return (E) array[position++];
        	 }
        	 
        	 else 
        	 {
        		 throw new NoSuchElementException();	
        	 }
        }
    }
}
