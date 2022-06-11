package it.unibs.pgmarnaldoesame;

public class Entita {
	
	private String nome;
	private int vita;
	private int attaccoBase;
	private int difesaBase;
	
	public Entita(String nome, int vita, int attaccoBase, int difesaBase) {
		this.nome = nome;
		this.vita = vita;
		this.attaccoBase = attaccoBase;
		this.difesaBase = difesaBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getAttaccoBase() {
		return attaccoBase;
	}

	public void setAttaccoBase(int attaccoBase) {
		this.attaccoBase = attaccoBase;
	}

	public int getDifesaBase() {
		return difesaBase;
	}

	public void setDifesaBase(int difesaBase) {
		this.difesaBase = difesaBase;
	}

	@Override
	public String toString() {
		return "Entita [nome=" + nome + ", vita=" + vita + ", attaccoBase=" + attaccoBase + ", difesaBase=" + difesaBase
				+ "]";
	}
	
	
	
}
