package uniandes.dpoo.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
	//Attributes
	private int id;
	private int fee;
	private String type;
	private int capacity;
	private List<Bed> listBeds;
	private boolean view;
	private boolean kitchen;
	private boolean balcony;
	private List<Guest> listGuests = new ArrayList<>();
	private int auxroominitial;
	private int auxroomfinal;
	
	//constructor
	public Room(int id, String type, int capacity, List<Bed> listBeds, boolean view,
			boolean kitchen, boolean balcony) {
		this.id = id;
		this.type = type;
		this.capacity = capacity;
		this.listBeds = listBeds;
		this.view = view;
		this.kitchen = kitchen;
		this.balcony = balcony;
	}
	
	//setters
	public void addFee() {
		//TO DO
	}
	public void addGuest(Guest newguest) {
		listGuests.add(newguest);
	}
	
	//getters
	public int getRoomPrice() {
		//TO DOOOOOO
		int price = 0;
		return price;
	}
	
	public List<Guest> getGuests(){
		return listGuests;
	}
	
	public int getId() {
		return id;
	}
	public List<Bed> getBeds() {
		return listBeds;
	}
	public boolean getView() {
		return view;
	}
	public boolean getKitchen() {
		return kitchen;
	}
	public boolean getBalcony() {
		return balcony;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getType() {
		return type;
	}
	public int getFee() {
		return fee;
	}

	public void setnumguest(int auxroominitial1, int auxroomfinal1) {
		auxroominitial = auxroominitial1;
		auxroomfinal = auxroomfinal1;
	}
	public int getauxroominitial() {
		return auxroominitial;
	}
	public int getauxroomfinal() {
		return auxroomfinal;
	}
}
