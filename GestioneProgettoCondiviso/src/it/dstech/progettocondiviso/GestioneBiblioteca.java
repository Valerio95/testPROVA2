package it.dstech.progettocondiviso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {

	static Scanner scanner=new Scanner(System.in);
	
	
	
	
	private static void creaScafale() {
		List<Libro> listaLibri=new ArrayList<>();
		System.out.println("Inserisci il genere");
		String genere = scanner.nextLine();
		Scaffale p = new	Scaffale( genere);
		
	}
	
	private static void creaLibro(Scaffale scaffale) {
		
		System.out.println("Inserisci il nome");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l autore");
		 String autore = scanner.nextLine();
		 System.out.println("Inserisci il genere");
		 String genere = scanner.nextLine();
		
		Libro p = new	Libro( titolo,  autore,  genere);
		scaffale.aggiungiLibro(p);
		
		
		
	}
	
	
	public static void aggiornaLibro() {
		boolean sceltaCorretta= true;
		System.out.println("Ecco la lista degli scaffali, quale vuoi selezionare?");
		stampaScaffali();
		int scaffale= input.nextInt();
		input.nextLine();
		System.out.println("Ecco la lista dei libri in questo scaffale, quale vuoi aggiornare?");
		stampaLibri();
		int libro=input.nextInt();
		input.nextLine();
		while(sceltaCorretta) {
			System.out.println("Quale attributo del libro vuoi cambiare? 1.Titolo 2.Autore 3.Genere");
			int scelta=input.nextInt();
			if (scelta==1 || scelta==2 || scelta==3) {
				sceltaCorretta=false;
				if(scelta==1) {
					System.out.println("Inserisci il nuovo autore");
					listaScaffali.get(scaffale).get(libro).setTitolo(input.nextLine());
				} else if (scelta==2){
					System.out.println("Inserisci il nuovo titolo");
					listaScaffali.get(scaffale).get(libro).setAutore(input.nextLine());
				} else {
					System.out.println("Inserisci il nuovo genere");
					listaScaffali.get(scaffale).get(libro).setGenere(input.nextLine());
					inserisciLibroNelGiustoScaffale;
				}
			}
		}
	}
	
	
}


