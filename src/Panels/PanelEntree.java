package Panels;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import Domaine.*;
import business.*;

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
			AddEntriesJob aj = new AddEntriesJob();
			Entree e = aj.add(firstField.getText(), secondField.getText(), p);
			model.addElement(e);
		}
		if (ae.getSource() == deleteButton) {
			Entree e = model.getElementAt(laliste.getSelectedIndex());
			DeleteEntrieJob dj = new DeleteEntrieJob();
			dj.delete(e);
			model.removeElement(e);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
