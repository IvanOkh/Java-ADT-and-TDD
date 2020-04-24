package testArrayList;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.MyArrayList;


/**
 * Class description: set of tests for MyArrayList.
 *
 * @author Ivan Okhrimovich
 *
 */
public class MyArrayListTests
{
	MyArrayList one;
	MyArrayList two;
	static MyArrayList zero;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		zero = new MyArrayList(0);
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		zero = null;
	}

	
	@Before
	public void setUp() throws Exception
	{
		one = new MyArrayList();
		two = new MyArrayList(2);
	}

	
	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}

	
	@Test
	public void testSizePositive()
	{				
		one.add(1);
		one.add(-2);
		one.add(10);
		
		int actualSize = one.size();
	
		assertEquals("testSizePositive() method did not return new size correctly", 3, actualSize);		
	}
	
	
	@Test
	public void testSizeNull()
	{		
		int actual = one.size();
			
		assertEquals("testSizeNull() method did not return new size correctly", 0, actual);		
	}
	

	@Test
	public void testClear()
	{
		int newSize = 50;
		int expected = 0;
		int actual;
		
		one = new MyArrayList(newSize);
		
		one.clear();
		
		actual = one.size();
		
		assertEquals("testClear() method did clear array correctly", expected, actual);	
		
	}

	
	@Test
	public void testAddIntObject()
	{
		int q = 1;
		int w = 2;
		int e = 3;
		
		one.add(q);
		one.add(w);
		one.add(e);
		
		int quantity = one.size();

		assertEquals("testAddIntObject() method did not add object correctly", 3, quantity);	
	}

	
	@Test
	public void testAddObjectAtZeroIndex()
	{		
		String o = "bla";	
		
		one.add(0, o);
		
		String expected = (String) one.get(0);
		
		assertEquals("testAddObjectAtZeroIndex() method did not add object correctly", expected, o);	
		
	}
	
	
	@Test
	public void testAddObjectAtPositiveIndex()
	{		
		String o = "a";
		String b = "t";

		one.add(0, o);
		one.add(1, b);
		
		String expected = (String) one.get(1);
		String expected2 = (String) one.get(0);
		
		assertEquals("testAddObjectAtPositiveIndex() method did not add object correctly", expected, b);	
		assertEquals("testAddObjectAtPositiveIndex() method did not add object correctly", expected2, o);	
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
		assertEquals("testAddAll() method did not add arrays correctly", expected, 5);	
	}

	
	@Test
	public void testGet()
	{
		String o = "a";
		String b = "t";
		
		one.add(o);
		one.add(b);
		
		String expected = (String) one.get(0);
		String expected2 = (String) one.get(1);
		
		assertEquals("testGet() method did not return object correctly", expected, o);
		assertEquals("testGet() method did not return object correctly", expected2, b);
	}

	
	@Test
	public void testRemoveInt()
	{
		int o = 5;
		int u = 10;
		one=new MyArrayList(2);
		one.add(o);
		one.add(u);
		
		int expected = (int) one.remove(1);

		assertEquals("testRemoveInt() method did not return integer correctly", expected, u);
	}

	
	@Test
	public void testRemoveObject()
	{
		String o = "a";
		String u = "b";
		one=new MyArrayList(2);
		one.add(o);
		one.add(u);

		String expected = (String) one.remove(1);
		String expected2 =  (String) one.remove(0);
		
		assertEquals("testRemoveObject() method did not return object correctly", expected, u);
		assertEquals("testRemoveObject() method did not return object correctly", expected2, o);
	}

	
	@Test
	public void testSet()
	{
		String o = "a";
		String u = "b";
		String r = "c";
		String expected;
		
		one.add(o);
		one.add(u);
		one.set(1, r);
		
		expected = (String) one.get(1);
		
		assertEquals("testSet() method did not set object correctly", expected, r);
	}

	
	@Test
	public void testIsEmpty()
	{
		String o = "bla";
		boolean expected = false;
		
		one.add(o);
		one.remove(o);
		expected = one.isEmpty();
				
		assertEquals("testIsEmpty() method did not return boolean correctly", expected, true );
	}

	
	@Test
	public void testContains()
	{
		String o = "a";
		String u = "b";
		String r = "c";
		String k = null;
		
		one.add(o);
		one.add(u);
		one.add(r);

		boolean expected = one.contains("a");
		boolean expected2 = one.contains("b");
		boolean expected3 = one.contains("c");

		assertEquals("testContains() method did not return boolean correctly", expected, true );
		assertEquals("testContains() method did not return boolean correctly", expected2, true );
		assertEquals("testContains() method did not return boolean correctly", expected3, true );

	}

	
	@Test
	public void testToArray()
	{
		String o = "a";
		String u = "c";
		String r = "b";
		String[] holder = new String [10];

		one.add(o);
		one.add(u);
		one.add(r);

		holder = (String[]) one.toArray(holder);
		String actual = holder[0];
		String actual2 = holder[1];
		String actual3 = holder[2];
		String actualNull = holder [3];

		assertEquals("testToArray() method did not return array correctly", o, actual);
		assertEquals("testToArray() method did not return array correctly", u, actual2);
		assertEquals("testToArray() method did not return array correctly", r, actual3);
		assertEquals("testToArray() method did not return array correctly", null , actualNull);
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

		
		assertEquals("testToArrayVoid() method did not return array correctly", o, actual);
		assertEquals("testToArrayVoid() method did not return array correctly", u, actual2);
		assertEquals("testToArrayVoid() method did not return array correctly", r, actual3);

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
