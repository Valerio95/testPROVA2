package it.dstech.gestionelibreriamusicale;

public enum Genere {
ROCK("ROCK"),COUNTRY("COUNTRY"),CLASSICA("CLASSICA"),
POP("POP"),METAL("METAL"),IRISH("IRISH");
 
	private String value;
	
	Genere(String value) {
		this.value=value;
		
	}
	
}
