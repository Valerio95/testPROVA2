package it.dstech.progettocondiviso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {

	static Scanner scanner=new Scanner(System.in);
	
	
	
	
	private static Scaffale creaScafale() {
		List<Libro> listaBrani=new ArrayList<>();
		System.out.println("Inserisci il nome");
		String genere = scanner.nextLine();
		Scaffale p = new	Scaffale( genere);
		return p;
		
	}
	
	private static Libro creaLibro(Scaffale scaffale) {
		
		System.out.println("Inserisci il nome");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l autore");
		 String autore = scanner.nextLine();
		 System.out.println("Inserisci il genere");
		 String genere = scanner.nextLine();
		
		Libro p = new	Libro( titolo,  autore,  genere);
		scaffale.aggiungiLibro(p);
		return p;
		
		
	}
	
	
	
	
	
}
