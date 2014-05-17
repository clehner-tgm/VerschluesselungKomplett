package lehnerschwarz;

/**
 * Diese Klasse erbt von MonoAlphabeticCipher und setzt das geheime Alphabet mit Hilfe von einem
 * Verschiebungschiffre
 * 
 * @author Cindy Lehner
 * @version 2014-05-14
 */
public class ShiftCipher extends MonoAlphabeticCipher {
	
	//Konstruktor
	public ShiftCipher(int value){
		super();
		setShiftAmount(value); //setzen wie weit das Alphabet verschoben wird	
	}

	
	/**
	 * Diese Methode verschiebt nach angegbenem Wert das Alphabet und setzt so ein neues Geheimalphabet
	 * 
	 * @param shiftvalue  um wieviele Zeichen das Alphabet verschoben werden soll
	 */
	public void setShiftAmount(int shiftvalue){
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß"; //setzen des Alphabets
		String alphabetNeu="";
		for(int i=0;i<alphabet.length();i++){ //wird solange ausgeführt, solange das Alphabet ist
			if(i+shiftvalue>=alphabet.length()){ //wenn die Verschiebung größer als die Länge ist
				alphabetNeu += alphabet.charAt(i+shiftvalue-alphabet.length()); //Den Verschiebungsindex hinzuzählen und die Länge des Alphabets abziehen
			}
			else{
				alphabetNeu += alphabet.charAt(i+shiftvalue); //Den Verschiebungsindex zum Buchstaben hinzuzählen
			}
		}
		super.setSecretAlphabet(alphabetNeu); //Setzen des neuen Alphabets
	}
}
