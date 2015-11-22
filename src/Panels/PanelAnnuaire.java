package Panels;

import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionEvent;

import Domaine.Personne;
import Fabrics.FabricPersonne;

public class PanelAnnuaire extends ManagedListPanel<Personne> {

	private static final long serialVersionUID = 1L;

	public PanelAnnuaire() {
		super("Annuaire", "Nom", "Prénom");
		/*
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 * model.addElement(new Annuaire(1, "test", "test")) ;
		 */

	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		if (e.getSource() == addButton) {
			FabricPersonne.getInstanceOf().createPersonne(firstField.getText(),
					secondField.getText());
		}
		if (e.getSource() == deleteButton) {
			System.out.println("Delete");
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
