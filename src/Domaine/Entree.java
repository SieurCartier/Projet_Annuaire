package Domaine;

public class Entree {

	private int index;
	private String code;
	private String valeur;
	private Personne annuaire;

	public Entree(int index, String code, String valeur, Personne annuaire) {
		this.index = index;
		this.code = code;
		this.valeur = valeur;
		this.annuaire = annuaire;
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
		return code + " : " + valeur ;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annuaire == null) ? 0 : annuaire.hashCode());
		result = prime * result + index;
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
		Entree other = (Entree) obj;
		if (annuaire == null) {
			if (other.annuaire != null)
				return false;
		} else if (!annuaire.equals(other.annuaire))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

}
