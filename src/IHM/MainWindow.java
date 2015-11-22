package IHM;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Panels.EntreePanel;
import Panels.PanelAnnuaire;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel mainPanel;

	public MainWindow() {
		// setSize(800, 600);
		setResizable(false);

		mainPanel = new JPanel(new GridLayout(1, 2));
		mainPanel.add(new PanelAnnuaire());
		mainPanel.add(new EntreePanel());
		getContentPane().add(mainPanel);
		pack();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
