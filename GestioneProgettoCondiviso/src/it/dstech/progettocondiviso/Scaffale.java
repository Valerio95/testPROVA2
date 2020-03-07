package it.dstech.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Scaffale implements Serializable{
	private Genere genere;
	List<Libro> listaLibri = new ArrayList<>();


	public Scaffale( Genere genere) {
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


	public Genere getGenere() {
		return genere;
	}


	public void setGenere(Genere genere) {
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
		return "Scaffale [genere=" + genere + "]";
	}
}
