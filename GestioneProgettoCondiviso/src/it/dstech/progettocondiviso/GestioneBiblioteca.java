package it.dstech.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {
	static List<Libro> listaLibri=new ArrayList<>();
	static List<Scaffale> listaScaffali=new ArrayList<>();
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
     
		while(true){
			menu();
		int scelta=scanner.nextInt();
		
		switch (scelta) {
		case 1:
			System.out.println("1. Aggiungi 2. Rimuovi");
			scelta=scanner.nextInt();
			scanner.nextLine();
			if(scelta==1) {
				aggiungiScaffale();
			} else {
				rimuoviScaffale();
			}
			break;
		case 2:
			aggiungiLibro();
			break;
		case 3:
			aggiornaLibro();
			break;
		case 6:
			stampaScaffali();
			stampaLibri();
			break;
		
		default:
			break;
		} 
	}	
}
	
	public static void aggiungiScaffale() {
		System.out.println("Inserisci il genere");
		String genere = scanner.nextLine();
		Scaffale p = new	Scaffale( genere);
		listaScaffali.add(p);
	}
	
	
	public static void aggiungiLibro() {
		
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		
		System.out.println("Inserisci il nome");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l autore");
		String autore = scanner.nextLine();
		System.out.println("Inserisci il genere");
		String genere = scanner.nextLine();
		
		
		
		Libro p = new	Libro( titolo,  autore,  genere);
		listaScaffali.get(controlloGenere(genere)).aggiungiLibro(p);	
	}
	
	public static int controlloGenere(String genere){
		int indiceScaffale=0;
		int indice=0;
		for (Scaffale scaffale : listaScaffali) {
			indice++;
			if(genere.equals(scaffale.getGenere())) {}
			indiceScaffale=indice;
		}
		return indiceScaffale;
	}
	
	public static void rimuoviScaffale(){
		boolean condizione= true;
		while(condizione){
			int indice=0;
			System.out.println("Ecco gli scaffali presenti nella lista");
			for(Scaffale p : listaScaffali) {
				System.out.println(indice+"."+p);	
				indice++;
			}
			System.out.println("Quale scaffale vuoi rimuovere?");
			int scelta= scanner.nextInt();
			scanner.nextLine();
			listaScaffali.remove(scelta);
			System.out.println("Vuoi rimuovere un altro scaffale?");
			String siNo =  scanner.nextLine();
			if(siNo.equals("no")) {
				condizione=false;
			} 
		}
	}
	
	
	public static void menu() {
		System.out.println("1. Inserisci o rimuovi uno scaffale");
		System.out.println("2. Inserisci o rimuovi un libro");
		System.out.println("3. Aggiorna libro");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println("6. ");
		System.out.println("7. ");
		System.out.println("8. ");
		System.out.println("9. Stampa e salva");
		System.out.println("0. Esci");
	}
	
	
	public static void stampaScaffali() {
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}	
	}
	
	public static void stampaLibri() {
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		System.out.println("dammi l'indice dello scaffale");
		int scelta=scanner.nextInt();
		System.out.println(listaScaffali.get(scelta).getListaLibri());
	}
	
	public static void aggiornaLibro() {
		boolean sceltaCorretta= true;
		System.out.println("Ecco la lista degli scaffali, quale vuoi selezionare?");
		stampaScaffali();
		int scaffale= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ecco la lista dei libri in questo scaffale, quale vuoi aggiornare?");
		stampaLibri();
		int libro=scanner.nextInt();
		scanner.nextLine();
		while(sceltaCorretta) {
			System.out.println("Quale attributo del libro vuoi cambiare? 1.Titolo 2.Autore 3.Genere");
			int scelta=scanner.nextInt();
			if (scelta==1 || scelta==2 || scelta==3) {
				sceltaCorretta=false;
				if(scelta==1) {
					System.out.println("Inserisci il nuovo autore");
					listaScaffali.get(scaffale).getListaLibri().get(libro).setTitolo(scanner.nextLine());
				} else if (scelta==2){
					System.out.println("Inserisci il nuovo titolo");
					listaScaffali.get(scaffale).getListaLibri().get(libro).setAutore(scanner.nextLine());
				} else {
					System.out.println("Inserisci il nuovo genere");
					listaScaffali.get(scaffale).getListaLibri().get(libro).setGenere(scanner.nextLine());	
				}
			}
		}
	}
}
