package gui;

/**
 * Diese Klasse ist der Controller für die GUI. Es wird der ActionListener implementiert, das heißt,
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
	 * Überschreiben der actionPerformed-Methode
	 * @author Cindy Lehner
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//wird ausgeführt wenn der Button "Verschluesseln" gedrückt wird
		if(e.getActionCommand().equals("verschluesseln")){
			g.textAusgabe.setText(""); //damit nichts im Textfeld drin steht
			//wenn nichts im Eigabefeld drin steht wird eine Fehlermeldung ausgegeben
			if(g.eingabev.getText().equals("")){
				g.textAusgabe.setText("Sie müssen einen Text zum Verschlüsseln eingeben");
			}
			else{
				try{
					String buttonName = g.bg.getSelection().getActionCommand(); //welcher Radiobutton gefrückt wurde
					switch(buttonName){
					case"radiosubst":
						if(g.eingabes.getText().equals("")){
							g.textAusgabe.setText("Sie müssen ein Alphabet angeben");
						}
						else{
							try{
								this.s = new SubstitutionCipher(g.eingabes.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabee.setText(s.encrypt(g.eingabev.getText()));
								g.textAusgabe.setText("Ihr geheimes Alphabet wurde geändert");
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte ein gültiges Alphabet angeben!"); //Es dürfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radiotransp":
						if(g.eingabet.getText().equals("")){
							g.textAusgabe.setText("Sie müssen einen Transpositionslevel angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabet.getText()); //Umwandeln des Strings in eine Zahl
							this.t = new TranspositionCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabee.setText(t.encrypt(g.eingabev.getText())); //Entschlüsselungstextfeld setzen
						}
					break;
					case"radiokey":
						if(g.eingabek.getText().equals("")){ //wenn nichts im Eingabfeld für das Keyword steht
							g.textAusgabe.setText("Sie müssen ein Keyword angeben");
						}
						else{
							try{
								this.k = new KeywordCipher(g.eingabek.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabee.setText(k.encrypt(g.eingabev.getText())); //Entschlüsselungstextfeld setzen
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte nur Buchstaben im Keyword verwenden!"); //Es dürfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radioshift":
						if(g.eingabesh.getText().equals("")){
							g.textAusgabe.setText("Sie müssen einen Verschiebungsgrad angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabesh.getText()); //Umwandeln des Strings in eine Zahl
							this.sh = new ShiftCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabee.setText(sh.encrypt(g.eingabev.getText())); //Entschlüsselungstextfeld setzen
						}
					break;
					}
				}catch(NullPointerException n){
					g.textAusgabe.setText("Sie müssen eine Verschlüsselungsmethode wählen");
				}
			}

		}
		
		//wird ausgeführt wenn der Button "Entschluesseln" gedrückt wird
		if(e.getActionCommand().equals("entschluesseln")){
			g.textAusgabe.setText("");
			if(g.eingabee.getText().equals("")){
				g.textAusgabe.setText("Sie müssen einen Text zum Entschlüsseln eingeben");
			}
			else{
				try{
					String buttonName = g.bg.getSelection().getActionCommand();
					switch(buttonName){
					case"radiosubst":
						if(g.eingabes.getText().equals("")){
							g.textAusgabe.setText("Sie müssen ein Alphabet angeben");
						}
						else{
							try{
								this.s = new SubstitutionCipher(g.eingabes.getText()); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
								g.eingabev.setText(s.decrypt(g.eingabee.getText()));
								g.textAusgabe.setText("Ihr geheimes Alphabet wurde geändert");
							}
							catch(IllegalArgumentException i){
								g.textAusgabe.setText("Bitte ein gültiges Alphabet angeben!"); //Es dürfen keine Sonderzeichen angegeben werden
							}
						}
					break;
					case"radiotransp":
						if(g.eingabet.getText().equals("")){
							g.textAusgabe.setText("Sie müssen einen Transpositionslevel angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabet.getText()); //Umwandeln des Strings in eine Zahl
							this.t = new TranspositionCipher(zahl); //Neues Objekt mit Hilfe des eingegebenen Parameters erzeugen
							g.eingabev.setText(t.decrypt(g.eingabee.getText())); //Entschlüsselungstextfeld setzen
						}
					break;
					case"radiokey":
						if(g.eingabek.getText().equals("")){
							g.textAusgabe.setText("Sie müssen ein Keyword angeben");
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
							g.textAusgabe.setText("Sie müssen einen Verschiebungsgrad angeben");
						}
						else{
							int zahl = Integer.parseInt(g.eingabesh.getText());
							this.sh = new ShiftCipher(zahl);
							g.eingabev.setText(sh.decrypt(g.eingabee.getText()));
						}
					break;
					}
				}catch(NullPointerException n){
					g.textAusgabe.setText("Sie müssen eine Verschlüsselungsmethode wählen");
				}
			}

		}

		//wird ausgeführt wenn der Radiobutton "Geheimes Alphabet" gedrückt wird
		if(e.getActionCommand().equals("radiosubst")){
			//Alle nicht benötigten Textfelder ausblenden
			g.eingabes.setEnabled(true);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgeführt wenn der Radiobutton "Transpositionslevel" gedrückt wird
		if(e.getActionCommand().equals("radiotransp")){
			//Alle nicht benötigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(true);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgeführt wenn der Radiobutton "Keyword" gedrückt wird
		if(e.getActionCommand().equals("radiokey")){
			//Alle nicht benötigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(true);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(false);
		}
		
		//wird ausgeführt wenn der Radiobutton "Verschiebungsgrad" gedrückt wird
		if(e.getActionCommand().equals("radioshift")){
			//Alle nicht benötigten Textfelder ausblenden
			g.eingabes.setEnabled(false);
			g.eingabek.setEnabled(false);
			g.eingabet.setEnabled(false);
			g.eingabesh.setEnabled(true);
		}
	}
}
