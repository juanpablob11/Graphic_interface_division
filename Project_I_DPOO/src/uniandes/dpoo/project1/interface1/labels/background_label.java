package uniandes.dpoo.project1.interface1.labels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class background_label extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public background_label() {
		//Label for background picture
		ImageIcon backpic = new ImageIcon("data/images/reservation_background.jpg");
		this.setIcon(backpic);
		this.setBounds(0, 50, 1000, 650);
	}
}
