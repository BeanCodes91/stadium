package gui;

import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;

import java.awt.*;

/**
 * This class provides the frame for the GUI panels, as well as a JPanel with CardLayout to switch through the GUIs.
 * 
 * @author Melanie Knorn
 *
 */
public class FoundationGUI {

	private JFrame 				frame;
	private JPanel 				cardPanel;
	private JButton 			nextButton;
	private Dimension 			dim;
	private CardLayout			cl;
	private GridBagConstraints 	gbc_cardPanel, gbc_nextButton;
	private int 				frameWidth, frameHeight;
	
	public FoundationGUI() {
		
		// Initialization
		frame			= new JFrame();
		cardPanel		= new JPanel(new CardLayout());
		gbc_cardPanel	= new GridBagConstraints();
		gbc_nextButton	= new GridBagConstraints();
		dim 			= Toolkit.getDefaultToolkit().getScreenSize();
		cl = (CardLayout)(cardPanel.getLayout());
		frameWidth		= dim.width/2;
		frameHeight		= dim.height/2;
		
		// Set GridBagConstraints for both
		gbc_cardPanel.gridx		= 0;
		gbc_cardPanel.fill		= GridBagConstraints.HORIZONTAL;
		
		// Set GridBagConstraints for cardPanel
		gbc_cardPanel.gridy 	= 0;
		gbc_cardPanel.anchor	= GridBagConstraints.FIRST_LINE_START;
		gbc_cardPanel.weighty	= frameHeight/4*3;
		gbc_cardPanel.insets	= new Insets(0, 10, 0, 10);
		
		// Set GridBagConstraints for nextButton
		gbc_nextButton.gridy 	= 1;
		gbc_nextButton.anchor 	= GridBagConstraints.PAGE_END;
		gbc_nextButton.insets	= new Insets(20, 10, 20, 10);
		
		// Assemble cardPanel
		cardPanel.add(new StartPanel());
		cardPanel.add(new BlockChoicePanel());
		
		// Assemble nextButton
		nextButton = new JButton("Weiter");
		nextButton.addActionListener(e -> cl.next(cardPanel));
		
		// Assemble frame
		frame.setLayout(new GridBagLayout());
		frame.add(cardPanel, gbc_cardPanel);
		frame.add(nextButton, gbc_nextButton);
		
		// frame details
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Ticketbuchungs-System");
		frame.setVisible(true);
	}
	
	/**
	 * Returns the width of the frame.
	 * 
	 * @return	frameWidth	Half the width of the screen
	 */
	public int getFrameWidth() {
		return frameWidth;
	}

	/**
	 * Returns the height of the frame.
	 * 
	 * @return	frameHeight	Half the height of the screen.
	 */
	public int getFrameHeight() {
		return frameHeight;
	}

	public static void main(String[] args) {new FoundationGUI();}

}