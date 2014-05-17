package lehnerschwarz;

/**
 * Diese Klasse erbt von MonoAlphabeticCipher und setzt das geheime Alphabet mit Hilfe von einem
 * Keyword und erg�nzt dann das restliche Alphabet, wobei keine doppelten Buchstaben vorkommen
 * d�rfen
 * 
 * @author Cindy Lehner
 * @version 2014-05-14
 */
public class KeywordCipher extends MonoAlphabeticCipher{

	//Konstruktor
	public KeywordCipher(String keyword){
		super();
		setKeyword(keyword); //auf das gew�nschte Keyword setzen
	}
	
	public void setKeyword(String keyword){
		String alphabet ="abcdefghijklmnopqrstuvwxyz����"; //Alphabet speichern
		String alphabetNeu="";
		keyword.toLowerCase();
		for(int i=0;i<keyword.length();i++){ //Wird ausgef�hrt, solange wie das Keyword ist
			char buchstabe=keyword.charAt(i); //Der Buchstabe an der i-ten Position wird gespeichert
			if(alphabetNeu.indexOf(buchstabe)==-1){ //Wenn der Buchstabe nicht vorhanden ist
				alphabetNeu += buchstabe; //wird er im Text hinzugef�gt
			}
		}
		for(int i=0;i<alphabet.length();i++){ //Wird ausgef�hrt, solange wie das Alphabet ist
			char buchstabe=alphabet.charAt(i); //Der Buchstabe an der i-ten Position wird gespeichert
			if(alphabetNeu.indexOf(buchstabe)==-1){ //Wenn der Buchstabe nicht vorhanden ist
				alphabetNeu += buchstabe; //wird er im Text hinzugef�gt
			}
		}
		System.out.println(alphabetNeu+"");
		super.setSecretAlphabet(alphabetNeu); //Setzen des neuen Geheimalphabets
	}
}
