package it.unibs.pgmarnaldoesame;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;
import it.unibs.myexception.IllegalMovementException;

public class Personaggio extends Entita{
	
	private static final String MSG_STATISTICHE = "Statistiche giocatore:%n";
	private static final String STATISTICHE_PERSONAGGIO = "Nome: %s%nVita: %d%nAttacco base: %d%nDifesa base: %d%nInventario:%n%s";
	private static final int VITA = 20;
	private static final int ATTACCO_BASE = 5;
	private static final int DIFESA_BASE = 5;
	
	private int [] posizioneAttuale = new int [2];
	private ArrayList<Oggetto> inventario;
	private Oggetto oggettoImpugnato;
	
	
	public Personaggio(String nome, int posizioneX, int posizioneY) {
		super(nome, VITA, ATTACCO_BASE, DIFESA_BASE);
		this.inventario = new ArrayList<Oggetto>();
		this.posizioneAttuale[0] = posizioneX;
		this.posizioneAttuale[1] = posizioneY;
	}
	
	public static Personaggio creaPersonaggio(int posizioneX, int posizioneY) {
		String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del tuo personaggio: ");
		
		
		return new Personaggio(nome, posizioneX, posizioneY);
	}
	
	public void miMuovo(int offSetX, int offSetY, int [][] mappa) throws IllegalMovementException {
		int posizioneX = this.posizioneAttuale[0] + offSetX;
		int posizioneY = this.posizioneAttuale[1] + offSetY;
		
		
		if(!controllaPosizione(posizioneX, posizioneY, mappa)) 
		{
			throw new IllegalMovementException("Pensi di poter camminare sui muri?");
		}
		
		this.posizioneAttuale[0] = posizioneX;
		this.posizioneAttuale[1] = posizioneY;
		
	}

	public boolean controllaPosizione(int posizioneX, int posizioneY, int [][] mappa) {
		if(posizioneX < 0 || posizioneX > mappa.length - 1 || posizioneY < 0 || posizioneY > mappa[0].length - 1)
		{
			return false;
		}
		
		if(mappa[posizioneX][posizioneY] == 0)
		{
			return false;
		}
		
		
		
		return true;
	}

	@Override
	public String toString() {
		StringBuffer statistiche = new StringBuffer();
		
		statistiche.append(String.format(MSG_STATISTICHE));
		
		
		StringBuffer inventario = new StringBuffer();
		
		for(Oggetto oggetto : this.inventario) {
			inventario.append(String.format("- %s", oggetto.toString()));
		}
		
		statistiche.append(String.format(STATISTICHE_PERSONAGGIO, this.getNome(), this.getVita(), this.getAttaccoBase(), this.getDifesaBase(), inventario));
		
		statistiche.append(String.format("Posizione attuale (%d, %d)%n", this.posizioneAttuale[0], this.posizioneAttuale[1]));
		
		return statistiche.toString();
	}
	
	public int[] getPosizioneAttuale() {
		return posizioneAttuale;
	}

	public void setPosizioneAttuale(int[] posizioneAttuale) {
		this.posizioneAttuale = posizioneAttuale;
	}
	
}
