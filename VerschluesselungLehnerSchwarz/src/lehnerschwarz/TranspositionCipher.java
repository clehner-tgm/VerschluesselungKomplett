package lehnerschwarz;

/**
 * Diese Klasse implementiert das Interface und �berschreibt die Methoden encrypt und decrypt.
 * Die Verschl�sselung erfolgt mittels Transpositionschiffre,
 * das hei�t das Ganze ist eine Art Gartenzaun-Verschl�sselung
 * 
 * @author Stephan Schwarz
 * @version 2014-05-14
 */
public class TranspositionCipher implements Cipher{

	//Attribute
	private int tpl;
	
	//Konstruktor
	public TranspositionCipher(int transpositionLevel){
		setTranspositionLevel(transpositionLevel);
	}
	
	public void setTranspositionLevel(int level) throws IllegalArgumentException{
		if(level>1&&level<30){ //Falls der Level zu hoch oder zu niedrig ist
			this.tpl=level;
		}
		else{
			throw new IllegalArgumentException("Bitte g�ltigen Wert eingeben!"); //Fehlermeldung
		}
	}

	 /**
	  * Diese Methode verschl�sselt einen eingegeben Stringwert mit Hilfe von einem angegebenen
	  * secret Alphabet
	  * 
	  * @param text  der zu verschl�sselnde Text
	  * @return  der verschl�sselte Text
	  */
	@Override
	public String encrypt(String text) {
		char b2;
		String textKlein = text.toLowerCase();
		String gerade="abcdefghijklmnopqrstuvwxyz����";
		String ungerade="";
		String textTranspo="";
		for(int i=0;i<this.tpl;i++){ //L�uft �ber den Transpositionslevel
			for(int j=i;j<gerade.length();j+=this.tpl){ //L�uft �ber das Alphabet
				ungerade += gerade.charAt(j);
			}
		}
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i); //Speichern des Buchstaben
			int stelle = gerade.indexOf(buchstabe); //Speichern der Stelle des Buchstaben
			if(stelle==-1){ //Wenn es ein Sonderzeichen ist, wird es nicht ver�ndert
				b2 = textKlein.charAt(i);
			} else{
				b2 = ungerade.charAt(stelle); //Es wird geschaut welcher Buchstabe an der Stelle im Secret-Alphabet ist
			}
			textTranspo+=b2; //Hinzuf�gen zum Text
		}
		return textTranspo; //Zur�ckgeben des neuen Textes
	}

	/**
	 * Diese Methode entschl�sselt einen eingegebenen Stringwert mit Hilfe von einem angegebenen
	 * secret Alphabet
	 * 
	 * @param text  der zu entschl�sselnde Text
	 * @return  der entschl�sselte Text
	 */
	@Override
	public String decrypt(String text) {
		char b2;
		String textKlein = text.toLowerCase();
		String gerade="abcdefghijklmnopqrstuvwxyz����";
		String ungerade="";
		String textTranspo="";
		for(int i=0;i<this.tpl;i++){ //L�uft �ber den Transpositionslevel
			for(int j=i;j<gerade.length();j+=this.tpl){ //L�uft �ber das Alphabet
				ungerade += gerade.charAt(j);
			}
		}
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i);
			int stelle = ungerade.indexOf(buchstabe);
			if(stelle==-1){ //Gilt nur f�r Sonderzeichen
				b2 = textKlein.charAt(i);
			} else{
				b2 = gerade.charAt(stelle); //Decryptiert
			}
			textTranspo+=b2; //Hinzuf�gen zum Text
		}
		return textTranspo; //Zur�ckgeben des neuen Textes
	}
	
}
