package it.dstech.gestionelibreriamusicale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Playlist implements Serializable {
private String nome;
private String dataCreazione;
private List<Brano> listaBrani;
private Genere generePlaylist;
ContaGeneri<Genere> contaGeneri = new ContaGeneri<>();

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDataCreazione() {
	return dataCreazione;
}
public void setDataCreazione(String dataCreazione) {
	this.dataCreazione = dataCreazione;
}
public List<Brano> getListaBrani() {
	return listaBrani;
}
public void setListaBrani(List<Brano> listaBrani) {
	this.listaBrani = listaBrani;
}
public Genere getGenerePlaylist() {
	return generePlaylist;
}
public void setGenerePlaylist(Genere generePlaylist) {
	this.generePlaylist = generePlaylist;
}
public Playlist(String nome, String dataCreazione) {
	super();
	this.nome = nome;
	this.dataCreazione = dataCreazione;
	this.listaBrani = new ArrayList<>();
}
public boolean aggiungiBrano(Brano brano) {
	if (this.getListaBrani().contains(brano)) {
		return false;
	}
	this.listaBrani.add(brano);
	return true;
}

public boolean rimuoviBrano(Brano brano) {
	if (!this.getListaBrani().contains(brano)) {
		return false;
	}
	this.listaBrani.remove(brano);
	return true;
}
public ContaGeneri<Genere> riempiMappa() {
	for (Brano brano:listaBrani) {
		contaGeneri.conta(brano.getGenere());
	}
	return contaGeneri;
}
public Genere calcolaGenereMaggiore() {
	Integer genereMaggiore=0;
	riempiMappa();
for (Map.Entry<Genere, Integer> entry : contaGeneri.getMappa().entrySet()) {
		if(entry.getValue()>genereMaggiore){	
			 generePlaylist=entry.getKey();
		}
	}
return generePlaylist;
	
}
@Override
public String toString() {
	return "Playlist [nome=" + nome + ", dataCreazione=" + dataCreazione + ", listaBrani=" + listaBrani
			+ ", generePlaylist=" + generePlaylist + "]";
}

}
