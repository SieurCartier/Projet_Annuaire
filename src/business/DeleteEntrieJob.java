package business;

import Domaine.Entree;
import Fabrics.FabricEntree;

public class DeleteEntrieJob {

	public void delete(Entree e) {
		FabricEntree.getInstanceOf().deleteEntrie(e);
	}
}
