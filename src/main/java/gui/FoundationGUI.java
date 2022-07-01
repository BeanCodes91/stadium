package gui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class FoundationGUI {

	private JButton nextButton;
	private JFrame frame;
	private Dimension dim;
	
	public FoundationGUI() {
		
		JFrame frame = new JFrame();
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setLayout(new FlowLayout());
		
		frame.add(new StartPanel());
		frame.add(new BlockChoicePanel());
		
		nextButton = new JButton("Suchen");
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dim.width/2, dim.height/2);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Ticketbuchungs-System");
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {

		new FoundationGUI();

	}

}