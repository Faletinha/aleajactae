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


public class SetImplTest extends SetTest {

	@BeforeTest
	@Override
	public void beforeTest () {
		set = new SetImplementation <String> ();
		util = new SetUtil ();
		toRemoveAdd = "R";
		other = "333";
	}


	@Test
	@Override
	public void testAddAll () {
		assertTrue ( util.testSetaddAll ( set , true ) );
	}


	@Test
	@Override
	public void testSize () {
		Set <String> s1 = new SetImplementation <String> ();
		Set <String> s2 = new SetImplementation <String> ();
		assertEquals ( s1.size () , s2.size () );
		s1.add ( toRemoveAdd );
		assertNotEquals ( s1.size () , s2.size () );
	}

}
