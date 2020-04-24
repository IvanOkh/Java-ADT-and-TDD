package testStack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utility.MyStack;


/**
 * Class description: set of tests for MyStack.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyStackTests
{
	MyStack one;
	MyStack two;
	static MyStack zero;
	
	static int q = 1;
	static int w = 2;
	static int e = 3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new MyStack();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}

	@Before
	public void setUp() throws Exception
	{
		one = new MyStack();
		two = new MyStack();
	}

	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}

	@Test
	public void testPush()
	{		
		one.push(q);
		one.push(w);
		one.push(e);
		
		int quantity = one.size();

		assertEquals("testPush() method did not add object correctly", 3, quantity);	
	}

	@Test
	public void testPop()
	{
		one.push(q);
		one.push(w);
		one.pop();
		one.pop();
		
		int quantity = one.size();

		assertEquals("testPop() method did not pop object correctly", 0, quantity);	
	}

	@Test
	public void testPeek()
	{
		one.push(q);
		one.push(w);
		
		int peek = (int) one.peek();

		assertEquals("testPeek() method did not return object correctly", 2, peek);	
	}

	@Test
	public void testClear()
	{
		one.push(q);
		one.push(w);
		int size = one.size();
		
		one.clear();
		int size2 = one.size();
		
		assertEquals("testClear() method did not clear stack correctly", 2, size);
		assertEquals("testClear() method did not clear stack correctly", 0, size2);	
	}

	@Test
	public void testIsEmpty()
	{
		boolean zeroSize = one.isEmpty();
		one.push(q);
		one.push(w);	
		boolean doubleSize = one.isEmpty();
		one.clear();
		boolean afterSize = one.isEmpty();
		
		assertEquals("testIsEmpty() method did not return boolean correctly", true, zeroSize);
		assertEquals("testIsEmpty() method did not return boolean correctly", false, doubleSize);
		assertEquals("testIsEmpty() method did not return boolean correctly", true, afterSize);
	}

	@Test
	public void testToArray()
	{
		String o = "a";
		String u = "c";
		String r = "b";

		one.push(o);
		one.push(u);
		one.push(r);
		
		Object[] holder = one.toArray();

		System.out.println(holder.length);
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArray() method did not return array correctly", r, actual);
		assertEquals("testToArray() method did not return array correctly", u, actual2);
		assertEquals("testToArray() method did not return array correctly", o, actual3);
	}

	@Test
	public void testToArrayEArray()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		Object[] holder = new Object [10];

		one.push(o);
		one.push(u);
		one.push(r);

		holder = one.toArray(holder);
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArrayEArray() method did not return array correctly", r, actual);
		assertEquals("testToArrayEArray() method did not return array correctly", u, actual2);
		assertEquals("testToArrayEArray() method did not return array correctly", o, actual3);
	}

	@Test
	public void testContains()
	{
		String o = "a";
		String u = "c";
		String r = "b";

		one.push(o);
		one.push(u);
		one.push(r);

		boolean val = one.contains(o);
		boolean val2 = one.contains(u);
		boolean val3 = one.contains(5);

		assertEquals("testToArrayEArray() method did not return array correctly", false, val3);
		assertEquals("testToArrayEArray() method did not return array correctly", true, val2);
		assertEquals("testToArrayEArray() method did not return array correctly", true, val);
	}

	@Test
	public void testSearch()
	{
		String o = "a";
		String u = "c";
		String r = "b";

		one.push(o);
		one.push(u);
		one.push(r);

		int index = one.search("M");
		int index2 = one.search("c");
		int index3 = one.search("b");

		assertEquals("testToArrayEArray() method did not return array correctly", -1, index);
		assertEquals("testToArrayEArray() method did not return array correctly", 1, index2);
		assertEquals("testToArrayEArray() method did not return array correctly", 0, index3);
	}

	@Test
	public void testIterator()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		
		one.push(o);
		one.push(u);
		one.push(r);
		
		utility.Iterator<String> foo = one.iterator();

		String actual = foo.next();
		String actual2 = foo.next();
		String actual3 = foo.next();

		assertEquals("testIterator() method did not return object correctly", r, actual);
		assertEquals("testIterator() method did not return object correctly", u, actual2);
		assertEquals("testIterator() method did not return object correctly", o, actual3);
	}

	@Test
	public void testEqualsStackADTOfE()
	{
		one.push("a");
		one.push("b");
		one.push("c");
		
		two.push("a");
		two.push("b");
		two.push("c");
		
		boolean expected = one.equals(two);
	
		assertEquals("testEqualsStackADTOfE() method did not return boolean correctly", true, expected);	
	}

	@Test
	public void testSize()
	{
		one.push("a");
		one.push("b");
		one.push("c");
		
		int expected = one.size();
		
		assertEquals("testSize() method did not return size correctly", 3, expected);	
	}

}
