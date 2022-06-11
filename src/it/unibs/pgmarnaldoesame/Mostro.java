package it.unibs.pgmarnaldoesame;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Mostro extends Entita{
	


	private static final String NOME_DEFAULT_MOSTRO = "Dijkstra";
	
	private static final int MAX_VITA_MOSTRO = 25;
	private static final int MIN_VITA_MOSTRO = 15;
	private static final int ATTACCO_BASE = 5;
	private static final int DIFESA_BASE = 5;

	private Arma arma;
	
	public Mostro(String nome, int vita) {
		super(nome, vita, ATTACCO_BASE, DIFESA_BASE);
		this.arma = new Arma();
	}

	public static Mostro creaMostro() {
		List<Character> charList = NOME_DEFAULT_MOSTRO.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
	    Collections.shuffle(charList);
	    String nome =  charList.stream().map(String::valueOf).collect(Collectors.joining());
	    
	    int vita = EstrazioniCasuali.estraiIntero(MIN_VITA_MOSTRO, MAX_VITA_MOSTRO);
	   
	    
	    return new Mostro(nome, vita);
	}

}
