/**
 * 
 */
package testDLL;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utility.MyDLLNode;

/**
 * Class description: set of tests for MyDLLNode.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyDLLTests
{
	MyDLLNode one;
	MyDLLNode two;
	static MyDLLNode zero;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new MyDLLNode();
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}


	@Before
	public void setUp() throws Exception
	{
		one = new MyDLLNode();
		two = new MyDLLNode();
	}


	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}


	@Test
	public void testSize()
	{
		String t = "y", b = "i", e = "o";
		
		one.add(t);
		one.add(b);
		one.add(e);

		int actual = one.size();
			
		assertEquals("testSize() method did not return new size correctly", 3, actual);				
	}


	@Test
	public void testClear()
	{
		String t = "y", b = "i", e = "o", w = "q";
		
		one.add(t);
		one.add(b);
		one.add(1, w);

		one.clear();
		int actual = one.size();
	
		assertEquals("testClear() method did not return size correctly", 0, actual);
	}


	@Test
	public void testAddAtIndex()
	{
		String t = "y", b = "i", e = "o", w = "q";
		
		one.add(t);
		one.add(b);
		one.add(e);
		one.add(1, w);

		String actual = (String) one.get(0);
		String actual2 = (String) one.get(1);
		String actual3 = (String) one.get(2);
		String actual4 = (String) one.get(3);
			
		assertEquals("testAddAtIndex() method did add an element correctly", t, actual);
		assertEquals("testAddAtIndex() method did add an element correctly", w, actual2);	
		assertEquals("testAddAtIndex() method did add an element correctly", b, actual3);	
		assertEquals("testAddAtIndex() method did add an element correctly", e, actual4);	
	}
	
	
	@Test
	public void testAddAtZero()
	{
		one.add(15);
		int actual = (int) one.get(0);
		
		assertEquals("testAddAtZero() method did add an element correctly", 15, actual);
	}
	

	@Test
	public void testAddAll()
	{
		one.add(5);
		one.add(10);
		one.add(15);
		two.add(20);
		two.add(25);
		one.addAll(two);

		int expected = one.size();
		int expected2 = (int) one.get(0);
		int expected3 =  (int) one.get(4);
		
		assertEquals("testAddAll() method did not add DLLs correctly", expected, 5);
		assertEquals("testAddAll() method did not add DLLs correctly", expected2, 5);
		assertEquals("testAddAll() method did not add DLLs correctly", expected3, 25);
	}


	@Test
	public void testGet()
	{
		String t = "y", b = "i", e = "o";
		
		one.add(t);
		one.add(b);
		one.add(e);

		String actual = (String) one.get(0);
		String actual2 = (String) one.get(1);
		String actual3 = (String) one.get(2);
		
		assertEquals("testGet() method did not return elements correctly", t, actual);
		assertEquals("testGet() method did not return elements correctly", b, actual2);	
		assertEquals("testGet() method did not return elements correctly", e, actual3);	
	}


	@Test
	public void testRemove()
	{
		one.add(5);
		one.add(10);
		one.add(15);
		one.add(20);
		one.add(25);

		int exp = (int) one.remove(4);
		int exp2 = (int) one.remove(2);
		int exp3 = (int) one.remove(0);
		int expected = one.size();
		
		assertEquals("testRemove() method did delete element correctly", exp, 25);
		assertEquals("testRemove() method did delete element correctly", exp2, 15);
		assertEquals("testRemove() method did delete element correctly", exp3, 5);
		assertEquals("testRemove() method did delete element correctly", expected, 2);
	}
	
	
	@Test
	public void testRemoveObj()
	{
		one.add("a");
		one.add("b");
		one.add("c");
		one.add("d");
		one.add("e");

		String exp = (String) one.remove("e");
		String exp2 = (String) one.remove("c");
		String exp3 = (String) one.remove("a");

		int expected = one.size();
	
		assertEquals("testRemoveObj() method did delete element correctly", exp, "e");
		assertEquals("testRemoveObj() method did delete element correctly", exp2, "c");
		assertEquals("testRemoveObj() method did delete element correctly", exp3, "a");
		assertEquals("testRemoveObj() method did delete element correctly", expected, 2);
	}


	@Test
	public void testSet()
	{
		one.add("a");
		one.add("b");
		one.add("c");
		
		one.set(2, "t");
		
		String exp = (String) one.get(0);
		String exp2 = (String) one.get(1);
		String exp3 = (String) one.get(2);

		int expected = one.size();
			
		assertEquals("testSet() method did bot set element correctly", exp, "a");
		assertEquals("testSet() method did bot set element correctly", exp2, "b");
		assertEquals("testSet() method did bot set element correctly", exp3, "t");
		assertEquals("testSet() method did bot set element correctly", expected, 3);
	}


	@Test
	public void testIsEmpty()
	{
		boolean expected = one.isEmpty();
		two.add("f");
		boolean expected2 = two.isEmpty();
		
		assertEquals("testIsEmpty() method did not return boolean correctly", expected, true);
		assertEquals("testIsEmpty() method did not return boolean correctly", expected2, false);
	}


	@Test
	public void testContains()
	{
		one.add("a");
		one.add("b");
		one.add("c");
		boolean expected = one.contains("b");
		boolean expected2 = one.contains("u");
		
		assertEquals("testContains() method did not return boolean correctly", expected, true);
		assertEquals("testContains() method did not return boolean correctly", expected2, false);
	}


	@Test
	public void testToArray()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		Object [] holder = new Object [10];
		one.add(o);
		one.add(u);
		one.add(r);

		holder = one.toArray(holder);
		
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArray() method did not return array correctly", o, actual);
		assertEquals("testToArray() method did not return array correctly", u, actual2);
		assertEquals("testToArray() method did not return array correctly", r, actual3);
	}


	@Test
	public void testToArrayVoid()
	{
		String o = "a";
		String u = "c";
		String r = "b";

		one.add(o);
		one.add(u);
		one.add(r);

		Object [] holder =  one.toArray();
		
		String actual = (String) holder[0];
		String actual2 = (String) holder[1];
		String actual3 = (String) holder[2];

		assertEquals("testToArray() method did not return array correctly", o, actual);
		assertEquals("testToArray() method did not return array correctly", u, actual2);
		assertEquals("testToArray() method did not return array correctly", r, actual3);
	}


	@Test
	public void testIterator()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		
		one.add(o);
		one.add(u);
		one.add(r);
		
		utility.Iterator<String> foo = one.iterator();

		String actual = foo.next();
		String actual2 = foo.next();
		String actual3 = foo.next();

		assertEquals("testIterator() method did not return object correctly", o, actual);
		assertEquals("testIterator() method did not return object correctly", u, actual2);
		assertEquals("testIterator() method did not return object correctly", r, actual3);
	}

}
