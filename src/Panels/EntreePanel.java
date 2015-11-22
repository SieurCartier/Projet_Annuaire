package Panels;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import Domaine.Entree;

public class EntreePanel extends ManagedListPanel<Entree> {

	private static final long serialVersionUID = 1L;

	public EntreePanel() {
		super("Entree", "Code", "Valeur");
		/*
		 * model.addElement(new Entree(1, "test", "test", new Annuaire(1,
		 * "test", "test"))) ; model.addElement(new Entree(1, "test", "test",
		 * new Annuaire(1, "test", "test"))) ; model.addElement(new Entree(1,
		 * "test", "test", new Annuaire(1, "test", "test"))) ;
		 * model.addElement(new Entree(1, "test", "test", new Annuaire(1,
		 * "test", "test"))) ; model.addElement(new Entree(1, "test", "test",
		 * new Annuaire(1, "test", "test"))) ; model.addElement(new Entree(1,
		 * "test", "test", new Annuaire(1, "test", "test"))) ;
		 * model.addElement(new Entree(1, "test", "test", new Annuaire(1,
		 * "test", "test"))) ; model.addElement(new Entree(1, "test", "test",
		 * new Annuaire(1, "test", "test"))) ; model.addElement(new Entree(1,
		 * "test", "test", new Annuaire(1, "test", "test"))) ;
		 * model.addElement(new Entree(1, "test", "test", new Annuaire(1,
		 * "test", "test"))) ; model.addElement(new Entree(1, "test", "test",
		 * new Annuaire(1, "test", "test"))) ;
		 */

	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}

}
