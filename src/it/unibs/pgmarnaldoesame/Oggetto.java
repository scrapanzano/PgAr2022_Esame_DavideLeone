package it.unibs.pgmarnaldoesame;

public class Oggetto {
	
	private int tipo;
	private String descrizione;
	
	public Oggetto(int tipo, String descrizione) {
		this.tipo = tipo;
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return String.format("%s%n", this.descrizione);
	}

}
