package it.dstech.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {
	static List<Libro> listaLibri=new ArrayList<>();

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
	try {
		List<Scaffale> listaScaffali= caricaScaffale();
			while(true){
		menu();
		 int scelta=scanner.nextInt();
		 scanner.nextLine();
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
			
	}}
			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				}
	}
	
	
	
	public static void aggiungiScaffale() {
		List<Scaffale> listaScaffali=new ArrayList<>();
		System.out.println("Inserisci il genere");
		System.out.println("HORROR,\r\n" + 
				"FANTASY,\r\n" + 
				"STORICO,\r\n" + 
				"FANTASCIENZA,\r\n" + 
				"THRILLER,\r\n" + 
				"COMMEDIA,\r\n" + 
				"GIALLO;");
		String nuovoGenere= scanner.nextLine();
		Genere genere= Genere.valueOf(nuovoGenere);
		Scaffale p = new	Scaffale( genere);
		listaScaffali.add(p);
	}
	
	public static void aggiungiLibro() {
		List<Scaffale> listaScaffali=new ArrayList<>();
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		System.out.println("a quale scaffale vuoi aggiungere il libro");
		int scelta= scanner.nextInt();
		listaScaffali.get(scelta);
		System.out.println("dammi l'indice dello scaffale a cui vuoi aggiungere il");
		
		System.out.println("Inserisci il nome");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l autore");
		 String autore = scanner.nextLine();
		 System.out.println("Inserisci il genere");
			System.out.println("HORROR,\r\n" + 
					"FANTASY,\r\n" + 
					"STORICO,\r\n" + 
					"FANTASCIENZA,\r\n" + 
					"THRILLER,\r\n" + 
					"COMMEDIA,\r\n" + 
					"GIALLO;");
			String nuovoGenere= scanner.nextLine();
			Genere genere= Genere.valueOf(nuovoGenere);
		
		Libro p = new	Libro( titolo,  autore,  genere);
		listaScaffali.get(controlloGenere(genere)).aggiungiLibro(p);		
		
		
	}
	public static void rimuoviScaffale(){
		boolean condizione= true;
		while(condizione){
			List<Scaffale> listaScaffali=new ArrayList<>();
			int indice=0;
			for(Scaffale p : listaScaffali) {
				System.out.println("Ecco i scaffale presenti nella lista");
				System.out.println(indice+"."+p);	
				indice++;
			}
			System.out.println("Quale scaffale vuoi rimuovere?");
			int scelta= scanner.nextInt();
			scanner.nextLine();
			listaScaffali.remove(scelta);
			System.out.println("Vuoi scaffale un altro cliente?");
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
		List<Scaffale> listaScaffali=new ArrayList<>();
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		
	}
	public static int controlloGenere(Genere genere){
		List<Scaffale> listaScaffali=new ArrayList<>();
		int indiceScaffale=0;
		int indice=0;
		for (Scaffale scaffale : listaScaffali) {
			if(genere==scaffale.getGenere()) {
				indiceScaffale=indice;
			}
			indice++;	
		}
		return indiceScaffale;
	}
	public static void stampaLibri() {
		List<Scaffale> listaScaffali=new ArrayList<>();
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		System.out.println("dammi l'indice dello scaffale");
		int scelta=scanner.nextInt();
		System.out.println(listaScaffali.get(scelta).getListaLibri());
	}
	public static void aggiornaLibro() {
		List<Scaffale> listaScaffali=new ArrayList<>();
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
					System.out.println("HORROR,\r\n" + 
							"FANTASY,\r\n" + 
							"STORICO,\r\n" + 
							"FANTASCIENZA,\r\n" + 
							"THRILLER,\r\n" + 
							"COMMEDIA,\r\n" + 
							"GIALLO;");
					
					String nuovoGenere= 
					listaScaffali.get(scaffale).getListaLibri().get(libro).setGenere(nuovoGenere);
					
					
				}
			}
		}
	
}
	
	private static List<Scaffale> caricaScaffale() throws IOException, ClassNotFoundException {
		System.out.println("dammi il nome del file");
		String nome=scanner.nextLine();
		File file = new File(nome);
		if (!file.exists()) {
			file.createNewFile();
			return  caricaScaffale();
		}
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream stream = new ObjectInputStream(in);
		List<Scaffale> c = (List<Scaffale>) stream.readObject();
		stream.close();
		return c;
	}
	private static void salvaScaffale(List<Scaffale> c) throws IOException {
		System.out.println("dammi il nome del file");
		String nome=scanner.nextLine();
	File file = new File(nome);
	FileOutputStream out = new FileOutputStream(file);
	ObjectOutputStream stream = new ObjectOutputStream(out);
	stream.writeObject(c);
	stream.close();
}



}
