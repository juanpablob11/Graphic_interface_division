package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import uniandes.dpoo.project1.interface1.app;

public class cancelation_panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	app mysubcontroller;
	private static final long serialVersionUID = 1L;
	JPanel listPanel2;
	JPanel listPanel4;
	JComboBox<Object> comboBoxyear2;
	JComboBox<Object> comboBoxmonths2;
	JComboBox<Integer> comboBoxDays;
	JComboBox<Object> comboBoxyear4;
	JComboBox<Object> comboBoxmonths4;
	
	//constructor
	public cancelation_panel(app mycontroller) {
		mysubcontroller = mycontroller;
		Border outerborderdropdownlist = BorderFactory.createLineBorder(Color.CYAN, 2);
		Border innerborderdropdownlist = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorderdropdownlist = BorderFactory.createCompoundBorder(outerborderdropdownlist, innerborderdropdownlist);
		//Big Panel that serves as a border
		this.setLayout(new BorderLayout());
		this.setBorder(compoundBorderdropdownlist);
		this.setBounds(45, 75, 600, 265);
		this.setBackground(Color.black);
		//1st cancellation panel
		JPanel cancelation_panel1 = new JPanel(new BorderLayout());
		JLabel cancelation_label = new JLabel();
		cancelation_panel1.setLayout(new BorderLayout());
		cancelation_panel1.setBounds(15, 15, 570, 125);
		cancelation_panel1.add(cancelation_label, BorderLayout.CENTER);
		
		//border for the reservation panel
		//cancelation_panel1.setBorder(compoundBorderdropdownlist);
		
		cancelation_panel1.setBackground(Color.black);
		cancelation_panel1.setOpaque(true);
		cancelation_label.setLayout(null);
		// setting text to the jpane in order to choose option
		cancelation_label.setText("<html> <b>Introducing dates for the cancelation... </b>"
				+ "<br> -> Please introduce in the drop down lists the year, month and day for"
				+ " your cancelation!</html>");
		cancelation_label.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		cancelation_label.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		cancelation_label.setHorizontalAlignment(JLabel.CENTER);
		cancelation_label.setForeground(Color.CYAN); //set color for the letters
		cancelation_label.setFont(new Font("MV Boli", Font.PLAIN, 15));
		cancelation_label.setBounds(55, 50, 250, 125);
		cancelation_panel1.add(cancelation_label, BorderLayout.CENTER);
		
		//add drop down list to the subpanel
		listPanel2 = new JPanel();
		//combo box for years
		Integer[] years = {2023, 2024};
		comboBoxyear2 = new JComboBox<Object>(years);
		comboBoxyear2.addActionListener(this);
		//combo box for months
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec"};
		comboBoxmonths2 = new JComboBox<Object>(months);
		comboBoxmonths2.addActionListener(this);
		
		listPanel2.setBackground(Color.black);
		listPanel2.setOpaque(true);
		listPanel2.add(comboBoxyear2);
		listPanel2.add(comboBoxmonths2);
		
		cancelation_panel1.add(listPanel2, BorderLayout.SOUTH);
		
		// New code for second date cancellation panel
        JLabel secondDateLabel2 = new JLabel();
        JPanel cancellation_panel2 = new JPanel(new BorderLayout());
        cancellation_panel2.setBounds(15, 280, 250, 125);
        cancellation_panel2.add(secondDateLabel2, BorderLayout.CENTER);

        //cancellation_panel2.setBorder(compoundBorderdropdownlist);

        cancellation_panel2.setBackground(Color.black);
        cancellation_panel2.setOpaque(true);
        secondDateLabel2.setLayout(null);

        secondDateLabel2.setText("<html> <b>Introducing the final day of your reservation to cancelate... </b>"
                + "<br> -> Please introduce in the drop-down lists the year, month, and day for"
                + " the end of your cancellation of reservation!</html>");
        secondDateLabel2.setHorizontalTextPosition(JLabel.CENTER);
        secondDateLabel2.setVerticalTextPosition(JLabel.CENTER);
        secondDateLabel2.setHorizontalAlignment(JLabel.CENTER);
        secondDateLabel2.setForeground(Color.CYAN);
        secondDateLabel2.setFont(new Font("MV Boli", Font.PLAIN, 15));
        secondDateLabel2.setBounds(55, 50, 250, 125);
        cancellation_panel2.add(secondDateLabel2, BorderLayout.CENTER);

        listPanel4 = new JPanel();
        comboBoxyear4 = new JComboBox<Object>(years);
        comboBoxyear4.addActionListener(this);
        comboBoxmonths4 = new JComboBox<Object>(months);
        comboBoxmonths4.addActionListener(this);

        listPanel4.setBackground(Color.black);
        listPanel4.setOpaque(true);
        listPanel4.add(comboBoxyear4);
        listPanel4.add(comboBoxmonths4);
        cancellation_panel2.add(listPanel4, BorderLayout.SOUTH) ;
		
        this.setVisible(false);
        //add to main cancellation panel
        this.add(cancelation_panel1, BorderLayout.NORTH);
        this.add(cancellation_panel2, BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == comboBoxmonths2) {
            Integer selected_month = comboBoxmonths2.getSelectedIndex();
            Integer num_days = mysubcontroller.numdays_per_month(selected_month);

            // Remove the previous JComboBox if it exists
            if (comboBoxDays != null) {
            	listPanel2.remove(comboBoxDays);
            }

            List<Integer> days = mysubcontroller.listdays(num_days);
            comboBoxDays = new JComboBox<>(days.toArray(new Integer[0]));

            // Add the new JComboBox to the listPanel
            listPanel2.add(comboBoxDays);

            // Update the panel
            listPanel2.revalidate();
            listPanel2.repaint();
        }
		if(e.getSource() == comboBoxmonths4) {
			Integer selected_month = comboBoxmonths4.getSelectedIndex();
            Integer num_days = mysubcontroller.numdays_per_month(selected_month);

            // Remove the previous JComboBox if it exists
            if (comboBoxDays != null) {
            	listPanel4.remove(comboBoxDays);
            }

            List<Integer> days = mysubcontroller.listdays(num_days);
            comboBoxDays = new JComboBox<>(days.toArray(new Integer[0]));

            // Add the new JComboBox to the listPanel
            listPanel4.add(comboBoxDays);

            // Update the panel
            listPanel4.revalidate();
            listPanel4.repaint();
		}
		
	}
}
