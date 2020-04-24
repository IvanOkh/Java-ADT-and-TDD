package testQueue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.EmptyQueueException;
import utility.MyQueue;


/**
 * Class description: set of tests for MyQueue.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyQueueTests
{
	MyQueue one;
	MyQueue two;
	static MyQueue zero;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new MyQueue();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}

	@Before
	public void setUp() throws Exception
	{
		one = new MyQueue();
		two = new MyQueue();
	}

	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}

	@Test
	public void testEnqueue() throws EmptyQueueException
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.enqueue(q);
		one.enqueue(w);
		one.enqueue(e);
		
		int top = (int) one.peek();
		
		assertEquals("testEnqueue() method did not add object correctly", q, top);	
	}

	@Test
	public void testDequeue() throws EmptyQueueException
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.enqueue(q);
		one.enqueue(w);
		one.enqueue(e);
		
		int expected = (int) one.dequeue();	
		int top = (int) one.peek();
		
		assertEquals("testDequeue() method did not return object correctly", w, top);	
		assertEquals("testDequeue() method did not return object correctly", q, expected);	
	}

	@Test
	public void testPeek() throws EmptyQueueException
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.enqueue(q);
		one.enqueue(w);
		one.enqueue(e);
		
		int top1 = (int) one.peek();
		one.dequeue();	
		int top2 = (int) one.peek();
		one.dequeue();	
		int top3 = (int) one.peek();
		one.dequeue();	

		
		assertEquals("testPeak() method did not return object correctly", q, top1);	
		assertEquals("testPeak() method did not return object correctly", w, top2);	
		assertEquals("testPeak() method did not return object correctly", e, top3);	
	}

	@Test
	public void testDequeueAll() throws EmptyQueueException
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.enqueue(q);
		one.enqueue(w);
		one.enqueue(e);
		one.dequeueAll();
		one.enqueue(15);
		int top = (int) one.peek();
		int expected = (int) one.dequeue();	
		
		assertEquals("testDequeueAll() method did not return object correctly", 15, top);	
		assertEquals("testDequeueAll() method did not return object correctly", 15, expected);	
	}

	
	@Test
	public void testIsEmpty()
	{
		int q = 1;
		int w = 2;
		
		one.enqueue(q);
		one.enqueue(w);
		boolean expected = one.isEmpty();
		one.dequeueAll();
		boolean expected2 = one.isEmpty();
		
		assertEquals("testIsEmpty() method did not return boolean correctly", false, expected);	
		assertEquals("testIsEmpty() method did not return boolean correctly", true, expected2);	
	}

	@Test
	public void testIterator()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		
		one.enqueue(o);
		one.enqueue(u);
		one.enqueue(r);
		
		utility.Iterator<String> foo = one.iterator();

		String actual = foo.next();
		String actual2 = foo.next();
		String actual3 = foo.next();

		assertEquals("testIterator() method did not return object correctly", o, actual);
		assertEquals("testIterator() method did not return object correctly", u, actual2);
		assertEquals("testIterator() method did not return object correctly", r, actual3);
	}

	@Test
	public void testEqualsQueueADT()
	{		
		one.enqueue("a");
		one.enqueue("b");
		one.enqueue("c");
		
		two.enqueue("a");
		two.enqueue("b");
		two.enqueue("c");
		
		boolean expected = one.equals(two);
	
		assertEquals("testEqualsQueueADT() method did not return boolean correctly", true, expected);	
	}

	@Test
	public void testToArray()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		Object [] holder = new Object [10];
		one.enqueue(o);
		one.enqueue(u);
		one.enqueue(r);

		holder = one.toArray(holder);
		
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArray() method did not return array correctly", o, actual);
		assertEquals("testToArray() method did not return array correctly", u, actual2);
		assertEquals("testToArray() method did not return array correctly", r, actual3);
	}

	@Test
	public void testToArrayWithArgument()
	{
		String o = "a";
		String u = "c";
		String r = "b";

		one.enqueue(o);
		one.enqueue(u);
		one.enqueue(r);

		Object [] holder =  one.toArray();
		
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArrayWithArgument() method did not return array correctly", o, actual);
		assertEquals("testToArrayWithArgument() method did not return array correctly", u, actual2);
		assertEquals("testToArrayWithArgument() method did not return array correctly", r, actual3);
	}

	@Test
	public void testIsFull()
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.enqueue(q);
		one.enqueue(w);
		one.enqueue(e);
		
		boolean notFull = one.isFull();
		
		assertEquals("testIsFull() method did not return boolean correctly", false, notFull);	
	}

	@Test
	public void testSize()
	{
		String t = "y", b = "i", e = "o";
		
		one.enqueue(t);
		one.enqueue(b);
		one.enqueue(e);

		int actual = one.size();
			
		assertEquals("testSize() method did not return new size correctly", 3, actual);	
	}

}
