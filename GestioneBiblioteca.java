package it.dstech.progettocondiviso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {
	static List<Libro> listaLibri=new ArrayList<>();
static List<Scaffale> listaScaffali=new ArrayList<>();
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		try {

			Scaffale c = caricaScaffale();
		menu();
		 int scelta=scanner.nextInt();
		switch (scelta) {
		case 1:System.out.println("1. aggiungi 2. rimuovi");
		scelta=scanner.nextInt();
		if(scelta==1) {
			aggiungiScaffale();
			}else {
			rimuoviScaffale();
			}
			break;
case 2:
	stampaScaffali();
	System.out.println("");
				
			}
			break;

		default:
			break;
		}
	}
	
	
	
	private static void aggiungiScaffale() {
		System.out.println("Inserisci il genere");
		String genere = scanner.nextLine();
		Scaffale p = new	Scaffale( genere);
		listaScaffali.add(p);
	}
	
	private static void aggiungiLibro(Scaffale scaffale) {
		
		System.out.println("Inserisci il nome");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l autore");
		 String autore = scanner.nextLine();
		 System.out.println("Inserisci il genere");
		 String genere = scanner.nextLine();
		
		Libro p = new	Libro( titolo,  autore,  genere);
		scaffale.aggiungiLibro(p);
		
		
		
	}
	public static void rimuoviScaffale(){
		boolean condizione= true;
		while(condizione){
			int indice=0;
			for(Scaffale p : listaScaffali) {
				System.out.println("Ecco i clienti presenti nella lista");
				System.out.println(indice+"."+p);	
				indice++;
			}
			System.out.println("Quale cliente vuoi rimuovere?");
			int scelta= scanner.nextInt();
			scanner.nextLine();
			listaScaffali.remove(scelta);
			System.out.println("Vuoi rimuovere un altro cliente?");
			String siNo =  scanner.nextLine();
			if(siNo.equals("no")) {
				condizione=false;
			} 
		}
	}
	private static void menu() {
		System.out.println("1. Inserisci o rimuovi uno scaffale");
		System.out.println("2. Inserisci o rimuovi un libro");
		System.out.println("3. aggiorna libri");
		System.out.println("4. ");
		System.out.println("5. Elenca i 5 prodotti più costosi e i 5 più economici");
		System.out.println("6. Elenca i primi 5 clienti in ordine di spesa effettuata");
		System.out.println("7. Elenca i 3 clienti che hanno speso meno");
		System.out.println("8. Elenca i 3 prodotti più venduti e i 3 meno venduti");
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
	
}
