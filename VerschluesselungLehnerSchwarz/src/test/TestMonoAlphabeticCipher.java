package test;

import lehnerschwarz.MonoAlphabeticCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen möglichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Cindy Lehner
 * @version 2014-05-17
 */
public class TestMonoAlphabeticCipher {

	/**
	 * Test, anzeigen lassen des secretAlphabets vom Konstruktor MonoAlphabeticCipher, dieser sollte
	 * dem normalen Alphabet entsprechen
	 */
	@Test
	public void test1(){
		MonoAlphabeticCipher m = new MonoAlphabeticCipher();
		if(m.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyzäöüß")){
			System.out.println("MonoAlphabetic Test gelungen!");
		}
	}
}
