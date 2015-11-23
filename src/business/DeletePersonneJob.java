package business;

import Domaine.Personne;
import Fabrics.FabricPersonne;

public class DeletePersonneJob {

	public void delete(Personne p) {
		FabricPersonne.getInstanceOf().deletePersonne(p);
	}
}
