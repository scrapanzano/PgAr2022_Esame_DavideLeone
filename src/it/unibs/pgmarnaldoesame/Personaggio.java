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
	
	private ArrayList<Oggetto> inventario;
	private Oggetto oggettoImpugnato;
	
	
	public Personaggio(String nome) {
		super(nome, VITA, ATTACCO_BASE, DIFESA_BASE);
		this.inventario = new ArrayList<Oggetto>();
		
	}
	
	public static Personaggio creaPersonaggio() {
		String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del tuo personaggio: ");
		
		
		return new Personaggio(nome);
	}
	
	public void miMuovo(int offSetX, int offSetY, int [][] mappa) throws IllegalMovementException {
		int posizioneX = this.getPosizioneAttuale()[0] + offSetX;
		int posizioneY = this.getPosizioneAttuale()[1] + offSetY;
		
		if(posizioneX < 0 || posizioneX > mappa.length || posizioneY < 0 || posizioneY > mappa[0].length) 
		{
			throw new IllegalMovementException("Pensi di poter camminare sui muri?");
		}
		
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
		
		return statistiche.toString();
	}
	
}
