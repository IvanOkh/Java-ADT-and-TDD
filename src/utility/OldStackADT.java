package utility;

import java.io.Serializable;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as data structure 
 * that maintains data in a last-in-first-out manner. The implementors of 
 * this interface will be required to add all the functionality.
 * </p>
 * 
 * @param <E> The type of elements this stack holds.
 *
 * @author Ivan Okhrimovich
 */
public interface OldStackADT <E> extends Serializable
{
	/**
	 * Adds one element to the top of this stack.
	 * 
	 * @param toPush
	 * 			The element to be added.
	 */
	public void push (E toPush);
	
	
	/**
	 * Removes and returns the top element from this stack.
	 * 
	 * @return The object at the top of this stack.
	 * 
	 * @throws EmptyStackException - 
	 * 			If this stack is empty.		
	 */
	public E pop();
	
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 *
	 * @return The object at the top of this stack.
	 * 
	 * @throws EmptyStackException - 
	 * 			If this stack is empty.	
	 */
	public E peek();
	
	
	/**
	 * Returns the number of elements in this stack.
	 *
	 * @return The number of elements in this stack.
	 */
	public int size ();
	
	
	/**
	 * Returns <code>true</code> if this stack contains no elements.
	 * 
	 * @return <code>true</code> if this stack contains no elements.
	 */
	public boolean isEmpty();
	

	/**
	 * Removes all of the elements from this stack. The stack will be empty after this call returns.
	 * 
	 */
	public void clear();
	
	
	/**
	 * Returns true if this stack contains the specified element. 
	 * 
	 * @param item
	 * 			The element whose presence in this stack is to be tested.
	 * 
	 * @return <code>true</code> if this stack contains the specified element.
	 *
	 */
	public boolean contains(E item);
	
	
	/**
	 * Returns a position where a specified element is on this stack. 
	 * If the <code>item</code> occurs as an item on this stack, this method returns 
	 * the distance from the top of the stack of the occurrence nearest the 
	 * top of the stack. The top item on the stack is considered to be 
	 * at position 1.
	 * 
	 * @param item
	 * 			The element to be searched.
	 * 
	 * @return Position from the top of the stack where the the element is located.
	 * 			The return value -1 indicates that specified element is not on the stack.
	 */
	public int search(E item);
	
	
	/**
	 * Compares the specified stack with this stack for equality. 
	 * Returns <code>true</code> if and only if the specified stack is also a stack, 
	 * both stacks have the same size, and all corresponding pairs of 
	 * elements in the two stacks are equal. In other words, two stacks 
	 * are defined to be equal if they contain the same elements in the same order.
	 * 
	 * @param item
	 * 			The stack to be compared for equality with this stack.
	 * 
	 * @return <code>true</code> if the specified stack is equal to this stack.
	 */
	public boolean equals(OldStackADT <E> item);
	
	
	/**
	 * Returns an array containing all of the elements in this stack in proper
	 * sequence. The top of the stack corresponds to the first element of the array.
	 * 
	 * @return An array containing all of the elements in this stack in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	
	/**
	 * Returns an iterator over the elements in this stack, in descending sequence.
	 * 
	 * @return An iterator over the elements in this stack, in top to bottom sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();	
	
}
