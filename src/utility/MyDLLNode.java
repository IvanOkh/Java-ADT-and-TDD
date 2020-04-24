package utility;

import java.util.NoSuchElementException;

/**
 * 
 * Class description: my version of a doubly linked list.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyDLLNode <E> implements ListADT <E>
{
	private DLLNode head;
	private DLLNode tail;
	private int size;
	
	public MyDLLNode ()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	private class DLLNode
	{
		   E element;
		   DLLNode next;
		   DLLNode prev;
		   
		   public DLLNode (E data)
		   {
		      this.element = data;
		      next = null;
		      prev = null;
		   }
	}
	
	
	/**
	 * The size method will return the current element count contained 
	 * in the DLL.
	 * 
	 * @return The current element count.
	 * @Override
	 */
	public int size()
	{
		return size;
	}

	
	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 * 	@Override
	 */
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
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
        if (index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        
        if (toAdd == null)
        {
        	throw new NullPointerException();
        }
        
        DLLNode n = new DLLNode(toAdd);
        
		int counter = 0;
		
		if (counter == index)
		{
			n.next = head;
			head.prev = n;
			head = n;					
		}
		
		DLLNode node = head;
		DLLNode prevNode = null;
		
		if (counter != index) 
		{
			while(counter != index)
			{
				prevNode = node;
				node = node.next;
				
				counter++;
			}
			
			n.prev=node.prev;
			prevNode.next = n;
			node.prev = n;
	        n.next = node;
	    			
		}
       	
        size ++;
        
        return true;   
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
	      
		DLLNode n = new DLLNode(toAdd);
		
        if(size==0)
        {
            head = n;
            tail = n;
        }
        
        else
        {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        
        size++;
        
        return true;
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
		
		if (toAdd == null)
		{
			throw new NullPointerException();
		}
				
	    for(int i = 0; i < toAdd.size(); i++)
	    {	    	
	        DLLNode n = new DLLNode(null);
	        n.element =  toAdd.get(i);
	        this.add(n.element);	        
	    }
	    	
		return true;
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
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		DLLNode node = head;
		
		int counter = 0;
		
		if (counter == index)
		{
			return (E) node.element;
		}
		
		if (counter != index) 
		{
			while(counter != index)
			{
				node = node.next;
				counter++;
			}
		}

		
		return (E) node.element;

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
		DLLNode n = new DLLNode(null);
		DLLNode b = new DLLNode(null);
		DLLNode r = new DLLNode(null);
		
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		r.element = get(index);
		
		if (index == 0 && size == 1)
		{
			head = null;
			tail = null;
			size --;
			return r.element;
		}
		
		else if (index == 0)
		{
			head = head.next;
			head.prev = null;		
			size--;
			return r.element;
		}
		
		else if (index == size-1)
		{
			n = tail.prev;
			tail = n;
			size --;
			return r.element;
		}
							
		else
		{
			n = getNodeAt(index -1);
			b = getNodeAt(index +1);
			n.next = b;
			b.prev = n;

			size--;
			return r.element;
		}
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
		if (toRemove == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		int index = indexOf(toRemove);

		DLLNode r = new DLLNode(null);
		
		r.element = remove(index);
		
		return r.element;
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
		if (toChange == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		DLLNode r = new DLLNode(null);
		r  = getNodeAt(index);
		r.element = toChange;
		
		return r.element;
	}

	
	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 * @Override
	 */
	public boolean isEmpty()
	{
		if(head == null)
		{			
			return true;	
		}
		
		else
		{
			return false;
		}
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
		if (toFind == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		int index = indexOf(toFind);
		
		if (index != -1)
		{
			return true;
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
		if (toHold == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		toHold = (E[]) new Object [size];
		
		for( int i = 0; i <size; i++)
		{
			toHold[i] = getNodeAt(i).element;
		}
		
		return toHold;
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
		E [] array = (E[]) new Object [size];
		
		for( int i = 0; i <size; i++)
		{
			array[i] = getNodeAt(i).element;
		}
		
		return array;		
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
	public Iterator<E> iterator()
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
        	if (position < size)
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
        		 return (E) getNodeAt(position++).element;
        	 }
        	 
        	 else 
        	 {
        		 throw new NoSuchElementException();	
        	 }
        }
		
	}
	
	
	/**
	 * This method gets a node at certain index.
	 * 
	 * @param index
	 * 			The index of the element to find.
	 * @return node at index
	 * @throws IndexOutOfBoundsException
	 */
	private DLLNode getNodeAt(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		DLLNode node = head;
		int counter = 0;
		if (counter != index) 
		{
			while(counter != index)
			{
				node = node.next;
				counter++;
			}
		}
		
		if (counter == index)
		{
			return node;
		}
		
		return node;
	}
	
	
	/**
	 * This method gets the first index of element containing data.
	 * 
	 * @param toFind 
	 * 				element to search by.
	 * @return index of given parameter
	 */
	private int indexOf(E toFind)
	{
		int index=0;
		DLLNode givenNode = new DLLNode(toFind);
		DLLNode Node = head;

			for (int x=0; x < size; x++)
			{		
				if (Node.element.equals(givenNode.element) || Node.element ==givenNode.element)
				{
					return index;
				}
				Node = Node.next;
				index++;
			}
									
			return -1;	 
	}

}
