package gui;

import java.awt.GridBagLayout;

import javax.swing.*;

public class ChoicePanel extends JPanel{

	private JComboBox<String>	eventChoice, standChoice;
	private JRadioButton 		sitting, standing;
	private JTextField 			amountSeats;
	
	public ChoicePanel() {
		
		// Initialization
		eventChoice = new JComboBox<String>();
		amountSeats = new JTextField(3);
		sitting = new JRadioButton("Sitzplatz");
		standing = new JRadioButton("Stehplatz");
		ButtonGroup seatType = new ButtonGroup();
		this.setLayout(new GridBagLayout());
		
		// Assemble ButtonGroup
		seatType.add(sitting);
		seatType.add(standing);
		
//		this.add(new JLabel("test"));
	}
}
