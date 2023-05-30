package uniandes.dpoo.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	//Attributes
	String initialDate;
	String finalDate;
	String guestName;
	int reservationId;
	String guestMail;
	String guestPhone;
	List<Room> guestRooms = new ArrayList<>();
	//constructor
	public Booking(String initialDate, String finalDate, String guestName, String guestMail,
			String guestPhone, int reservationId) {
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.guestName = guestName;
		this.guestMail = guestMail;
		this.guestPhone = guestPhone;
		this.reservationId = reservationId;
	}
	//methods 
	//setters
	public void setRoom(Room newroom) {
		guestRooms.add(newroom);
	}
	//getters
	public List<Room> getRooms(){
		return guestRooms;
	}
	public int getId() {
		return reservationId;
	}
}
