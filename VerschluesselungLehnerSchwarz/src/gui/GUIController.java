package gui;

/**
 * Diese Klasse ist der Controller f�r die GUI. Es wird der ActionListener implementiert, das hei�t,
 * wenn der Benutzer nun auf einen Button in der GUI klickt wird hier geschribeen, was dann passieren
 * soll.
 * 
 * @author Cindy Lehner
 * @author Stephan Schwarz
 * @version 2014-05-17
 */
import lehnerschwarz.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener{

	//Attribute
	private GUI g;
	private KeywordCipher k;
	private ShiftCipher sh;
	private TranspositionCipher t;
	private SubstitutionCipher s;
	
	//Konstruktor
	public GUIController(){
		this.g = new GUI(this);
	}

	/**
	 * �berschreiben der actionPerformed-Methode
	 * @author Cindy Lehner
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//wird ausgef�hrt wenn der Button "Verschluesseln" gedr�ckt wird
		if(e.getActionCommand().equals("verschluesseln")){
			g.textAusgabe.setText(""); //damit nichts im Textfeld drin steht
			//wenn nichts im Eigabefeld drin steht wird eine Fehlermeldung ausgegeben
			if(g.eingabev.getText().equals("")){
				g.textAusgabe.setText("Sie m�ssen einen Text zum Verschl�sseln eingeben");
			}
			else{
				try{
					String buttonName = g.bg.getSelection().getActionCommand(); //welcher Radiobutton gefr�ckt wurde
					switch(buttonName){
					case"radiosubst":
						if(g.eingabes.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen ein Alphabet angeben");
						}
						else{
							try{
								this.s = new SubstitutionCipher(g.eingabes.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabee.setText(s.encrypt(g.eingabev.getText()));
								g.textAusgabe.setText("Ihr geheimes Alphabet wurde ge�ndert");
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte ein g�ltiges Alphabet angeben!"); //Es d�rfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radiotransp":
						if(g.eingabet.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen einen Transpositionslevel angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabet.getText()); //Umwandeln des Strings in eine Zahl
							this.t = new TranspositionCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabee.setText(t.encrypt(g.eingabev.getText())); //Entschl�sselungstextfeld setzen
						}
					break;
					case"radiokey":
						if(g.eingabek.getText().equals("")){ //wenn nichts im Eingabfeld f�r das Keyword steht
							g.textAusgabe.setText("Sie m�ssen ein Keyword angeben");
						}
						else{
							try{
								this.k = new KeywordCipher(g.eingabek.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabee.setText(k.encrypt(g.eingabev.getText())); //Entschl�sselungstextfeld setzen
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte nur Buchstaben im Keyword verwenden!"); //Es d�rfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radioshift":
						if(g.eingabesh.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen einen Verschiebungsgrad angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabesh.getText()); //Umwandeln des Strings in eine Zahl
							this.sh = new ShiftCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabee.setText(sh.encrypt(g.eingabev.getText())); //Entschl�sselungstextfeld setzen
						}
					break;
					}
				}catch(NullPointerException n){
					g.textAusgabe.setText("Sie m�ssen eine Verschl�sselungsmethode w�hlen");
				}
			}

		}
		
		//wird ausgef�hrt wenn der Button "Entschluesseln" gedr�ckt wird
		if(e.getActionCommand().equals("entschluesseln")){
			g.textAusgabe.setText("");
			if(g.eingabee.getText().equals("")){
				g.textAusgabe.setText("Sie m�ssen einen Text zum Entschl�sseln eingeben");
			}
			else{
				try{
					String buttonName = g.bg.getSelection().getActionCommand();
					switch(buttonName){
					case"radiosubst":
						if(g.eingabes.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen ein Alphabet angeben");
						}
						else{
							try{
								this.s = new SubstitutionCipher(g.eingabes.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabev.setText(s.decrypt(g.eingabee.getText()));
								g.textAusgabe.setText("Ihr geheimes Alphabet wurde ge�ndert");
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte ein g�ltiges Alphabet angeben!"); //Es d�rfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radiotransp":
						if(g.eingabet.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen einen Transpositionslevel angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabet.getText()); //Umwandeln des Strings in eine Zahl
							this.t = new TranspositionCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabev.setText(t.decrypt(g.eingabee.getText())); //Entschl�sselungstextfeld setzen
						}
					break;
					case"radiokey":
						if(g.eingabek.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen ein Keyword angeben");
						}
						else{
							try{
								this.k = new KeywordCipher(g.eingabek.getText());
								g.eingabev.setText(k.decrypt(g.eingabee.getText()));
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte nur Buchstaben im Keyword verwenden!");
							}
						}
					break;
					case"radioshift":
						if(g.eingabesh.getText().equals("")){
							g.textAusgabe.setText("Sie m�ssen einen Verschiebungsgrad angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabesh.getText());
							this.sh = new ShiftCipher(zahl);
							g.eingabev.setText(sh.decrypt(g.eingabee.getText()));
						}
					break;
					}
				}catch(NullPointerException n){
					g.textAusgabe.setText("Sie m�ssen eine Verschl�sselungsmethode w�hlen");
				}
			}

		}

		//wird ausgef�hrt wenn der Radiobutton "Geheimes Alphabet" gedr�ckt wird
		if(e.getActionCommand().equals("radiosubst")){
			//Alle nicht ben�tigten Textfelder ausblenden
			g.eingabes.setEnabled(true);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgef�hrt wenn der Radiobutton "Transpositionslevel" gedr�ckt wird
		if(e.getActionCommand().equals("radiotransp")){
			//Alle nicht ben�tigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(true);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgef�hrt wenn der Radiobutton "Keyword" gedr�ckt wird
		if(e.getActionCommand().equals("radiokey")){
			//Alle nicht ben�tigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(true);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgef�hrt wenn der Radiobutton "Verschiebungsgrad" gedr�ckt wird
		if(e.getActionCommand().equals("radioshift")){
			//Alle nicht ben�tigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(true);
		}
	}
}
