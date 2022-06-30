package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class stadiumFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stadiumFrame frame = new stadiumFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stadiumFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel CardPanel = new JPanel();
		GridBagConstraints gbc_CardPanel = new GridBagConstraints();
		gbc_CardPanel.gridheight = 8;
		gbc_CardPanel.insets = new Insets(0, 0, 5, 0);
		gbc_CardPanel.gridwidth = 9;
		gbc_CardPanel.anchor = GridBagConstraints.WEST;
		gbc_CardPanel.fill = GridBagConstraints.VERTICAL;
		gbc_CardPanel.gridx = 0;
		gbc_CardPanel.gridy = 0;
		contentPane.add(CardPanel, gbc_CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
		
		JButton ctrlButton = new JButton("Weiter");
		ctrlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_ctrlButton = new GridBagConstraints();
		gbc_ctrlButton.insets = new Insets(0, 0, 0, 5);
		gbc_ctrlButton.gridx = 2;
		gbc_ctrlButton.gridy = 8;
		contentPane.add(ctrlButton, gbc_ctrlButton);
	}

}
