package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class StartPanel extends JPanel {

	private JPanel eventListPanel, centerPanel, buttonPanel, seatPanel;
	private JComboBox<String> eventChoice, standChoice;
	private JRadioButton sitting, standing;
	private JTextField amountSeats;
	private JButton startButton;
	
	public StartPanel() {
		
		this.setLayout(new BorderLayout());
		this.add(new StadiumPanel(), 	BorderLayout.NORTH);
		this.add(eventView(), 			BorderLayout.WEST);
		this.add(choiceView(), 			BorderLayout.CENTER);
		this.add(new PriceListPanel(), 	BorderLayout.EAST);
		
	}
	
	private JPanel eventView() {
		
		eventListPanel = new JPanel();
		
		return eventListPanel;
	}
	
	private JPanel choiceView() {
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		
		eventChoice = new JComboBox<String>();
		
		seatPanel = new JPanel();
		seatPanel.setLayout(new BoxLayout(seatPanel, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,2));
		
		amountSeats = new JTextField(3);
		
		sitting = new JRadioButton("Sitzplatz");
		standing = new JRadioButton("Stehplatz");
		ButtonGroup seatType = new ButtonGroup();
		seatType.add(sitting);
		seatType.add(standing);
		
		buttonPanel.add(sitting);
		buttonPanel.add(amountSeats);
		buttonPanel.add(standing);
		
		standChoice = new JComboBox<String>();
		
		seatPanel.add(buttonPanel);
		seatPanel.add(standChoice);
		
		centerPanel.add(eventChoice);
		centerPanel.add(seatPanel);
		
		return centerPanel;
	}
	

}