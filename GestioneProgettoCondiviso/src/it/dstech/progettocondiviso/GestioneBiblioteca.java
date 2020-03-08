package it.dstech.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GestioneBiblioteca {
	
	static List<Libro> listaLibri=new ArrayList<>();
	static List<Scaffale> listaScaffali=new ArrayList<>();
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		creaNuovoFile();
		
		while(true){
			menu();
			int scelta=scanner.nextInt();
			scanner.nextLine();
			switch (scelta) {
				case 1:System.out.println("1. Aggiungi 2. Rimuovi");
					scelta=scanner.nextInt();
					scanner.nextLine();
					if(scelta==1) {
						aggiungiScaffale();
					} else {
						rimuoviScaffale();
					}
				break;
				case 2:
					System.out.println("1. Aggiungi 2. Rimuovi");
					scelta=scanner.nextInt();
					scanner.nextLine();
					if(scelta==1) {
						aggiungiLibro();
					} else {
						rimuoviLibro();
					}
					break;
				case 3:
					aggiornaLibro();
				break;
				case 4:
					cambiaPrenotabilità();
					break;
				case 5:
					libriPiuPrenotati();
				break;
				case 6:
					libriMenoPrenotati();
					break;
				case 7:
					stampaScaffali();
				break;
				case 8:
					stampaLibri();
				break;
				case 9:
					salvaSuFile();
				break;
				default:
					salvaSuFile();
					System.exit(0);
				break;
			} 
		}
	}
	
	
	public static void cambiaPrenotabilità() {
		System.out.println("Ecco la lista degli scaffali, quale vuoi selezionare?");
		stampaScaffali();
		int scaffale= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Di quale libro vuoi modificare la prenotabilità?");
		System.out.println(listaScaffali.get(scaffale).getListaLibri());
		listaScaffali.get(scaffale).getListaLibri().get(scanner.nextInt()).cambiaPrenotazione();
		System.out.println("Prenotazione modificata");
	}
			

	public static void aggiungiScaffale() {
		Genere genere=null;
		System.out.println("Inserisci l'indice del genere");
		System.out.println("1.HORROR,\r\n" + 
				"2.FANTASY,\r\n" + 
				"3.FANTASCIENZA,\r\n" + 
				"4.THRILLER,\r\n"  
				);
		int scelta=scanner.nextInt();
		
		switch (scelta) {
			case 1: {
				genere= Genere.HORROR;
			break;}
			case 2: {
				genere= Genere.FANTASY;
			break;
			} case 3: {
				genere= Genere.FANTASCIENZA;	
			break;
			} case 4: {
				genere= Genere.THRILLER;			
			break;}
		default:
			break;
		}
		
		Scaffale p = new Scaffale( genere);
		listaScaffali.add(p);
	}
	
	
	public static void aggiungiLibro() {

		System.out.println("Inserisci il nome del libro da aggiungere");
		String titolo = scanner.nextLine();
		System.out.println("Inserisci l' autore");
		String autore = scanner.nextLine();
		Genere genere=null;
		System.out.println("Inserisci il genere");
		System.out.println("1.HORROR,\r\n" + 
				"2.FANTASY,\r\n" + 
				"3.FANTASCIENZA,\r\n" + 
				"4.THRILLER,\r\n"  
				);
		int scelta=scanner.nextInt();
		scanner.nextLine();
		
		switch (scelta) {
			case 1: 
				genere= Genere.HORROR;
			
			break;
			case 2: 
				genere= Genere.FANTASY;
			
			break;
			case 3: 
				 genere= Genere.FANTASCIENZA;
			break;
			case 4: 
				genere= Genere.THRILLER;		
			break;
		default:
			break;
		}
		Libro p = new	Libro( titolo,  autore,  genere);
		listaScaffali.get(controlloGenere(genere)).aggiungiLibro(p);		
	}
	
	
	public static void rimuoviScaffale(){
		boolean condizione= true;
		while(condizione){
			int indice=0;
			System.out.println("Ecco gli scaffali presenti nella lista");
			for(Scaffale p : listaScaffali) {
				System.out.println(indice+ "." +p);	
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
		System.out.println("3. Aggiorna libri");
		System.out.println("4. Cambia prenotabilità di un libro");
		System.out.println("5. Stampa libri più prenotati");
		System.out.println("6. Stampa libri meno prenotati");
		System.out.println("7. Stampa scaffali");
		System.out.println("8. Stampa libri");
		System.out.println("9. Salva ");
		System.out.println("0. Esci");
	}
	
	
	public static void stampaScaffali() {
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
	}
	
	
	public static int controlloGenere(Genere genere){
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
		for(int i=0; i<listaScaffali.size(); i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}
		System.out.println("Inserisci l'indice dello scaffale di cui vuoi stampare i libri");
		int scelta=scanner.nextInt();
		scanner.nextLine();
		System.out.println(listaScaffali.get(scelta).getListaLibri());
	}
	
	
	public static void aggiornaLibro() {
		boolean sceltaCorretta= true;
		System.out.println("Ecco la lista degli scaffali, quale vuoi selezionare?");
		stampaScaffali();
		int scaffale= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ecco la lista dei libri in questo scaffale, quale vuoi aggiornare?");
		System.out.println(listaScaffali.get(scaffale).getListaLibri());
		int libro=scanner.nextInt();
		scanner.nextLine();
		while(sceltaCorretta) {
			System.out.println("Quale attributo del libro vuoi cambiare? 1.Titolo 2.Autore 3.Genere");
			int scelta=scanner.nextInt();
			scanner.nextLine();
			if (scelta==1 || scelta==2 || scelta==3) {
				sceltaCorretta=false;
				if(scelta==1) {
					System.out.println("Inserisci il nuovo titolo");
					listaScaffali.get(scaffale).getListaLibri().get(libro).setTitolo(scanner.nextLine());
				} else if (scelta==2){
					System.out.println("Inserisci il nuovo autore");
					listaScaffali.get(scaffale).getListaLibri().get(libro).setAutore(scanner.nextLine());
				} else {
					Genere genere=null;
					System.out.println("Inserisci il genere");
					System.out.println("1.HORROR,\r\n" + 
							"2.FANTASY,\r\n" + 
							"3.FANTASCIENZA,\r\n" + 
							"4.THRILLER,\r\n"  
							);
					 scelta=scanner.nextInt();
					 scanner.nextLine();
					
					switch (scelta) {
					case 1: {
						 genere= Genere.HORROR;
						
						break;}
					case 2: {
						 genere= Genere.FANTASY;
						
						break;}
						case 3: {
							 genere= Genere.FANTASCIENZA;
								
								break;}
								case 4: {
									 genere= Genere.THRILLER;
										
										break;}
					default:
						break;
					}
					listaScaffali.get(scaffale).getListaLibri().get(libro).setGenere(genere);
				}
			}
		}
	}
	
	
	public static void rimuoviLibro() {
		for(int i=0;i<listaScaffali.size();i++) {
			System.out.println(i+"." + listaScaffali.get(i) );
		}System.out.println("Da quale scaffale vuoi rimuovere?");
		int indiceScaffale=scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<listaScaffali.get(indiceScaffale).getListaLibri().size();i++) {
			System.out.println(i+"." + listaScaffali.get(indiceScaffale).getListaLibri() );
		}
		System.out.println("Quale libro vuoi rimuovere?");
		int indiceLibro=scanner.nextInt();
		scanner.nextLine();
		listaScaffali.get(indiceScaffale).getListaLibri().remove(indiceLibro);
		System.out.println("Libro rimosso");
	}
	
	
	public static void salvaSuFile() {
		try {
			File file = new File("listaScaffali.txt");
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream stream = new ObjectOutputStream(out);
			stream.writeObject(listaScaffali);
			stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void creaNuovoFile() {
		try {
			File file = new File("listaScaffali.txt");
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream stream = new ObjectInputStream(in);
			listaScaffali = (List<Scaffale>) stream.readObject();
			stream.close();
		} catch (IOException ext) {
			System.out.println("Eccezione");
			ext.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void generaListaLibri() {
		for (Scaffale scaffale : listaScaffali) {
			listaLibri.addAll(scaffale.listaLibri);
		}
	}
	
	public static void libriPiuPrenotati() {
		generaListaLibri();
		Collections.sort(listaLibri);
		Collections.reverse(listaLibri);
		for (Libro libro : listaLibri) {
			System.out.println(libro);
		}
	}
	

	public static void libriMenoPrenotati() {
		generaListaLibri();
		Collections.sort(listaLibri);
		for (Libro libro : listaLibri) {
			System.out.println(libro);
		}
	}
}
