package it.dstech.progettocondiviso;

public class Libro implements Comparable <Libro>{

	private String titolo;
	private String autore;
	private String genere;
	private boolean prenotabilità;
	private int numeroPrenotazioni;

	
	public Libro(String titolo, String autore, String genere) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
	}


	public String getTitolo() {
		return titolo;
	}





	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}





	public String getAutore() {
		return autore;
	}





	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public boolean isPrenotabilità() {
		return prenotabilità;
	}


	public void setPrenotabilità(boolean prenotabilità) {
		this.prenotabilità = prenotabilità;
	}


	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", genere=" + genere + ", prenotabilità="
				+ prenotabilità + "]";
	}


	@Override
	public int compareTo(Libro o) {
		if (this.getNumeroPrenotazioni() < o.getNumeroPrenotazioni())
			return -1;
		else if (this.getNumeroPrenotazioni() > o.getNumeroPrenotazioni()) {
			return 1;
		} 
		return 0;
	}


	public int getNumeroPrenotazioni() {
		return numeroPrenotazioni;
	}


	public void setNumeroPrenotazioni(int numeroPrenotazioni) {
		this.numeroPrenotazioni = numeroPrenotazioni;
	}


}
