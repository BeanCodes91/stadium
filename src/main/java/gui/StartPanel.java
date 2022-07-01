package gui;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class StartPanel extends JPanel {

	private GridBagConstraints 	gbc_stadiumPanel, gbc_choicePanel, gbc_pricePanel;
	
	public StartPanel() {
		
		this.setLayout(new GridBagLayout());
		this.add(new StadiumPanel(), 	gbc_stadiumPanel);
		this.add(new ChoicePanel(), 	gbc_choicePanel);
		this.add(new PriceListPanel(), 	gbc_pricePanel);
		
	}
}