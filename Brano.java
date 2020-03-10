package it.dstech.gestionelibreriamusicale;

import java.io.Serializable;

public class Brano implements Serializable{
private String nome;
private String autore;
private String durata;
private String pubblicazione;
private Genere genere;
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getAutore() {
	return autore;
}
public Brano(String nome, String autore, String durata, String pubblicazione, Genere genere) {
	super();
	this.nome = nome;
	this.autore = autore;
	this.durata = durata;
	this.pubblicazione = pubblicazione;
	this.genere = genere;
}
public void setAutore(String autore) {
	this.autore = autore;
}
public String getDurata() {
	return durata;
}
public void setDurata(String durata) {
	this.durata = durata;
}
public String getPubblicazione() {
	return pubblicazione;
}
public void setPubblicazione(String pubblicazione) {
	this.pubblicazione = pubblicazione;
}
public Genere getGenere() {
	return genere;
}
public void setGenere(Genere genere) {
	this.genere = genere;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((autore == null) ? 0 : autore.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Brano other = (Brano) obj;
	if (autore == null) {
		if (other.autore != null)
			return false;
	} else if (!autore.equals(other.autore))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}
@Override
public String toString() {
	return "Brano [nome=" + nome + ", autore=" + autore + ", durata=" + durata + ", pubblicazione=" + pubblicazione
			+ ", genere=" + genere + "]";
}

}
