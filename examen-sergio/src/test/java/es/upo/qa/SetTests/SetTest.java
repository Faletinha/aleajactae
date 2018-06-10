package es.upo.qa.SetTests;

import org.testng.annotations.Test;
import es.upo.cal.exam.jul.SetImplementation;
import es.upo.qa.SetTestUtility.SetUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class SetTest {

	Set <String> set = null;
	SetUtil util = null;
	String toRemoveAdd , other = null;


	@AfterClass
	public void afterClass () {
	}


	@BeforeTest
	public void beforeTest () {
		set = new HashSet <String> ();
		util = new SetUtil ();
		toRemoveAdd = "R";
		other = "333";
	}


	@AfterTest
	public void afterTest () {
		set = new HashSet <String> ();
	}


	@Test
	public void testContains () {
		assertFalse ( set.contains ( other ) );
	}


	@Test
	public void testAdd () {
		assertTrue ( util.testSetAdd ( set , toRemoveAdd ) );
	}


	@Test
	public void testRemove () {
		assertTrue ( util.testSetRemove ( set , toRemoveAdd ) );
	}


	@Test
	public void testRemoveFail () {
		assertFalse ( util.testSetRemove ( set , toRemoveAdd ) );
	}


	@Test
	public void testRemoveAll () {
		assertTrue ( util.testSetRemoveAll ( set , true ) );
	}


	@Test
	public void testAddAll () {
		assertTrue ( util.testSetaddAll ( set , true ) );
	}


	@Test
	public void testSize () {
		Set <String> s1 = new HashSet <String> ();
		Set <String> s2 = new HashSet <String> ();
		assertEquals ( s1.size () , s2.size () );
		s1.add ( toRemoveAdd );
		assertNotEquals ( s1.size () , s2.size () );
	}

}
