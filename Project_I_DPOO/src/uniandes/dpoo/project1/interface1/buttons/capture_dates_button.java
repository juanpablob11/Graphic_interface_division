package uniandes.dpoo.project1.interface1.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class capture_dates_button extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public capture_dates_button() {
		this.setText("Continue with the process of reservation");
		this.setBounds(80, 450, 260, 40);
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
