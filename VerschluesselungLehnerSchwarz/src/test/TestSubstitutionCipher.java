package test;

import lehnerschwarz.SubstitutionCipher;
import org.junit.Test;

/**
 * Testen der verschiedenen Methoden und Konstruktoren. Man versucht einen m�glichst hohen
 * Abdeckungsgrad zu erreichen
 * 
 * @author Cindy Lehner
 * @version 2014-05-17
 */
public class TestSubstitutionCipher {

	/**
	 * Test, �ndern des secretAlphabet durch den Konstruktor von SubstitutionCipher
	 */
	@Test
	public void test1(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.getSecretAlphabet().equals(a)){
			System.out.println("setAlphabet Test1 gelungen");
		}
	}
	
	/**
	 * Test, �ndern des secretAlphabet so, dass eine Exception geworfen wird, da zu wenige Buchstaben
	 * im neuen Alphabet sind
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test2(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		s.setSecretAlphabet("����zyxwva");
	}
	
	/**
	 * Test, �ndern des secretAlphabet so, dass eine Exception geworfen wird, da doppelte Buchstaben
	 * im neuen Alphabet sind
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		s.setSecretAlphabet("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	/**
	 * Test, eingeben eines Strings und diesen verschl�sseln lassen
	 */
	@Test
	public void test4(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.encrypt("cindy").equals("�vq�f")){
			System.out.println("Encrypt Test gelungen!");
		}
	}
	
	/**
	 * Test, eingeben eines Strings und diesen entschl�sseln lassen
	 */
	@Test
	public void test5(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		if(s.decrypt("�vq�f").equals("cindy")){
			System.out.println("Decrypt Test gelungen!");
		}
	}
	
	/**
	 * Test, einen String zuerst verschl�sseln und dann entschl�sseln lassen
	 */
	@Test
	public void test6(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		String texte = s.encrypt("CINDY");
		String textd = s.decrypt(texte);
		if(textd.equals("cindy")){
			System.out.println("Encrypt und Decrypt Test gelungen!");
		}
	}
	
	/**
	 * Test, einen String zuerst verschl�sseln und dann entschl�sseln lassen. Zahlen oder sonstige
	 * Zeichen sollen so bleiben wie sie sind.
	 */
	@Test
	public void test7(){
		String a = "����zyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher s = new SubstitutionCipher(a);
		String texte = s.encrypt("CI7DY");
		String textd = s.decrypt(texte);
		if(textd.equals("ci7dy")){
			System.out.println("Encrypt und Decrypt Test2 gelungen!");
		}
	}
}
