package uniandes.dpoo.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Guest {
	//Attributes
	String id;
	int fee;
	String GuestName;
	List<Services> listServices = new ArrayList<>();
	public Guest(String id, String GuestName) {
		this.id = id;
		this.GuestName = GuestName;
	}
	//methods
	//setters
	public void addServiceConsumed() {
		//TO DO
	} // end addServiceConsumed
	public void addFee() {
		//TO DO
	} //end addFee
	//getters
	public List<Services> getListServices(){
		return listServices;
	}
} //end Class
