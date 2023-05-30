package uniandes.dpoo.project1.interface1.labels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class upper_label extends JLabel  implements ActionListener{
		public upper_label() {
		//Label for upper part
		this.setText("Reservation center");
		this.setHorizontalTextPosition(JLabel.LEFT); //horizontal position of the text in the label
		this.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		//Align stuff inside the JLabel
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setForeground(Color.CYAN); //set color for the letters
		this.setFont(new Font("MV Boli", Font.PLAIN, 25));
		//background color for JLabel
		this.setBackground(Color.black);
		this.setOpaque(true);
		//add border to the JLabel
		Border labelBorder = BorderFactory.createLineBorder(Color.CYAN, 2);
		this.setBorder(labelBorder);
		//x,y positions and dimensions of JLabel
		this.setLayout(null);
		this.setBounds(0, 0, 1000, 50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
