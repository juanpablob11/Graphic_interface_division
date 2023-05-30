package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SubReservation_generic_holder extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel generic_label;
	public SubReservation_generic_holder(JRadioButton generic_true_button,
			JRadioButton generic_false_button, String generic_holder_str) {
		this.setBounds(400,10,100,40);
		this.setBackground(Color.black);
		generic_label = new JLabel();
		//set background characteristics
		generic_label.setBackground(Color.black);
		generic_label.setOpaque(true);
		// setting text to the pane in order to choose option
		generic_label.setText(generic_holder_str);
		generic_label.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		generic_label.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		generic_label.setHorizontalAlignment(JLabel.CENTER);
		generic_label.setForeground(Color.CYAN); //set color for the letters
		generic_label.setFont(new Font("MV Boli", Font.PLAIN, 13));
		generic_label.setBounds(5, 5, 100, 35);
		
		//adding buttons to the holders
		// Move the buttons to the east side of the sub-label holders
			this.add(generic_label, BorderLayout.WEST);
			this.add(generic_true_button, BorderLayout.EAST);
			this.add(generic_false_button, BorderLayout.EAST);
	}
}

