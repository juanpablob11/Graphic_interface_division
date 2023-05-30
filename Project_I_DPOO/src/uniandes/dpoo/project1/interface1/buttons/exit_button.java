package uniandes.dpoo.project1.interface1.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class exit_button extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public exit_button(String message) {
		this.setText(message);
		this.setBounds(400, 450, 200, 40);
		this.setFocusable(false);
		this.setFont(new Font("Comic Sans", Font.BOLD, 12));
		this.setBackground(Color.black);
		this.setForeground(Color.cyan);
		Border outerborderbutton = BorderFactory.createLineBorder(Color.CYAN, 2);
		Border innerborderbutton = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorderbutton = BorderFactory.createCompoundBorder(outerborderbutton, innerborderbutton);
		this.setBorder(compoundBorderbutton);
	}
}
