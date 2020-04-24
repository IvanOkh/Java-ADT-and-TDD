package utility;

import java.util.NoSuchElementException;

import exceptions.EmptyQueueException;

/**
 * 
 * Class description: my version of a queue.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyQueue <E> implements QueueADT<E>
{
	private MyDLLNode que;
	
	public MyQueue ()
	{
		que = new MyDLLNode();
	}
	

	/**
	 * Enqueue will place the added item at the last position in the
	 * queue.  This method will not allow <code>null</code> values
	 * to be added to the Queue.
	 * 
	 * @param toAdd the item to be added to the Queue.
	 * @throws NullPointerException raised when a <code>null</code> object
	 * is placed in the Queue.
	 * @Override
	 */
	public void enqueue(E toAdd) throws NullPointerException
	{
		if (toAdd == null)
        {
        	throw new NullPointerException();
        }
		else
		{
			que.add( (E) toAdd);
		}
		
	}

	
	/**
	 * Dequeue will remove the first item that was placed in the Queue.
	 * @return the first item in the Queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 * @Override
	 */
	public E dequeue() throws EmptyQueueException
	{
		if (que.size() == 0)
        {
        	throw new EmptyQueueException();
        }
		
		E firstItem = (E) que.get(0);
		que.remove(0);
		
		return firstItem;
	}

	
	/**
	 * Peek provides a reference to the first item in the queue without
	 * removing from the queue.
	 * 
	 * @return the first item in the queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 * @Override
	 */
	public E peek() throws EmptyQueueException
	{
		if (que.size() == 0)
        {
        	throw new EmptyQueueException();
        }
		
		return (E) que.get(0);
	}

	
	/**
	 * dequeueAll removes all items in the queue.
	 * @Override
	 */
	public void dequeueAll()
	{
		que.clear();		
	}

	
	/**
	 * Returns <code>true</code> when the queue contains no items.
	 * @return <code>true</code> when queue length is zero (0).
	 * @Override
	 */
	public boolean isEmpty()
	{
		boolean empty = que.isEmpty();
		return empty;
	}

	
	/**
	 * Returns an iterator over the elements in this queue in proper sequence.
	 * 
	 * @return an iterator over the elements in this queue in proper sequence.
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
        	if (position < que.size())
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
        		 return (E) que.get(position++);
        	 }
        	 
        	 else 
        	 {
        		 throw new NoSuchElementException();	
        	 }
        }	
		  

	}

	
	/**
	 * Used to compare two Queue ADT's. To be equal two queues must contain
	 * equal items appearing in the same order.
	 * 
	 * @param that the Queue ADT to be compared to this queue.
	 * @return <code>true</code> if the queues are equal.
	 * @Override
	 */
	public boolean equals(QueueADT<E> that)
	{
		E [] array1 = (E[]) que.toArray(); 
		E [] array2 = (E[]) that.toArray(); 
		
		if (que.size() == that.size())
		{
			for(int i = 0; i <que.size(); i++)
			{
				if (array1[i] != array2[i] || !array1[i].equals(array2[i]) )
				{
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 * @Override
	 */
	public Object[] toArray()
	{
		E [] array = (E[]) que.toArray();
		return array;
	}

	
	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence; the runtime type of the returned array is that of the specified
	 * array. Obeys the general contract of the Collection.toArray(Object[])
	 * method.
	 * 
	 * @param toHold
	 *            the array into which the elements of this queue are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this queue.
	 * @throws NullPointerException
	 *          if the specified array is null.
	 * @Override
	 */
	public E[] toArray(E[] holder) throws NullPointerException
	{
		if (holder == null) 
	    {
	    	throw new NullPointerException();
	    }
		
		holder = (E[]) que.toArray();
		return holder;
	}


	/**
	 * (Optional Method) Returns true if the number of items in the queue
	 * equals the length.  This operation is only implement when a fixed length
	 * queue is required.
	 * @return <code>true</code> if queue is at capacity.
	 * @Override
	 */
	public boolean isFull()
	{
		return false;
	}

	
	/**
	 * Returns the length of the current queue as an integer value.
	 * @return the current size to the queue as an integer.
	 * @Override
	 */
	public int size()
	{
		return que.size();
	}

}
