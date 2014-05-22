package test;

import lehnerschwarz.ShiftCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen möglichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Cindy Lehner
 * @version 2014-05-22
 */
public class TestShiftCipher {

	/**
	 * Test, ändern des secretAlphabet durch den Konstruktor von SubstitutionCipher
	 */
	@Test
	public void test1(){
		int zahl = 5;
		ShiftCipher s = new ShiftCipher(zahl);
		s.encrypt("Stephan");
		if(s.decrypt("xyjumfs").equals("stephan")){
			System.out.println("ShiftCipher erfolgreich getestet!");
		}
	}
}
