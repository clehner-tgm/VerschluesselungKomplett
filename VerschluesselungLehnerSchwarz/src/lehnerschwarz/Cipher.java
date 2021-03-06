package lehnerschwarz;

/**
 * Das Interface mit den Methodendeklarationen, die zum ver- und entschlüsseln dienen.
 * 
 * @author Cindy Lehner
 * @author Stephan Schwarz
 * @version 2014-05-08
 */

public interface Cipher {

	/**
	 * Methodendeklaration, die einen übergebenen String verschlüsselt
	 * 
	 * @param text  der übergebene normale Stringwert
	 * @return  der verschlüsselte Wert
	 */
	public String encrypt(String text);
	
	/**
	 * Methodendeklaration, die einen übergebenen String entschlüsselt
	 * 
	 * @param text  der übergebene verschlüsselte Stringwert
	 * @return  der entschlüsselte Wert
	 */
	public String decrypt(String text);
	
}
