package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class button_panel_holder extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public button_panel_holder(JPanel buttonPanel) {
		//creating a this to add buttons and then add the this to the layeredPane
		//creating a label to write text in the upper part   
			JLabel initial_buttons = new JLabel();
			this.setLayout(new BorderLayout());
			this.setBounds(200, 240, 300, 125);
			this.add(initial_buttons, BorderLayout.CENTER);
			Border label_button_Border = BorderFactory.createLineBorder(Color.CYAN, 2);
			this.setBorder(label_button_Border);
			this.setBackground(Color.black);
			this.setOpaque(true);
			initial_buttons.setLayout(null);
			// setting text to the jpane in order to choose option
				initial_buttons.setText("-> Please choose an option!");
				initial_buttons.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
				initial_buttons.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
				initial_buttons.setHorizontalAlignment(JLabel.CENTER);
				initial_buttons.setForeground(Color.CYAN); //set color for the letters
				initial_buttons.setFont(new Font("MV Boli", Font.PLAIN, 18));
				initial_buttons.setBounds(75, 260, 250, 125);
			
				//add buttons to the panel
				this.add(buttonPanel, BorderLayout.SOUTH);
	}
}
