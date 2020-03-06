package it.dstech.biblioteca;

import java.util.ArrayList;
import java.util.List;



public class Scaffale {
	private String genere;
	List<Libro> listaLibri = new ArrayList<>();


	public Scaffale( String genere) {
		super();
		this.listaLibri = new ArrayList<>();
		this.genere = genere;
	}


	public List<Libro> getListaLibri() {
		return listaLibri;
	}


	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public boolean aggiungiLibro(Libro b) {
		if (this.getListaLibri().contains(b)) {
		return false;
	}
		this.getListaLibri().add(b);
		return true;
	}
	
	public boolean rimuoviLibro(Libro b) {
		if (this.getListaLibri().contains(b)) {
			this.getListaLibri().remove(b);
		return true;
	}
	return false;

	}

	@Override
	public String toString() {
		return "Scaffali [genere=" + genere + "]";
	}
}
