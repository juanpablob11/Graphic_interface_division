package uniandes.dpoo.project1.interface1.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class info_label extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public info_label() {
		//adding label to write instructions and info for reservation
		//outer border
		Border this_border = BorderFactory.createLineBorder(Color.CYAN, 2);
		//inner border
		Border innerborder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorder = BorderFactory.createCompoundBorder(this_border, innerborder);
		this.setBorder(compoundBorder);
		//set background characteristics
		this.setBackground(Color.black);
		this.setOpaque(true);
		// setting text to the pane in order to choose option
		this.setText("<html> In order to use the reservation center you´ve to choose between "
				+ " the options <br>in the next box, the <b>reserved picture</b> will send you to the booking "
				+ "<br> process and the <b>cancelled picture</b> will send you to the booking cancellation process.</html>");
		this.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		this.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.CYAN); //set color for the letters
		this.setFont(new Font("MV Boli", Font.PLAIN, 15));
		this.setBounds(55, 85, 570, 125);
	}
}
