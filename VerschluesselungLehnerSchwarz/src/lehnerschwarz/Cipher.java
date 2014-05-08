package lehnerschwarz;

/**
 * Das Interface mit den Methodendeklarationen, die zum ver- und entschl�sseln dienen.
 * 
 * @author Cindy Lehner
 * @author Stephan Schwarz
 * @version 2014-05-08
 */

public interface Cipher {

	/**
	 * Methodendeklaration, die einen �bergebenen String verschl�sselt
	 * 
	 * @param text  der �bergebene normale Stringwert
	 * @return  der verschl�sselte Wert
	 */
	public String encrypt(String text);
	
	/**
	 * Methodendeklaration, die einen �bergebenen String entschl�sselt
	 * 
	 * @param text  der �bergebene verschl�sselte Stringwert
	 * @return  der entschl�sselte Wert
	 */
	public String decrypt(String text);
	
}
