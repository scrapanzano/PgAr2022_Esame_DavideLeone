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
	private static int [] posizioneInizialePersonaggio = new int [2];
	
	public Partita(Personaggio personaggio) {
		this.personaggio = personaggio;
	}
	
	public static Partita inizializzaPartita() {
		
		creaLegendaSimboli();
		
		mappa = LettoreMappeXML.leggiMappa(legendaSimboli);
		
		posizioneInizialePersonaggio();
		
		Personaggio personaggio = Personaggio.creaPersonaggio(posizioneInizialePersonaggio[0],posizioneInizialePersonaggio[1]);
		
		return new Partita(personaggio);
	}
	
	public void cicloTurno() throws IllegalMovementException {
		do {
			muoviPersonaggio();
			if(this.personaggio.getPosizioneAttuale()[0] != Partita.posizioneInizialePersonaggio[0] || this.personaggio.getPosizioneAttuale()[1] != Partita.posizioneInizialePersonaggio[1])
			{
				aggiornaMappa();
			}
			System.out.println(toString());
		}while(true);
		
	}
	
	
	public void muoviPersonaggio() throws IllegalMovementException {
		char tastoPremuto = InputDati.leggiUpperChar(MSG_MOVIMENTO, TASTI_MOVIMENTO);
		
		switch(tastoPremuto) {
		case 'W': Partita.posizioneInizialePersonaggio[0] = this.personaggio.getPosizioneAttuale()[0];
				  Partita.posizioneInizialePersonaggio[1] = this.personaggio.getPosizioneAttuale()[1];
				  this.personaggio.miMuovo(-VALORE_MOVIMENTO, 0, mappa);	
				  break;
				   
		case 'A': Partita.posizioneInizialePersonaggio[0] = this.personaggio.getPosizioneAttuale()[0];
				  Partita.posizioneInizialePersonaggio[1] = this.personaggio.getPosizioneAttuale()[1];
			      this.personaggio.miMuovo(0, -VALORE_MOVIMENTO, mappa);
			      break;
			      
		case 'S': Partita.posizioneInizialePersonaggio[0] = this.personaggio.getPosizioneAttuale()[0];
		  		  Partita.posizioneInizialePersonaggio[1] = this.personaggio.getPosizioneAttuale()[1]; 
			      this.personaggio.miMuovo(VALORE_MOVIMENTO, 0, mappa);
			      break;
			
		case 'D': Partita.posizioneInizialePersonaggio[0] = this.personaggio.getPosizioneAttuale()[0];
		  		  Partita.posizioneInizialePersonaggio[1] = this.personaggio.getPosizioneAttuale()[1];
			      this.personaggio.miMuovo(0, VALORE_MOVIMENTO, mappa);
			      break;
		}
	}
	
	public void aggiornaMappa() {
		int posizioneX = this.personaggio.getPosizioneAttuale()[0];
		int posizioneY = this.personaggio.getPosizioneAttuale()[1];
		
		Partita.mappa[Partita.posizioneInizialePersonaggio[0]][Partita.posizioneInizialePersonaggio[1]] = 1;
		Partita.mappa[posizioneX][posizioneY] = 2;
			
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

	private static void creaLegendaSimboli() {
		legendaSimboli.put(0, "#");
		legendaSimboli.put(1, ".");
		legendaSimboli.put(2, "O");
		legendaSimboli.put(3, "M");
		legendaSimboli.put(4, "C");	
	}
	
	private static void posizioneInizialePersonaggio() {
		for(int i = 0; i < mappa.length; i++) {
			for(int j = 0; j < mappa[0].length; j++) {
				if(mappa[i][j] == 2) {
					posizioneInizialePersonaggio[0] = i;
					posizioneInizialePersonaggio[1] = j;
					break;
				}
			}
		}
	}
	
	public HashMap<Integer, String> getLegendaSimboli(){
		return Partita.legendaSimboli;
	}
	
	@Override
	public String toString() {
		StringBuffer logPartita = new StringBuffer();
		
		logPartita.append(stampaMappa());
		logPartita.append(this.personaggio.toString());
		
		return logPartita.toString();
	}
	
	public Personaggio getPersonaggio() {
		return personaggio;
	}

	

}
