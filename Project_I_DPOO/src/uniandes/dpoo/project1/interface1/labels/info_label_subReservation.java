package uniandes.dpoo.project1.interface1.labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class info_label_subReservation extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public info_label_subReservation() {
		//label for text to indicate instructions
		//set background characteristics
		this.setBackground(Color.black);
		this.setOpaque(true);
		// setting text to the pane in order to choose option
		this.setText("<html> Now, as the <b><u>dates have been alredy chosen</u></b> you´ll have to"
				+ " add the next info required to<br> filter by all the rooms of the hotel."
				+ "<br>The next buttons and boxes have the <b><u>filters</u></b>  to search the room expected. "
				+ "<br> Once you finish the process <b><u>please click the next step button</u></b> in order to show"
				+ "<br> you the rooms available that fit for your <b><u>characteristics and needs</u></b>.</html>");
		this.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		this.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.CYAN); //set color for the letters
		this.setFont(new Font("MV Boli", Font.PLAIN, 15));
		this.setBounds(45, 45, 570, 125);
	}
}
