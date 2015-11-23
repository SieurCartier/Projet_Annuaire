package Panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public abstract class ManagedListPanel<T> extends JPanel implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;

	/**************** La liste ***************/

	protected JPanel listPanel = new JPanel(new FlowLayout());
	protected DefaultListModel<T> model = new DefaultListModel<T>();
	protected JList<T> laliste = new JList<T>(model);

	/**************** Les champs ***************/

	protected JPanel fieldsPanel = new JPanel(new GridLayout(2, 2));
	protected JLabel firstFieldLabel;
	protected JTextField firstField = new JTextField(30);

	protected JLabel secondFieldLabel;
	protected JTextField secondField = new JTextField(30);

	/**************** Les boutons ***************/

	protected JPanel buttonPanel = new JPanel(new FlowLayout());
	protected JButton addButton = new JButton("Ajouter");
	protected JButton deleteButton = new JButton("Supprimer");
	protected JButton clearButton = new JButton("Clear");

	public ManagedListPanel(String listText, String firstLabelText, String secondLabelText) {
		setLayout(new GridLayout(3, 1));

		/**************** La liste ***************/
		listPanel = new JPanel(new GridLayout(1, 1));

		listPanel.setBorder(BorderFactory.createTitledBorder(listText));

		listPanel.add(laliste);

		/**************** Les champs ***************/
		fieldsPanel = new JPanel(new GridLayout(2, 2));
		firstFieldLabel = new JLabel(firstLabelText + " : ");
		secondFieldLabel = new JLabel(secondLabelText + " : ");

		fieldsPanel.add(firstFieldLabel);
		fieldsPanel.add(firstField);

		fieldsPanel.add(secondFieldLabel);
		fieldsPanel.add(secondField);

		/**************** Les boutons ***************/
		buttonPanel = new JPanel(new FlowLayout());

		addButton.addActionListener(this);
		deleteButton.addActionListener(this);
		clearButton.addActionListener(this);

		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(clearButton);

		add(listPanel);
		add(fieldsPanel);
		add(buttonPanel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {
			firstField.setText("");
			secondField.setText("");
		}
	}

	public abstract void valueChanged(ListSelectionEvent e);

	public JList<T> getJList() {
		return laliste;
	}

	public DefaultListModel<T> getModel() {
		return model;
	}
}
