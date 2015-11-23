package business;

import Domaine.Entree;
import Domaine.Personne;
import Fabrics.FabricEntree;

public class AddEntriesJob {

	public Entree add(String code, String valeur, Personne p) {
		return FabricEntree.getInstanceOf().createEntree(code, valeur, p);
	}
}
