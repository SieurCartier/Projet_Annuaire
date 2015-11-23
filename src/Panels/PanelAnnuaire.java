package Panels;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

import Domaine.Entree;
import Domaine.Personne;
import Fabrics.FabricEntree;
import Fabrics.FabricPersonne;

public class PanelAnnuaire extends ManagedListPanel<Personne> {

	private static final long serialVersionUID = 1L;

	private ManagedListPanel<Entree> panelEntrees;

	public PanelAnnuaire(ManagedListPanel<Entree> panelEntrees) {
		super("Annuaire", "Nom", "Prénom");
		this.panelEntrees = panelEntrees;
	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		if (e.getSource() == addButton) {
			Personne p = FabricPersonne.getInstanceOf().createPersonne(firstField.getText(), secondField.getText());
			model.addElement(p);
		}
		if (e.getSource() == deleteButton) {
			Personne p = model.getElementAt(laliste.getSelectedIndex());
			FabricPersonne.getInstanceOf().deletePersonne(p);
			model.removeElement(p);
		}
	}

	void updateEntries() {
		Personne p = model.getElementAt(laliste.getSelectedIndex());
		panelEntrees.getModel().clear();

		for (Entree e : FabricEntree.getInstanceOf().getEntriesOf(p)) {
			panelEntrees.getModel().addElement(e);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		updateEntries();
	}

}
