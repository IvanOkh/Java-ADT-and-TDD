package exceptions;

/**
 * 
 * Class description: This exception is thrown when some operations are performed on an empty queue.
 *
 * @author Ivan Okhrimovich
 *
 */
public class EmptyQueueException extends Exception
{
	private static final long serialVersionUID = -4216359310331486111L;

	public EmptyQueueException() 
	{
		super("Queue is currently empty");
	}

	public EmptyQueueException(String message) 
	{
		super(message);		   
	}
}
