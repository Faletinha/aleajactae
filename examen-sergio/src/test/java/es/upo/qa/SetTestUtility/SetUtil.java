package es.upo.qa.SetTestUtility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import es.upo.cal.exam.jul.SetImplementation;


public class SetUtil {

	static final String [] availableStrings = { "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" };


	public String getRandomString () {
		Random dice = new Random ();

		int n = dice.nextInt ( availableStrings.length-1 );
		return availableStrings [n];
	}
	
	public void aca() {
		
	}


	public void mockSet ( Set <String> set , String [] otherStrings ) {
		for ( String s : otherStrings != null ? otherStrings : availableStrings ) {
			testSetAdd ( set , s );
		}
	}


	public boolean testSetAdd ( Set <String> s , String toadd ) {
		s.add ( toadd );
		return s.size () > 0 && s.contains ( toadd ) && !s.isEmpty ();
	}


	public boolean testSetRemove ( Set <String> s , String toremove ) {
		if ( s.contains ( toremove ) ) {
			s.remove ( toremove );
			return !s.contains ( toremove );
		}
		else {
			return false;
		}
	}


	public boolean testSetRemoveAll ( Set <String> s , boolean withInit ) {
		if ( withInit ) {
			mockSet ( s , null );
		}
		Set <String> aux = s;
		s.removeAll ( aux );
		return s.isEmpty () && s.size () == 0;
	}


	public boolean testSetaddAll ( Set <String> s , boolean setimpl ) {
		Set <String> aux = setimpl ? new SetImplementation <String> () : new HashSet <String> ();
		mockSet ( aux , null );
		s.addAll ( aux );
		if ( s.size () < aux.size () ) {
			return false;
		}
		else {
			Iterator <String> it = aux.iterator ();
			while ( it.hasNext () ) {
				if ( !s.contains ( it.next () ) ) {
					return false;
				}
			}
			return true;
		}
	}
}
