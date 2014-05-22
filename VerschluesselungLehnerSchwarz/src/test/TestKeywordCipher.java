package test;

import lehnerschwarz.KeywordCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen möglichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Stephan Schwarz
 * @version 2014-05-22
 */
public class TestKeywordCipher {

	/**
	 * Test, ändern des secretAlphabet durch den Konstruktor von SubstitutionCipher
	 */
	@Test
	public void test1(){
		String a = "regenschirm";
		KeywordCipher k = new KeywordCipher(a);
		k.encrypt("Cindy");
		if(k.decrypt("gmjny").equals("cindy")){
			System.out.println("KeywordCipher erfolgreich getestet!");
		}
	}
}
