package IHM;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Panels.PanelEntree;
import Panels.PanelAnnuaire;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;

	public MainWindow() {
		// setSize(800, 600);
		setResizable(false);

		mainPanel = new JPanel(new GridLayout(1, 2));
		PanelAnnuaire pa = null;
		PanelEntree pe = null;

		pa = new PanelAnnuaire(pe);
		pe = new PanelEntree(pa);

		mainPanel.add(pa);
		mainPanel.add(pe);
		getContentPane().add(mainPanel);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
