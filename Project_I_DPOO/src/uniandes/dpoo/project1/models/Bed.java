package uniandes.dpoo.project1.models;

public class Bed {
	//Attributes
	private String size;
	private int numpeople;
	private boolean kidfriendly;
	private int price;
	//Constructor
	public Bed(String size, int numpeople, boolean kidfriendly, int price) {
		this.size = size;
		this.numpeople = numpeople;
		this.kidfriendly = kidfriendly;
		this.price = price;
	}
	//methods
	public String getSize() {
		return size;
	}
	public int amountPeole () {
		return numpeople;
	}
	public boolean kidfriend() {
		return kidfriendly;
	}
	public int getPrice() {
		return price;
	}
}
