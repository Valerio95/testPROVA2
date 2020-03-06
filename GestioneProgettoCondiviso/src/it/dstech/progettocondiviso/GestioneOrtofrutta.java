package it.dstech.ortofrutta;

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

	public class  GestioneOrtofrutta{
		
		static Scanner input= new Scanner(System.in);
		static List<Prodotto> magazzino = new ArrayList<>();
		static List<Cliente> clientela = new ArrayList<>();
		
		public static void main(String[] args) {
			
			creaNuovoFile();
			
			while (true) {
				System.out.println("Cosa vuoi fare?");
				menu();
				int scelta = input.nextInt();
				input.nextLine();
			
				switch (scelta) {
				case 1: {
					System.out.println("Vuoi aggiungere o rimuovere un prodotto? 1.Aggiungi 2.Rimuovi");
					int d=input.nextInt();
					input.nextLine();
					if(d==1) {
					aggiungiProdotto();
					System.out.println("Prodotto inserito");
					} else {
					rimuoviProdotto();
					System.out.println("Prodotto rimosso");
					}
				break;
				}
				case 2 : {
					System.out.println("Vuoi aggiungere o rimuovere un cliente? 1.Aggiungi 2.Rimuovi");
					int i=input.nextInt();
					input.nextLine();
					if(i==1) {
					aggiungiCliente();
					System.out.println("Cliente inserito");
					} else {
					rimuoviCliente();
					System.out.println("Cliente rimosso");
					}
				break;}
				case 3 : {
					aggiornaCosto();
				break;
				}
				case 4: {
					generaAcquisto();
				break;
				}
				case 5: {
					//prodottiCari();
					prodottiEconomici();
				break;
				}
				case 6: {
					
				break;
				}
				case 7:{
					
				}
				case 8:{
					
				}	
				case  9: {
					stampaMagazzino();
					stampaClientela();
					salvaSuFile();
				break;
				}
			
				default: {
					
					System.exit(0);
				}
				}
			}
		}
		
		public static void salvaSuFile() {
			try {
				File file = new File("listaMerce.txt");
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream stream = new ObjectOutputStream(out);
				stream.writeObject(magazzino);
				stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					File file2 = new File("listaClientela.txt");
					FileOutputStream out = new FileOutputStream(file2);
					ObjectOutputStream stream = new ObjectOutputStream(out);
					stream.writeObject(clientela);
					stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
		}
		
		
		@SuppressWarnings("unchecked")
		public static void creaNuovoFile() {
			try {
				File file = new File("listaMerce.txt");
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream stream = new ObjectInputStream(in);
				magazzino = (List<Prodotto>) stream.readObject();
				for (Prodotto merce : magazzino) {
					System.out.println(merce);
				}
				stream.close();
			} catch (IOException ext) {
				System.out.println("Eccezione");
				ext.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				File file = new File("listaClientela.txt");
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream stream = new ObjectInputStream(in);
				clientela = (List<Cliente>) stream.readObject();
				for (Cliente cliente : clientela) {
					System.out.println(cliente);
				}
				stream.close();
			} catch (IOException ext) {
				System.out.println("Eccezione");
				ext.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			
		
		public static void generaAcquisto() {
			int quantit‡Casuale=0;
			int acquisto=0;
			int prodottoCasuale = (int)( Math.random()*magazzino.size());
			int idCasuale =0;
			while(quantit‡Casuale<3) {
				quantit‡Casuale = (int)(Math.random()*8);
			}
			acquisto= magazzino.get(prodottoCasuale).getQuantit‡InMagazzino();
			acquisto -= quantit‡Casuale;
			if (acquisto>0) {
			magazzino.get(prodottoCasuale).setQuantit‡InMagazzino(acquisto);
			idCasuale= (int) (Math.random()*clientela.size());
			clientela.get(idCasuale).setSpesaEffettuata(clientela.get(idCasuale).getSpesaeffettuata()+magazzino.get(prodottoCasuale).getCosto()*quantit‡Casuale);
			magazzino.get(prodottoCasuale).setContatoreVendita(magazzino.get(prodottoCasuale).getContatoreVendita()+quantit‡Casuale);
			magazzino.get(prodottoCasuale).contaVendita(quantit‡Casuale);
			System.out.println("Il cliente " + clientela.get(idCasuale).getNome() + " ha comprato " +quantit‡Casuale+ " " +magazzino.get(prodottoCasuale).getDescrizione());
			}
		}
			
		public static void prodottiEconomici() {
			Collections.sort(magazzino);
			System.out.println("I 5 prodotti pi˘ economici sono");
			if(magazzino.size()>5) {
			for (int i=0; i<5; i++) {
				System.out.println(magazzino.get(i));
			}
			}	else {
				System.out.println("Il magazzino contiene meno di 5 elementi");
			}
			
		}
	
		
		public static void stampaMagazzino() {
			for(Prodotto j : magazzino ) {
				System.out.println(j.toString());
			}
		}
		
		public static void stampaClientela() {
			for(Cliente j : clientela ) {
				System.out.println(j.toString());
			}
		}
		
		
		public static void rimuoviProdotto(){
			boolean condizione= true;
			while(condizione){
				int indice=0;
				for(Prodotto prodotto : magazzino) {
					System.out.println("Ecco i prodotti presenti in magazzino");
					System.out.println(indice+"."+prodotto);	
					indice++;
				}
				System.out.println("Quale prodotto vuoi rimuovere?");
				int scelta= input.nextInt();
				input.nextLine();
				magazzino.remove(scelta);
				System.out.println("Vuoi rimuovere un altro prodotto?");
				String siNo =  input.nextLine();
				if(siNo.equals("no")) {
					condizione=false;
				} 
			}
		}
		
		public static void rimuoviCliente(){
			boolean condizione= true;
			while(condizione){
				int indice=0;
				for(Cliente p : clientela) {
					System.out.println("Ecco i clienti presenti nella lista");
					System.out.println(indice+"."+p);	
					indice++;
				}
				System.out.println("Quale cliente vuoi rimuovere?");
				int scelta= input.nextInt();
				input.nextLine();
				clientela.remove(scelta);
				System.out.println("Vuoi rimuovere un altro cliente?");
				String siNo =  input.nextLine();
				if(siNo.equals("no")) {
					condizione=false;
				} 
			}
		}
		
		private static void menu() {
			System.out.println("1. Inserisci o rimuovi un prodotto in magazzino");
			System.out.println("2. Inserisci o rimuovi un cliente dalla clientela");
			System.out.println("3. Cambia il costo di un prodotto");
			System.out.println("4. Genera acquisto");
			System.out.println("5. Elenca i 5 prodotti pi˘ costosi e i 5 pi˘ economici");
			System.out.println("6. Elenca i primi 5 clienti in ordine di spesa effettuata");
			System.out.println("7. Elenca i 3 clienti che hanno speso meno");
			System.out.println("8. Elenca i 3 prodotti pi˘ venduti e i 3 meno venduti");
			System.out.println("9. Stampa e salva");
			System.out.println("0. Esci");
		}
		
		
		public static void aggiungiProdotto() {
			System.out.println("Inserisci codice del prodotto");
			String codice = input.nextLine();
			System.out.println("Inserisci descrizione del prodotto");
			String descrizione = input.nextLine();
			System.out.println("Inserisci costo");
			double costo = input.nextDouble();
			input.nextLine();
			System.out.println("Inserisci la quantit‡ del prodotto in magazzino");
			int quantit‡=input.nextInt();
			input.nextLine();
			Prodotto prodotto = new Prodotto(codice, descrizione, costo, quantit‡);
			magazzino.add(prodotto);
		}
		
		public static void aggiungiCliente() {
			System.out.println("Inserisci nome cliente");
			String nome= input.nextLine();
			Cliente cliente = new Cliente(nome);
			clientela.add(cliente);
		}
		
		public static void aggiornaCosto() {
			System.out.println("Inserisci il codice del prodotto da aggiornare");
			String codice = input.nextLine();
			Prodotto nuovoProdotto = new Prodotto(codice);
			for(Prodotto i : magazzino) {
				if(i.getCodice().equals(nuovoProdotto.getCodice())) {
						System.out.println("Inserisci nuovo costo");
						double nuovoCosto = input.nextDouble();
						i.setCosto(nuovoCosto);
			}
		}
	}
}