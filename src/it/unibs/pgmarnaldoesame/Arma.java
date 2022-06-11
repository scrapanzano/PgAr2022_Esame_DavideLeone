package it.unibs.pgmarnaldoesame;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Arma extends Oggetto{

	private static final String DESCRIZIONE_ARMA = "Un'arma dall'impugnatura particolare";
	
	private static final int MAX_POTENZA_ARMA = 55;
	private static final int MIN_POTENZA_ARMA = 35;
	private static final int TIPO = 1;
	
	private int potenza;
	
	public Arma() {
		super(TIPO, DESCRIZIONE_ARMA);
		this.potenza = EstrazioniCasuali.estraiIntero(MIN_POTENZA_ARMA, MAX_POTENZA_ARMA);
	}
	
	@Override
	public String toString() {
		return String.format("Arma:%nPotenza: %d%nDescrizione:%s", this.potenza, this.DESCRIZIONE_ARMA);
	}

}
