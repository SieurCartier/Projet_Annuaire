package business;

import Domaine.Personne;
import Fabrics.FabricPersonne;

public class AddPersonJob {

	public Personne add(String nom, String prenom) {
		return FabricPersonne.getInstanceOf().createPersonne(nom, prenom);
	}
}
