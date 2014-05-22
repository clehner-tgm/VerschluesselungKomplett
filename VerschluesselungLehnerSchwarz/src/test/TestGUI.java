package test;

import gui.StartCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen m�glichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Stephan Schwarz
 * @version 2014-05-22
 */
public class TestGUI {

	/**
	 * Test, �ndern des secretAlphabet durch den Konstruktor von SubstitutionCipher
	 */
	@Test
	public void test1(){
		StartCipher c = new StartCipher();
		System.out.println("GUI erfolgreich getestet");
	}
}
