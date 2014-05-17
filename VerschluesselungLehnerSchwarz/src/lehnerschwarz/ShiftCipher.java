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
		String alphabet = "abcdefghijklmnopqrstuvwxyz����"; //setzen des Alphabets
		String alphabetNeu="";
		for(int i=0;i<alphabet.length();i++){ //wird solange ausgef�hrt, solange das Alphabet ist
			if(i+shiftvalue>=alphabet.length()){ //wenn die Verschiebung gr��er als die L�nge ist
				alphabetNeu += alphabet.charAt(i+shiftvalue-alphabet.length()); //Den Verschiebungsindex hinzuz�hlen und die L�nge des Alphabets abziehen
			}
			else{
				alphabetNeu += alphabet.charAt(i+shiftvalue); //Den Verschiebungsindex zum Buchstaben hinzuz�hlen
			}
		}
		super.setSecretAlphabet(alphabetNeu); //Setzen des neuen Alphabets
	}
}
