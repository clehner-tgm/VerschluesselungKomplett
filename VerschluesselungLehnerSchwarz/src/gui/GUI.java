package gui;

/**
 * In dieser Klasse werden die einzelnen Teil der GUI erzeugt und so angeordnet, dass der Benutzer
 * dieses Programm leicht ausführen kann
 * (Wir haben diese Elemente gemeinsam angelegt)
 * 
 * @author Cindy Lehner
 * @author Stephan Schwarz
 * @version 2014-05-17
 */
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

	//Attribute
	private static GUIController c;
	public JButton verschluesseln, entschluesseln;
	public JTextArea textAusgabe;
	public JTextField eingabev, eingabee, eingabes, eingabet, eingabek, eingabesh;
	private JRadioButton radios, radiot, radiok, radiosh;
	public ButtonGroup bg, bgsort;
	public JScrollPane sp;
	
	//Konstruktor
	public GUI(GUIController c){
		this.c=c;

		//Buttons
		this.verschluesseln= new JButton("Verschlüsseln");
		this.entschluesseln= new JButton("Entschlüsseln");
		
		//Textfeld für die Ausgabe
		this.textAusgabe = new JTextArea();
		this.textAusgabe.setEnabled(false);
		this.sp = new JScrollPane(this.textAusgabe);
		
		//Textfelder
		this.eingabev = new JTextField();
		this.eingabee = new JTextField();
		this.eingabes = new JTextField();
		this.eingabet = new JTextField();
		this.eingabek = new JTextField();
		this.eingabesh = new JTextField();
				
		//Radiobuttons
		radios = new JRadioButton("Geheimes Alphabet:");
		radiot = new JRadioButton("Transpositionslevel:");
		radiok = new JRadioButton("Keyword:");
		radiosh = new JRadioButton("Verschiebungsgrad:");
		bg = new ButtonGroup();
		bg.add(radios);
		bg.add(radiot);
		bg.add(radiok);
		bg.add(radiosh);
		
		//Dass die Textfelder neben den Buttons nicht editierbar sind
		eingabes.setEnabled(false);
		eingabek.setEnabled(false);
		eingabet.setEnabled(false);
		eingabesh.setEnabled(false);
		
		//ActionListener
		this.verschluesseln.addActionListener(this.c);
		this.entschluesseln.addActionListener(this.c);
		this.radios.addActionListener(this.c);
		this.radiot.addActionListener(this.c);
		this.radiok.addActionListener(this.c);
		this.radiosh.addActionListener(this.c);
		
		//ActionCommands
		this.verschluesseln.setActionCommand("verschluesseln");
		this.entschluesseln.setActionCommand("entschluesseln");
		this.radios.setActionCommand("radiosubst");
		this.radiot.setActionCommand("radiotransp");
		this.radiok.setActionCommand("radiokey");
		this.radiosh.setActionCommand("radioshift");
		
		//Panels
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.add(this.eingabev);
		p1.add(this.verschluesseln);
		p1.add(this.eingabee);
		p1.add(this.entschluesseln);
		
		JPanel pradio = new JPanel();
		pradio.setLayout(new GridLayout(4,2));
		pradio.add(radios);
		pradio.add(eingabes);
		pradio.add(radiot);
		pradio.add(eingabet);
		pradio.add(radiok);
		pradio.add(eingabek);
		pradio.add(radiosh);
		pradio.add(eingabesh);

		JPanel pTA = new JPanel();
		pTA.setLayout(new GridLayout(1,1));
		pTA.add(this.textAusgabe);
		
		//Grundeinstellungen
		setLayout(new GridLayout(3,1));
		add(p1);
		add(pradio);
		add(pTA);
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
