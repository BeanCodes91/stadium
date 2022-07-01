package gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class BlockChoicePanel extends JPanel {

	private JPanel bottomHalf, standChoice;
	
	public BlockChoicePanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new StadiumPanel());
	}
	
	private JPanel bottomView() {
		
		bottomHalf = new JPanel();
		bottomHalf.setLayout(new FlowLayout());
		
		standChoice = new JPanel();
		standChoice.setLayout(new GridLayout(2,2));
		
		bottomHalf.add(standChoice);
		bottomHalf.add(new PriceListPanel());
		
		return bottomHalf;
	}
}
