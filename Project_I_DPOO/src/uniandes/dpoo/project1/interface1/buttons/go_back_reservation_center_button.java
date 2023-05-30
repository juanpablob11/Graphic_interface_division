package uniandes.dpoo.project1.interface1.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class go_back_reservation_center_button extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public go_back_reservation_center_button() {
		this.setText("Go back to Reservation Center");
		this.setBounds(400, 450, 220, 40);
		this.setFocusable(false);
		this.setFont(new Font("Comic Sans", Font.BOLD, 12));
		this.setBackground(Color.black);
		this.setForeground(Color.cyan);
		Border outerborderbutton1 = BorderFactory.createLineBorder(Color.CYAN, 2);
		Border innerborderbutton1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorderbutton1 = BorderFactory.createCompoundBorder(outerborderbutton1, innerborderbutton1);
		this.setBorder(compoundBorderbutton1);
		this.setVisible(false);
	}
}
