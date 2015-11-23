package Panels;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import Domaine.Entree;
import Domaine.Personne;
import Fabrics.FabricEntree;

public class PanelEntree extends ManagedListPanel<Entree> {

	private static final long serialVersionUID = 1L;
	private ManagedListPanel<Personne> pannelPerso;

	public PanelEntree(ManagedListPanel<Personne> panelPersonnes) {
		super("Entree", "Code", "Valeur");
		this.pannelPerso = panelPersonnes;
	}

	public void actionPerformed(ActionEvent ae) {
		super.actionPerformed(ae);

		if (ae.getSource() == addButton) {
			Personne p = pannelPerso.getModel().getElementAt(pannelPerso.getJList().getSelectedIndex());
			Entree e = FabricEntree.getInstanceOf().createEntree(firstField.getText(), secondField.getText(), p);
			model.addElement(e);
		}
		if (ae.getSource() == deleteButton) {
			Entree e = model.getElementAt(laliste.getSelectedIndex());
			FabricEntree.getInstanceOf().deleteEntrie(e);
			model.removeElement(e);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
