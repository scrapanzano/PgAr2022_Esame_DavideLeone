package it.unibs.pgmarnaldoesame;

import it.unibs.myexception.IllegalMovementException;

public class Main {

	public static void main(String[] args) {
		
		Partita partita = Partita.inizializzaPartita();
		
		System.out.println(partita.stampaMappa());
		
		try {
			partita.cicloTurno();
		} catch (IllegalMovementException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
