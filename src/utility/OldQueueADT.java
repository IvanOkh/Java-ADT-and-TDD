/**
 * 
 */
package utility;

import java.io.Serializable;

/**
 * <p>
 * The <code>QueueADT</code> interface is designed to be used as data structure 
 * that maintains data in a first-in-first-out manner. The implementors of 
 * this interface will be required to add all the functionality.
 * </p>
 * 
 * @param <E> The type of elements this queue holds.
 *
 * @author Ivan Okhrimovich
 */
public interface OldQueueADT <E> extends Serializable
{
	/**
	 * Inserts the specified element into this queue if it is possible 
	 * to do so immediately without violating capacity restrictions. 
	 *  
	 * @throws ClassCastException - 
	 * 			if the class of the specified element prevents it from being added to this queue.
	 * @throws NullPointerException - 
	 *		   	if the specified element is <code>null</code> and this queue does not permit <code>null</code> elements.
	 */
	public void enqueue (E item);
	

	/**
	 * Retrieves and removes the head of this queue. 
	 * 
	 * @return The head of this queue.
	 * 
	 * @throws NoSuchElementException - 
	 * 			if this queue is empty.
	 */
	public E dequeue ();
	
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns <code>null</code> if this queue is empty.
	 *
	 * @return The head of this queue, or <code>null</code> if this queue is empty.
	 * 
	 * @throws EmptyqueueException - 
	 * 			If this queue is empty.	
	 */
	public E peek();

	
	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return The number of elements in this queue.
	 */
	public int size ();
	
	
	/**
	 * Returns <code>true</code> if this queue contains no elements.
	 * 
	 * @return <code>true</code> if this queue contains no elements.
	 */
	public boolean isEmpty();
	
	
	/**
	 * Removes all of the elements from this queue. The queue will be empty after this call returns.
	 * 
	 */
	public void clear();
	
	
	/**
	 * Compares the specified Object with this queue for equality. 
	 * Returns true if and only if the specified Object is also a queue, 
	 * both queues have the same size, and all corresponding pairs of 
	 * elements in the two queues are equal. In other words, two queues 
	 * are defined to be equal if they contain the same elements in the same order.
	 * 
	 * @param item
	 * 			The Object to be compared for equality with this queue.
	 * 
	 * @return <code>true</code> if the specified Object is equal to this queue.
	 */
	public boolean equals(OldQueueADT <E> item);
	
	
	/**
	 * Returns an array containing all of the elements in this queue in proper
	 * sequence.
	 * 
	 * @return An array containing all of the elements in this queue in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	
	/**
	 * Returns an iterator over the elements in this queue, in front to back sequence.
	 * 
	 * @return An iterator over the elements in this queue, in front to back sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();
	
}
