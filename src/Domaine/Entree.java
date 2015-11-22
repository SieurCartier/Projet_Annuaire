package Domaine;

public class Entree {

	private int index;
	private String code;
	private String valeur;
	private Personne perso;

	public Entree(int index, String code, String valeur, Personne p) {
		this.index = index;
		this.code = code;
		this.valeur = valeur;
		this.perso = p;
	}

	public int getIndex() {
		return index;
	}

	public Personne getPersonne() {
		return perso;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return code + " : " + valeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Entree)) {
			return false;
		}
		Entree other = (Entree) obj;
		if (index != other.index) {
			return false;
		}
		return true;
	}

}
