package it.unibs.pgmarnaldoesame;

import java.util.HashMap;

import it.unibs.fp.mylib.InputDati;
import it.unibs.myexception.IllegalMovementException;

public class Partita {
	private static final int VALORE_MOVIMENTO = 1;


	private static final String MSG_MOVIMENTO = "Inserisci la direzione in cui vuoi muoverti [W, A, S, D]: ";


	private static final String TASTI_MOVIMENTO = "WASD";
	
	
	private Personaggio personaggio;
	private static HashMap<Integer, String> legendaSimboli = new HashMap<>();
	private static int [][] mappa;
	
	public Partita(Personaggio personaggio) {
		this.personaggio = personaggio;
	}
	
	public static Partita inizializzaPartita() {
		Personaggio personaggio = Personaggio.creaPersonaggio();
		
		creaLegendaSimboli();
		
		mappa = LettoreMappeXML.leggiMappa(legendaSimboli);
		
		return new Partita(personaggio);
	}
	
	public void muoviPersonaggio() throws IllegalMovementException {
		char tastoPremuto = InputDati.leggiUpperChar(MSG_MOVIMENTO, TASTI_MOVIMENTO);
		
		switch(tastoPremuto) {
		case 'W': this.personaggio.miMuovo(-VALORE_MOVIMENTO, 0, mappa);
					
				break;
		case 'A': this.personaggio.miMuovo(0, -VALORE_MOVIMENTO, mappa);
			
			break;
		case 'S': this.personaggio.miMuovo(VALORE_MOVIMENTO, 0, mappa);
			
			break;
		case 'D': this.personaggio.miMuovo(0, VALORE_MOVIMENTO, mappa);
			
			break;	
		}
	}
	
	public String stampaMappa() {
		StringBuffer descrizioneMappa = new StringBuffer();
		for(int i = 0; i < mappa.length; i++) {
			for(int j = 0; j < mappa[0].length; j++) {
				String simbolo = legendaSimboli.get(mappa[i][j]);
				
				descrizioneMappa.append(String.format("%s ", simbolo));
			}
			descrizioneMappa.append(String.format("%n"));
		}
		
		return descrizioneMappa.toString();
	}

	public static void creaLegendaSimboli() {
		legendaSimboli.put(0, "#");
		legendaSimboli.put(1, ".");
		legendaSimboli.put(2, "O");
		legendaSimboli.put(3, "M");
		legendaSimboli.put(4, "C");	
	}	
	
	public Personaggio getPersonaggio() {
		return personaggio;
	}


}
