package it.dstech.gestionelibreriamusicale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Gestire una libreria musicale. Ogni brano ha un titolo, un autore, una durata (minuti:secondi),
//un genere (Una ENUM) ed un anno di nascita (regex mm/aaaa).
//Una playlist è composta da un nome, una data di creazione (gg/mm/aaaa) ed una lista di brani.
//il genere della playlist viene "calcolato" automaticamente e viene valorizzato in base al genere 
//più presente nella playlist.
//Permettere salvataggio di una o più playlist, caricamento di diverse playlist (quindi diversi file),
//aggiunta di un brano ad una playlist, rimozione di un brano da una playlist.


public class GestioneLibreriaMusicale {
	static Scanner scanner=new Scanner(System.in);
	
public static void main(String[] args)throws ClassNotFoundException, IOException {
Playlist playlist=caricaPlaylist();
menu();
int scelta=scanner.nextInt();
switch (scelta) {
case 1:
	Brano brano = creaBrano();
	playlist.aggiungiBrano(brano);
	playlist.calcolaGenereMaggiore();
	break;
case 2:
	Brano b = scegliBrano(playlist);
	playlist.rimuoviBrano(b);
	playlist.calcolaGenereMaggiore();

case 3:
	stampa(playlist);
	break;
case 4:
	salvaPlaylist(playlist);
	break;
default:
	salvaPlaylist(playlist);
	scanner.close();
	System.exit(0);
	break;
}

	
	
}


public static Brano creaBrano() {
	System.out.println("dammi il nome del brano");
	String nome=scanner.nextLine();
	System.out.println("dammi l'autore");
	String autore=scanner.nextLine();
	System.out.println("dammi il genere");
	System.out.println("ROCK,COUNTRY,CLASSICA,\r\n" + 
			"POP,METAL,IRISH");
	String genereDaTastiera=scanner.nextLine();
	Genere genere=Genere.valueOf(genereDaTastiera);
String durata=durataVerificata(scanner);
String pubblicazione=pubblicazioneVerificata(scanner);

	Brano b = new Brano( nome,  autore,  durata,  pubblicazione,  genere);
	return b;
}
private static String durataVerificata(Scanner scanner) {
	System.out.println("Inserisci la durata della canzone");
	String durata = scanner.nextLine();
	Pattern pattern = Pattern.compile("[0-6][0-9][/]\\\\[0-6][0-9]"); 
	Matcher matcher = pattern.matcher(durata);
	while (!matcher.matches()) {
		System.out.println("Attenzione, durata non valida");
		System.out.println("Inserisci la durata della canzone");
		durata = scanner.nextLine();
		matcher = pattern.matcher(durata);
	}

	return durata;
}
private static String pubblicazioneVerificata(Scanner scanner) {
	System.out.println("Inserisci la pubblicazione della canzone");
	String pubblicazione = scanner.nextLine();
	Pattern pattern = Pattern.compile("(0[1-9]|1[012]|[1-9])(-|\\\\/)(19[0-9]{2}|2[0-9]{3}|[0-9]{2})"); 
	Matcher matcher = pattern.matcher(pubblicazione);
	while (!matcher.matches()) {
		System.out.println("Attenzione, pubblicazione non valida");
		System.out.println("Inserisci la pubblicazione della canzone");
		pubblicazione = scanner.nextLine();
		matcher = pattern.matcher(pubblicazione);
	}

	return pubblicazione;
}

public static Playlist creaPlaylist() {
	System.out.println("dammi il nome della playlist");
	String nome=scanner.nextLine();
	String data=dataVerificata(scanner);
	Playlist p =new Playlist(nome,data);
	return p;
}
private static String dataVerificata(Scanner scanner) {
	System.out.println("Inserisci la data");
	String data = scanner.nextLine();
	Pattern pattern = Pattern.compile("(0[1-9]|1[012]|[1-9])(-|\\/)([0-9]|[123]0|[012][1-9]|31)(-|\\/)(19[0-9]{2}|2[0-9]{3}|[0-9]{2})"); 
	Matcher matcher = pattern.matcher(data);
	while (!matcher.matches()) {
		System.out.println("Attenzione, data non valida");
		System.out.println("Inserisci la data");
		data = scanner.nextLine();
		matcher = pattern.matcher(data);
	}

	return data;
}
private static Playlist caricaPlaylist() throws ClassNotFoundException, IOException {
	System.out.println("dammi il nome della playlist");
	String nome=scanner.nextLine();
	File file = new File(nome);
	if (!file.exists()) {
		file.createNewFile();
		Playlist playlist = creaPlaylist();
		salvaPlaylist(playlist);
		return playlist;
	}
	FileInputStream in = new FileInputStream(file);
	ObjectInputStream stream = new ObjectInputStream(in);
	Playlist playlist = (Playlist) stream.readObject();
	return playlist;
}

private static void salvaPlaylist(Playlist playlist) throws IOException {
	System.out.println("dammi il nome della playlist");
	String nome=scanner.nextLine();
	File file = new File(nome);
	if (!file.exists()) {
		file.createNewFile();
	}
	FileOutputStream out = new FileOutputStream(file);
	ObjectOutputStream stream = new ObjectOutputStream(out);
	stream.writeObject(playlist);
	stream.close();

}
private static void menu() {

	System.out.println("Fai la tua scelta");
	System.out.println("1. inserisci un brano");
	System.out.println("2. rimuovi un brano");
	System.out.println("3. stampa playlist");
	System.out.println("4. salva");
	System.out.println("0. ESCI");

}
private static Brano scegliBrano(Playlist playlist) {
	for(int i=0;i<playlist.getListaBrani().size();i++) {
		System.out.println(i+"."+playlist.getListaBrani().get(i));
	}
	System.out.println("dammi l'indice");
	int indice=scanner.nextInt();
	return playlist.getListaBrani().get(indice);
}

private static void stampa(Playlist playlist) {
	System.out.println(playlist);
}
}
