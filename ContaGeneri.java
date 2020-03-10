package it.dstech.gestionelibreriamusicale;

import java.util.HashMap;
import java.util.Map;

public class ContaGeneri <Genere>{
	private Map<Genere, Integer> mappa;

	public ContaGeneri() {
		this.setMappa(new HashMap<>());
	}
	
	
	
	public void conta(Genere genere) {
		
		if(this.mappa.containsKey(genere)) {
			Integer occorrenzePrecedenti = this.mappa.get(genere);
			this.mappa.put(genere, occorrenzePrecedenti+1);
		}
		else {
			this.mappa.put(genere, 1);
		}
		
	}
	
	
	
	

	public Map<Genere, Integer> getMappa() {
		return mappa;
	}

	public void setMappa(Map<Genere, Integer> mappa) {
		this.mappa = mappa;
	}



	@Override
	public String toString() {
		return "ContaGeneri [mappa=" + mappa + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mappa == null) ? 0 : mappa.hashCode());
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
		ContaGeneri other = (ContaGeneri) obj;
		if (mappa == null) {
			if (other.mappa != null)
				return false;
		} else if (!mappa.equals(other.mappa))
			return false;
		return true;
	}



	

}
