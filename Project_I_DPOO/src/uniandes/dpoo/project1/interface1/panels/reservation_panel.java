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

public class reservation_panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	app mysubcontroller;
	private static final long serialVersionUID = 1L;
	JPanel listPanel;
	JPanel listPanel3;
	JComboBox<Object> comboBoxyear;
	JComboBox<Object> comboBoxmonths;
	JComboBox<Integer> comboBoxDays1;
	JComboBox<Integer> comboBoxDays2;
	JComboBox<Object> comboBoxyear3;
	JComboBox<Object> comboBoxmonths3;
	Integer selected_year;
	Integer selected_year2;
	Integer selected_month;
	Integer selected_month2;
	Integer selected_day_1;
	Integer selected_day_2;
	//constructor
	public reservation_panel(app mycontroller) {
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
		JPanel reservationPanel = new JPanel(new BorderLayout());
		JLabel reservation_label = new JLabel();
		reservationPanel.setLayout(new BorderLayout());
		reservationPanel.setBounds(15, 15, 570, 125);
		reservationPanel.add(reservation_label, BorderLayout.CENTER);
		
		//border for the reservation panel
		//reservationPanel.setBorder(compoundBorderdropdownlist);
		
		reservationPanel.setBackground(Color.black);
		reservationPanel.setOpaque(true);
		reservation_label.setLayout(null);
		// setting text to the jpane in order to choose option
		reservation_label.setText("<html> <b>Introducing dates for the reservation... </b>"
				+ "<br> -> Please introduce in the drop down lists the year, month and day for"
				+ " your booking!</html>");
		reservation_label.setHorizontalTextPosition(JLabel.CENTER); //horizontal position of the text in the label
		reservation_label.setVerticalTextPosition(JLabel.CENTER); //vertical position of the text in the label
		reservation_label.setHorizontalAlignment(JLabel.CENTER);
		reservation_label.setForeground(Color.CYAN); //set color for the letters
		reservation_label.setFont(new Font("MV Boli", Font.PLAIN, 15));
		reservation_label.setBounds(55, 50, 250, 125);
		reservationPanel.add(reservation_label, BorderLayout.CENTER);
		
		//add drop down list to the subpanel
		listPanel = new JPanel();
		//combo box for years
		Integer[] years = {2023, 2024};
		comboBoxyear = new JComboBox<Object>(years);
		comboBoxyear.addActionListener(this);
		//combo box for months
		String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec"};
		comboBoxmonths = new JComboBox<Object>(months);
		comboBoxmonths.addActionListener(this);
		
		listPanel.setBackground(Color.black);
		listPanel.setOpaque(true);
		listPanel.add(comboBoxyear);
		listPanel.add(comboBoxmonths);
		
		reservationPanel.add(listPanel, BorderLayout.SOUTH);
		
		// New code for second date selection in reservation
        JLabel secondDateLabel = new JLabel();
        JPanel secondDatePanel = new JPanel(new BorderLayout());
        secondDatePanel.setBounds(15, 280, 250, 125);
        secondDatePanel.add(secondDateLabel, BorderLayout.CENTER);

        //secondDatePanel.setBorder(compoundBorderdropdownlist);

        secondDatePanel.setBackground(Color.black);
        secondDatePanel.setOpaque(true);
        secondDateLabel.setLayout(null);

        secondDateLabel.setText("<html> <b>Introducing the final day of your reservation... </b>"
                + "<br> -> Please introduce in the drop-down lists the year, month, and day for"
                + " the end of your booking!</html>");
        secondDateLabel.setHorizontalTextPosition(JLabel.CENTER);
        secondDateLabel.setVerticalTextPosition(JLabel.CENTER);
        secondDateLabel.setHorizontalAlignment(JLabel.CENTER);
        secondDateLabel.setForeground(Color.CYAN);
        secondDateLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        secondDateLabel.setBounds(55, 50, 250, 125);
        secondDatePanel.add(secondDateLabel, BorderLayout.CENTER);

        listPanel3 = new JPanel();
        comboBoxyear3 = new JComboBox<Object>(years);
        comboBoxyear3.addActionListener(this);
        comboBoxmonths3 = new JComboBox<Object>(months);
        comboBoxmonths3.addActionListener(this);

        listPanel3.setBackground(Color.black);
        listPanel3.setOpaque(true);
        listPanel3.add(comboBoxyear3);
        listPanel3.add(comboBoxmonths3);
        secondDatePanel.add(listPanel3, BorderLayout.SOUTH) ;
		
        this.setVisible(false);
        //add to main cancellation panel
        this.add(reservationPanel, BorderLayout.NORTH);
        this.add(secondDatePanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {if(e.getSource() == comboBoxyear) {
		selected_year = (Integer) comboBoxyear.getSelectedItem();
	}
	if(e.getSource() == comboBoxyear3) {
		selected_year2 = (Integer) comboBoxyear3.getSelectedItem();
	}
	if (e.getSource() == comboBoxmonths) {
        selected_month = comboBoxmonths.getSelectedIndex();
        Integer num_days = mysubcontroller.numdays_per_month(selected_month);

        // Remove the previous JComboBox if it exists
        if (comboBoxDays1 != null) {
            listPanel.remove(comboBoxDays1);
        }

        List<Integer> days = mysubcontroller.listdays(num_days);
        comboBoxDays1 = new JComboBox<>(days.toArray(new Integer[0]));

        // Add the new JComboBox to the listPanel
        listPanel.add(comboBoxDays1);

        // Update the panel
        listPanel.revalidate();
        listPanel.repaint();
    }
	if(e.getSource() == comboBoxmonths3) {
		selected_month2 = comboBoxmonths3.getSelectedIndex();
        Integer num_days = mysubcontroller.numdays_per_month(selected_month2);

        // Remove the previous JComboBox if it exists
        if (comboBoxDays2 != null) {
        	listPanel3.remove(comboBoxDays2);
        }

        List<Integer> days = mysubcontroller.listdays(num_days);
        comboBoxDays2 = new JComboBox<>(days.toArray(new Integer[0]));

        // Add the new JComboBox to the listPanel
        listPanel3.add(comboBoxDays2);

        // Update the panel
        listPanel3.revalidate();
        listPanel3.repaint();
		}
	if(e.getSource() == comboBoxDays1) {
		selected_day_1 = comboBoxDays1.getSelectedIndex();
	}
	if(e.getSource() == comboBoxDays2) {
		selected_day_2 = comboBoxDays2.getSelectedIndex();
	}
	}
	
	public Integer getFirstYear() {
		return selected_year;
	}
	public Integer getSecondYear() {
		return selected_year;
	}
	public Integer getFirstMonth() {
		return selected_month;
	}
	public Integer getSecondMonth() {
		return selected_month2;
	}
	public Integer getFirstDay() {
		return selected_day_1;
	}
	public Integer getSecondDay() {
		return selected_day_2;
	}
}
