package uniandes.dpoo.project1.interface1.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.project1.interface1.app;
import uniandes.dpoo.project1.interface1.buttons.exit_button;
import uniandes.dpoo.project1.interface1.labels.info_label_subReservation;

public class sub_reservation_panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	app mysubcontroller;
	//buttons
		//balcony
			JRadioButton balcony_true_button;
			JRadioButton balcony_false_button;
		//room type
			JRadioButton room_type_standar;
			JRadioButton room_type_suite;
			JRadioButton room_type_double_suite;
		//kitchen
			JRadioButton kitchen_true_button;
			JRadioButton kitchen_false_button;
		//view
			JRadioButton view_true_button;
			JRadioButton view_false_button;
		//bed type
			JComboBox<Object> comboBoxBedtype;
			JComboBox<Object> comboBoxroom_type;
		//choosing number of beds
			JComboBox<Object> comboBoxBeds;
	public sub_reservation_panel(app mycontroller) {
		mysubcontroller = mycontroller;
		
		//setting this panel characteristics
				//special border
					Border outerborderdropdownlist = BorderFactory.createLineBorder(Color.CYAN, 2);
					Border innerborderdropdownlist = BorderFactory.createEmptyBorder(10, 10, 10, 10);
					Border compoundBorderdropdownlist = BorderFactory.createCompoundBorder(outerborderdropdownlist, innerborderdropdownlist);
			this.setBorder(compoundBorderdropdownlist);
			this.setBounds(45, 75, 700, 360);
			this.setBackground(Color.black);
		
			//label for text to indicate instructions
			info_label_subReservation instructions_label = new info_label_subReservation();
			
		//Sub Panels for buttons for room characteristics
			//Radio buttons for balcony statements
				balcony_true_button = new JRadioButton();
				balcony_true_button.setFocusable(false);
				balcony_false_button = new JRadioButton();
				balcony_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup balcony_group = new ButtonGroup();
					balcony_group.add(balcony_true_button);
					balcony_group.add(balcony_false_button);
				//add action listener to the buttons
					balcony_true_button.addActionListener(this);
					balcony_false_button.addActionListener(this);
					
			//Radio buttons for choosing room type
					String [] room_type_group = {"Estandár", "Suite", "individual", "Suite doble"};
					comboBoxroom_type = new JComboBox<Object>(room_type_group);
					comboBoxroom_type.addActionListener(this);
					
			//Radio buttons for choosing bed type
					String [] bed_types = {"king", "queen", "individual", "doble"};
					comboBoxBedtype = new JComboBox<Object>(bed_types);
					comboBoxBedtype.addActionListener(this);
					
			//Radio buttons for kitchen
				kitchen_true_button = new JRadioButton();
				kitchen_true_button.setFocusable(false);
				kitchen_false_button = new JRadioButton();
				kitchen_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup kitchen_group = new ButtonGroup();
					kitchen_group.add(kitchen_true_button);
					kitchen_group.add(kitchen_false_button);
				//add action listener to the buttons
					kitchen_true_button.addActionListener(this);
					kitchen_false_button.addActionListener(this);
					
			//Radio buttons for choosing view
				view_true_button = new JRadioButton();
				view_true_button.setFocusable(false);
				view_false_button = new JRadioButton();
				view_false_button.setFocusable(false);
				//Groupby buttons to choose only one
					ButtonGroup view_group = new ButtonGroup();
					view_group.add(view_true_button);
					view_group.add(view_false_button);
				//add action listener to the buttons
					view_true_button.addActionListener(this);
					view_false_button.addActionListener(this);
				
			//getting the minimum and maxim number of beds per rooms to filter 
				int min_integer = mysubcontroller.min_beds_per_rooms();
				int max_integer = mysubcontroller.max_beds_per_rooms();
				Integer[] numbersArray = new Integer[max_integer - min_integer + 1];
			    for (int i = min_integer; i <= max_integer; i++) {
			          numbersArray[i - min_integer] = i;
			      }
			//combo box for choosing number of beds
				comboBoxBeds= new JComboBox<Object>(numbersArray);
				comboBoxBeds.addActionListener(this);
			
			//add icon to the buttons
				// resize reservation icon
				ImageIcon confirmation_icon = new ImageIcon("data/images/check.png");
				Image confirmation_image = confirmation_icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				confirmation_icon = new ImageIcon(confirmation_image);

				// resize cancellation icon
				ImageIcon cancelation_icon = new ImageIcon("data/images/x.png");
				Image cancelation_image = cancelation_icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
				cancelation_icon = new ImageIcon(cancelation_image);

				// set icons for JRadioButtons
				balcony_true_button.setIcon(confirmation_icon);
				balcony_false_button.setIcon(cancelation_icon);	
				
				kitchen_true_button.setIcon(confirmation_icon);
				kitchen_false_button.setIcon(cancelation_icon);	
				
				view_true_button.setIcon(confirmation_icon);
				view_false_button.setIcon(cancelation_icon);	
				//1st row panel
					JPanel first_row_panel = new JPanel(new BorderLayout());
					first_row_panel.setBounds(45, 170, 600, 50);
		//sub panels holders for button groups
			//balcony holder
					String balcony_holder_str = "<html> Do you want <b><u>balcony?</u> </b></html>";
					SubReservation_generic_holder balcony_holder = new SubReservation_generic_holder(balcony_true_button, 
							balcony_false_button, balcony_holder_str);
							
			//kitchen holder	
					String kitchen_holder_str = "<html> Do you want <b><u>kitchen?</u> </b></html>";
					SubReservation_generic_holder kitchen_holder = new SubReservation_generic_holder(kitchen_true_button,
							kitchen_false_button, kitchen_holder_str);
							
			//view_holder
					String view_holder_str = "<html> Do you want <b><u>view?</u> </b></html>";
					SubReservation_generic_holder view_holder = new SubReservation_generic_holder(view_true_button,
							view_false_button, view_holder_str);

				//adding holders to first row panel
					first_row_panel.add(balcony_holder, BorderLayout.EAST);
					first_row_panel.add(kitchen_holder, BorderLayout.CENTER);
					first_row_panel.add(view_holder, BorderLayout.WEST);
					
				//2nd row panel
					JPanel second_row_panel = new JPanel(new BorderLayout());
					second_row_panel.setBounds(0,0,150,150);
					second_row_panel.setBackground(Color.black);
				//room type holder
					String room_type_holder_str = "<html> Please introduce the <b><u>room type</u> </b></html>";
					SubReservation_generic_holder2 room_type_holder = new SubReservation_generic_holder2(room_type_holder_str,
							comboBoxroom_type);
				//number beds holder
					String num_beds_holder_str = "<html> Please introduce the <b><u># of beds</u> </b></html>";
					SubReservation_generic_holder2 num_beds_holder = new SubReservation_generic_holder2(num_beds_holder_str,
							comboBoxBeds);
				//beds type holder
					String beds_type_holder_str = "<html> Please introduce the <b><u>bed type</u> </b></html>";
					SubReservation_generic_holder2 beds_type_holder = new SubReservation_generic_holder2(beds_type_holder_str,
							comboBoxBedtype);
					beds_type_holder.setBorder(new EmptyBorder(10, 0, 15, 0));
				//adding holders to second row panel
					second_row_panel.add(room_type_holder, BorderLayout.EAST);
					second_row_panel.add(num_beds_holder, BorderLayout.WEST);
					//second_row_panel.add(beds_type_holder, BorderLayout.SOUTH);
			String message_to_capture = "Show me the available rooms";
			exit_button capture_info = new exit_button(message_to_capture);
			capture_info.setBounds(400, 300, 200, 40);
			
			JPanel subpanel = new JPanel(new BorderLayout());
			subpanel.add(capture_info, BorderLayout.SOUTH);
			subpanel.add(beds_type_holder, BorderLayout.NORTH);
		this.setVisible(false);
		//adding components to the panel	
			this.add(instructions_label);
			this.add(first_row_panel);
			this.add(second_row_panel);
			//this.add(beds_type_holder);
			//this.add(capture_info);
			this.add(subpanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view_true_button) {
			System.out.println("view_true_button");
		}
		if(e.getSource() == view_false_button) {
			System.out.println("view_false_button");
		}
		if(e.getSource() == kitchen_true_button) {
			System.out.println("kitchen_true_button");
		}
		if(e.getSource() == kitchen_false_button) {
			System.out.println("kitchen_false_button");
		}
		if(e.getSource() == balcony_true_button) {
			System.out.println("balcony_true_button");
		}
		if(e.getSource() == balcony_false_button) {
			System.out.println("balcony_false_button");
		}
	}
}
