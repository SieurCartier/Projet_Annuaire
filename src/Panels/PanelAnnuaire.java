package Panels;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

import Domaine.Entree;
import Domaine.Personne;
import Fabrics.FabricEntree;
import business.AddPersonJob;
import business.DeletePersonneJob;

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
			AddPersonJob aj = new AddPersonJob();
			model.addElement(aj.add(firstField.getText(), secondField.getText()));
		}
		if (e.getSource() == deleteButton) {
			Personne p = model.getElementAt(laliste.getSelectedIndex());
			DeletePersonneJob dj = new DeletePersonneJob();
			dj.delete(p);
			model.removeElement(p);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		Personne p = model.getElementAt(laliste.getSelectedIndex());
		panelEntrees.getModel().clear();

		for (Entree e : FabricEntree.getInstanceOf().getEntriesOf(p)) {
			panelEntrees.getModel().addElement(e);
		}
	}

}
