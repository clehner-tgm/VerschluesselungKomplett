package test;

import lehnerschwarz.TranspositionCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen möglichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Cindy Lehner
 * @version 2014-05-22
 */
public class TestTranspositionCipher {

	/**
	 * Test, ändern des secretAlphabet durch den Konstruktor von SubstitutionCipher
	 */
	@Test
	public void test1(){
		int zahl = 4;
		TranspositionCipher t = new TranspositionCipher(zahl);
		t.encrypt("Sew");
		if(t.decrypt("kqä").equals("sew")){
			System.out.println("TranspositionCipher erfolgreich getestet!");
		}
	}
}