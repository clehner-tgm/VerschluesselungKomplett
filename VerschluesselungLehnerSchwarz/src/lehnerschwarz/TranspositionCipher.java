package lehnerschwarz;

/**
 * Diese Klasse implementiert das Interface und überschreibt die Methoden encrypt und decrypt.
 * Die Verschlüsselung erfolgt mittels Transpositionschiffre,
 * das heißt das Ganze ist eine Art Gartenzaun-Verschlüsselung
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
			throw new IllegalArgumentException("Bitte gültigen Wert eingeben!"); //Fehlermeldung
		}
	}

	 /**
	  * Diese Methode verschlüsselt einen eingegeben Stringwert mit Hilfe von einem angegebenen
	  * secret Alphabet
	  * 
	  * @param text  der zu verschlüsselnde Text
	  * @return  der verschlüsselte Text
	  */
	@Override
	public String encrypt(String text) {
		char b2;
		String textKlein = text.toLowerCase();
		String gerade="abcdefghijklmnopqrstuvwxyzäöüß";
		String ungerade="";
		String textTranspo="";
		for(int i=0;i<this.tpl;i++){ //Läuft über den Transpositionslevel
			for(int j=i;j<gerade.length();j+=this.tpl){ //Läuft über das Alphabet
				ungerade += gerade.charAt(j);
			}
		}
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i); //Speichern des Buchstaben
			int stelle = gerade.indexOf(buchstabe); //Speichern der Stelle des Buchstaben
			if(stelle==-1){ //Wenn es ein Sonderzeichen ist, wird es nicht verändert
				b2 = textKlein.charAt(i);
			} else{
				b2 = ungerade.charAt(stelle); //Es wird geschaut welcher Buchstabe an der Stelle im Secret-Alphabet ist
			}
			textTranspo+=b2; //Hinzufügen zum Text
		}
		return textTranspo; //Zurückgeben des neuen Textes
	}

	/**
	 * Diese Methode entschlüsselt einen eingegebenen Stringwert mit Hilfe von einem angegebenen
	 * secret Alphabet
	 * 
	 * @param text  der zu entschlüsselnde Text
	 * @return  der entschlüsselte Text
	 */
	@Override
	public String decrypt(String text) {
		char b2;
		String textKlein = text.toLowerCase();
		String gerade="abcdefghijklmnopqrstuvwxyzäöüß";
		String ungerade="";
		String textTranspo="";
		for(int i=0;i<this.tpl;i++){ //Läuft über den Transpositionslevel
			for(int j=i;j<gerade.length();j+=this.tpl){ //Läuft über das Alphabet
				ungerade += gerade.charAt(j);
			}
		}
		for(int i=0;i<textKlein.length();i++){
			char buchstabe = textKlein.charAt(i);
			int stelle = ungerade.indexOf(buchstabe);
			if(stelle==-1){ //Gilt nur für Sonderzeichen
				b2 = textKlein.charAt(i);
			} else{
				b2 = gerade.charAt(stelle); //Decryptiert
			}
			textTranspo+=b2; //Hinzufügen zum Text
		}
		return textTranspo; //Zurückgeben des neuen Textes
	}
	
}
