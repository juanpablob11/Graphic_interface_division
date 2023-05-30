package uniandes.dpoo.project1.interface1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.project1.models.Bed;
import uniandes.dpoo.project1.models.Booking;
import uniandes.dpoo.project1.models.Guest;
import uniandes.dpoo.project1.models.Room;
import uniandes.dpoo.project1.models.User;
import uniandes.dpoo.project1.procession.Inventory;
import uniandes.dpoo.project1.procession.loader_hotel;

public class app {
	private Inventory inventory;
	int refcounter = 1;
	public void run_app() throws FileNotFoundException, IOException 
	{
		System.out.println("***** Welcome to the HOTEL app! *****");
		boolean continue_app = true;
		new Reservation_main_panel();
	}
	
	public void loadfiles() throws FileNotFoundException, IOException {
		inventory = loader_hotel.cargarArchivo();
		inventory.setDates();
	}
	public List<Integer> listdays(Integer numDays){
		 List<Integer> days = new ArrayList<>();
	        for (int i = 1; i <= numDays; i++) {
	            days.add(i);
	        }
	        return days;
	}
	
	public int numdays_per_month(Integer month) {
		refcounter = inventory.getReservationCalendar().get(2023).get(month).size();
		return refcounter;
	}
	
	public int min_beds_per_rooms() {
		int min_beds = 20;
		for(Room room : inventory.getRooms()) {
			if(room.getBeds().size() < min_beds ) {
				min_beds = room.getBeds().size();
			}
		}
		return min_beds;
	}
	
	public int max_beds_per_rooms() {
		int max_beds = 0;
		for(Room room : inventory.getRooms()) {
			if(room.getBeds().size() > max_beds ) {
				max_beds = room.getBeds().size();
			}
		}
		return max_beds;
	}
	
	//menu without being logged in
	public void showMenu()
	{
		System.out.println("\n----> HOTEL App options <----");
		System.out.println("1. Load files (YOU MUST SELECT THIS ONE TO CONTINUE WITH OTHERS).");
		System.out.println("2. Log IN.");
		System.out.println("3. Get out of app.");
		System.out.println("4. Add New User (HOTEL staff).");
		//more options coming...
	}
	
	//1st option
	private void executeLoadRoomsFromFile() throws FileNotFoundException, IOException {
		inventory = loader_hotel.cargarArchivo();
		inventory.setDates();
		System.out.println();
		System.out.println("*** The roooms have been uploaded to database correctly! ***");
		System.out.println("-> There have been " + inventory.getRooms().size() + " rooms loaded");
		System.out.println("-> There are " + inventory.getHotel_staff().size() + " users loaded");
	}
	
	//3rd option main menu (before_registration)
		public void executeAddNewUser() {
			System.out.println();
			System.out.println("*** Adding a new user to database ***");
			String username = input("-> Please type the username(mail) to register for the new user");
			String password = input("-> Please type the password for the new account");
			String user_type = input("-> Please write the type of the user (administrador, recepcionista, empleado)");
			inventory.addWorker(username, password, user_type);
			try {
				FileWriter writer = new FileWriter("data/usuarios_dpoo_csv.csv", true);
				writer.write(System.getProperty( "line.separator" ));
				writer.write(username + ";" + password + ";" + user_type);
				writer.close();
				System.out.println("*** The new user has been created and added to database correctly ***");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//1st option main menu (before-registration)
	public void executeLogIn() throws FileNotFoundException, IOException {
		System.out.println();
		System.out.println("----- LOG IN -----");
		boolean userfound = true;
		User user_found = null;
		while(userfound) {
			String mail = input("-> Please type-a valid- email (username)");
			String password = input("-> Please type your password");
			for (User user : inventory.getHotel_staff()) {
				if (user.getUserName().equals(mail) && user.getPassword().equals(password)) {
					System.out.println();
					user_found = user;
					userfound = false;
					System.out.println("-> Your user has been found!");
				} //end if 67
			} //end for loop users
			if (user_found == null) {
			System.out.println("-> Your user hasnt been found, please type"
					+ " a correct user and password");
			System.out.println();
			}
		} //end while loop searching user
		
		System.out.println();
		System.out.println("***** Welcome again "+ user_found.getUserName() +" *****");
		System.out.println("--> Your role in the hotel is: " + user_found.getUser_type());
		if(user_found.getUser_type().contains("administrador")) {
		boolean continue_subapp = true;
		while (continue_subapp)
		{
			try
			{
				showAccesedMenu();
				int selected_option = Integer.parseInt(input("Please choose an option"));
				if (selected_option == 1 && inventory.getRooms() != null)
					executeAddRoomManually();
				else if (selected_option == 2 && inventory.getRooms() != null)
					executeCreateNewBooking();
				else if (selected_option == 3 && inventory.getRooms() != null && inventory.getBookings() != null)
					executeCancelABooking();
				else if (selected_option == 4 && inventory.getRooms() != null)
					executeAddNewSpecialFee();
				else if (selected_option == 5 && inventory.getBookings() != null)
					executeRegisterNewFee();
				else if (selected_option == 6) {
					System.out.println("*** Login out ***");
					continue_subapp = false;}
			}
			catch (NumberFormatException e)
			{
				System.out.println("You must select one of the numbers from the options.");
			}
		}
	  }
		else  if(user_found.getUser_type().contains("recepcionista")) {
			boolean continue_subapp2 = true;
			while (continue_subapp2)
			{
				try
				{
					showAccesedMenu2();
					int selected_option = Integer.parseInt(input("Please choose an option"));
					if (selected_option == 1 && inventory.getRooms() != null)
						executeCreateNewBooking();
					else if (selected_option == 2 && inventory.getRooms() != null && inventory.getBookings() != null)
						executeCancelABooking();
					else if (selected_option == 3 && inventory.getBookings() != null)
						executeRegisterNewFee();
					else if (selected_option == 4 && inventory.getBookings() != null)
						executeCheckout();
					else if (selected_option == 5)
						System.out.println("*** Login out ***");
					continue_subapp2 = false;
				}
				catch (NumberFormatException e)
				{
					System.out.println("You must select one of the numbers from the options.");
				}
			}
		}
		else if(user_found.getUser_type().contains("empleado")) {
			boolean continue_subapp3 = true;
			while (continue_subapp3)
			{
				try
				{
					showAccesedMenu3();
					int selected_option = Integer.parseInt(input("Please choose an option"));
					if (selected_option == 1 && inventory.getRooms() != null)
						executeFindFreeRoom();
					else if (selected_option == 2 && inventory.getBookings() != null)
						executeRegisterNewFee();
					else if (selected_option == 3)
						System.out.println("*** Login out ***");
					continue_subapp3 = false;
				}
				catch (NumberFormatException e)
				{
					System.out.println("You must select one of the numbers from the options.");
				}
			}
		}
	}

	private void executeFindFreeRoom() {
		// TODO Auto-generated method stub
		
	}

	private void executeCheckout() {
		// TODO Auto-generated method stub
		
	}

	//menu when you´re logged in
	public void showAccesedMenu()
	{
		System.out.println("\n----> HOTEL App options <----");
		System.out.println("1. Add room manually.");
		System.out.println("2. Create a new 'Booking'.");
		System.out.println("3. Cancel a 'Booking' (Must be 48 hrs before the reservation).");
		System.out.println("4. Create new -special- fee for a certain type of room and date.");
		System.out.println("5. Register a new fee.");
		System.out.println("6. Log out");
		//more options coming...
	}
	
	public void showAccesedMenu2()
	{
		System.out.println("\n----> HOTEL App options <----");
		System.out.println("1. Create a new 'Booking'.");
		System.out.println("2. Cancel a 'Booking' (Must be 48 hrs before the reservation).");
		System.out.println("3. Register a new fee.");
		System.out.println("4. Checkout");
		System.out.println("5. Log out");
		//more options coming...
	}
	
	public void showAccesedMenu3()
	{
		System.out.println("\n----> HOTEL App options <----");
		System.out.println("1. Find a free room in date.");
		System.out.println("3. Register a new fee.");
		System.out.println("5. Log out");
		//more options coming...
	}
	
	//2nd option
	private void executeAddRoomManually() {
		System.out.println();
		System.out.println("*** Adding a room to database! ***");
		System.out.println();
		boolean correctId = false;
		int id = 0;
		while (correctId != true) {
		id = Integer.parseInt(input("-> Please select an id for the room created in database"));
		boolean validId = inventory.ValidId(id);
		if(validId == true) {
			System.out.println("-> The new id is not used in any room before. Therefore, the id can be used"
					+ " for the new room");
			System.out.println();
			correctId = true;
		} //end if of validId
		else {
			System.out.println("-> That id is used before; in order to dont have two rooms with the same id"
					+ " we ask you please to try again with a new id.");
			System.out.println();
		} //end else
		} //end while for id
		System.out.println("Which type of room are we creating? We´ve the following valid types...");
		System.out.println("-> 1.estándar");
		System.out.println("-> 2.suite");
		System.out.println("-> 3.suite doble");
		boolean valid_type = false;
		String type = null;
		while(valid_type != true) {
			int aux_type = Integer.parseInt(input("-> Which type will be the room"));
			System.out.println();
			if (aux_type == 1) {
				type = "estándar";
				valid_type = true;
			}
			else if (aux_type == 2) {
				type = "suite";
				valid_type = true;
			}
			else if (aux_type == 3) {
				type = "suite doble";
				valid_type = true;
			}
			else {
				System.out.println("*** Please type a correct number ***");
			}
		} //end while for type
		String bed_type = null;
		int numbeds = Integer.parseInt(input("-> How many beds will have this room?"));
		boolean valid_size = false;
			System.out.println("-> We´ve the following bed types..."
					+ " the following types: ");
			System.out.println("-> 1.king");
			System.out.println("-> 2.queen");
			System.out.println("-> 3.individuales");
			System.out.println("-> 4.doble");
			while(valid_size != true) {
			int size_help = Integer.parseInt(input("-> Please write the number of the size bed "
					+ "that you want for the beds in the room"));
			if (size_help == 1) {
				bed_type = "king";
				valid_size = true;
			}
			else if (size_help == 2) {
				bed_type = "queen";
				valid_size = true;
			}
			else if (size_help == 3) {
				bed_type = "individuales";
				valid_size = true;
			}
			else if (size_help == 4) {
				bed_type = "doble";
				valid_size = true;
			}
			else {
				System.out.println("*** Please type a correct number ***");
			}
		}
		List<Bed> listBeds = inventory.createListBedsXRoom(bed_type, numbeds);
		int capacity = listBeds.size()*listBeds.get(0).amountPeole();
		System.out.println();
		int view_help = Integer.parseInt(input("-> Will the room have view? Type 1 for yes and 0 for no!"));
		System.out.println();
		int kitchen_help = Integer.parseInt(input("-> Will the room have kitchen? Type 1 for yes and 0 for no!"));
		System.out.println();
		int balcony_help = Integer.parseInt(input("-> Will the room have balcony? Type 1 for yes and 0 for no!"));
		boolean view = false;
		String view_for_csv = "no";
		if (view_help == 1) {
			view = true;
			view_for_csv = "si";
		}
		boolean kitchen = false;
		String kitchen_for_csv = "no";
		if(kitchen_help == 1) {
			kitchen = true;
			kitchen_for_csv = "si";
		}
		boolean balcony = false;
		String balcony_for_csv = "no";
		if(balcony_help == 1) {
			balcony = true;
			balcony_for_csv = "si";
		}
		inventory.createRoom(id, type, capacity, listBeds, view, kitchen, balcony);
		System.out.println();
		try {
			FileWriter writer = new FileWriter("data/habitaciones_hotelfinal.txt", true);
			writer.write(System.getProperty( "line.separator" ));
			writer.write(id + ";" + type + ";" + listBeds.size() + ";" + bed_type + ";" + balcony_for_csv + 
					";" + kitchen_for_csv + ";" + view_for_csv + "");
			writer.close();
			System.out.println("*** The room has been created and added to database succesfully ***");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void executeCreateNewBooking() {
		System.out.println();
		System.out.println("*** Creating a new booking ***");
		String initialDate = input("-> Please type the initial date of your reservation (Max three months)\n"
		 		+ " in the format YYYY-MM-DD (MIN YEAR OF RESERVATION 2023)");
		String finalDate = input("-> Please type the final date of your reservation (Max three months)\n"
		 		+ " in the format YYYY-MM-DD (MAX YEAR OF RESERVATION 2024)");
		boolean correctId = false;
		int id2 = 0;
		while (correctId != true) {
			id2 = Integer.parseInt(input("-> Please select an id for the booking created in database"));
		boolean validId = inventory.ValidIdforBooking(id2);
		if(validId == true) {
			System.out.println("-> The new id is not used in any booking before. Therefore, the id can be used"
					+ " for the new booking");
			System.out.println();
			correctId = true;
		} //end if of validId
		else {
			System.out.println("-> That id is used before; in order to dont have two bookings with the same id"
					+ " we ask you please to try again with a new id.");
			System.out.println();
		} //end else
		} //end while for id
		String guestName = input("-> Please type the main guest name");
		String guestMail = input("-> Please type the mail/username that will be at the name of the 'booking'");
		String guestPhone = input("-> Please type the phone number of the main guest");
		List<Room> guestRooms = new ArrayList<>();
		Integer numrooms = Integer.parseInt(input("-> How many rooms do you want to reservate? (MAX 4)"));
		for (Integer i = 1; i <= numrooms; ++i) {
			 System.out.println();
			 System.out.println("*** Booking the " + i + " room for the reservation! ***");
			 Integer capacity = Integer.parseInt(input("-> Please type the number of persons to be hosted in this room"));
			 boolean aux_while_room_type = true;
			 String typeroom = null;
			 while(aux_while_room_type) {
			 System.out.println("We´ve the following types of room to choose for this room ...");
			 System.out.println("1. estándar");
			 System.out.println("2. suite");
			 System.out.println("3. suite doble");
			 Integer aux_type_room = Integer.parseInt(input("Please type the number of type room that you want"));
			 if (aux_type_room == 1) {
				 typeroom = "estándar";
				 aux_while_room_type = false;
			 	}
			 else if(aux_type_room == 2) {
				 typeroom = "suite";
				 aux_while_room_type = false;
			 	}
			 else if(aux_type_room == 3) {
				 typeroom = "suite doble";
				 aux_while_room_type = false;
			 	}
			 else {
				 System.out.println("-> Please choose a correct number.");
			 	}
			 System.out.println();
			 }//end while
			 List<Room> booked_rooms_in_date = inventory.getDisponibilityRoom(initialDate, finalDate);
			 List<Room> Provisional_Rooms = new ArrayList<>();
			 for (Room room : inventory.getRooms()) {
				 if (booked_rooms_in_date.contains(room) != true && room.getCapacity() >= capacity 
						 && room.getType().equals(typeroom)) {
					 Provisional_Rooms.add(room);
				 }//end if 271
			 }// final for of searching rooms
			 System.out.println("*** We´ve the following rooms by capacity and type "
			 		+ "available in the dates you´ve specified ***");
			 System.out.println("-> Please choose one for the reservation...");
			 System.out.println();
			 int auxcounterroom = 1;
			 for(Room room : Provisional_Rooms) {
				 System.out.println("***** " + auxcounterroom + ". Room INFO *****");
				 System.out.println("-> Room type: " + room.getType());
				 System.out.println("-> Room capacity: " + room.getCapacity());
				 System.out.println("-> Room id: " + room.getId());
				 if(room.getBalcony()) {
				 System.out.println("-> The room has balcony");
				 }
				 else {
				 System.out.println("-> The room doesnt have balcony");
				 }
				 if(room.getView()) {
					 System.out.println("-> The room has view");
					 }
				 else {
					 System.out.println("-> The room doesnt have view");
					 }
				 if(room.getKitchen()) {
					 System.out.println("-> The room has kitchen");
					 }
				 else {
					 System.out.println("-> The room doesnt have kitchen");
					 }
				 System.out.println("-> The room has " + room.getBeds().size() + " beds.");
				 System.out.println("-> The beds info is the following...");
				 int aux_counter_bed = 1;
				 for (Bed bed : room.getBeds()) {
					 System.out.println("	* The " + aux_counter_bed + " has the size " +bed.getSize() + 
							 " and has an additional amount of " + bed.getPrice());
					 aux_counter_bed++;
				 }
				 auxcounterroom++;
				 System.out.println();
			 }//end for by room available
			 Integer numoptionroom = Integer.parseInt(input("-> Which number of room best fits for you?")); 
			 System.out.println();
			 System.out.println("*** Congratulations on choosing the " + numoptionroom + " room ***");
			 Room roomchosed = Provisional_Rooms.get(numoptionroom-1);
			 System.out.println("-> For the last part, we will be adding the guests in this room");
			 System.out.println();
			 int auxroominitial = 0;
			 int auxroomfinal = 0;
			 for(int aux_num_guests = 1; aux_num_guests <= capacity; ++aux_num_guests) {
				 System.out.println("*** Adding the guest #" + aux_num_guests);
				 String id = input("-> Please type the id of the " + aux_num_guests + " guest");
				 String GuestName = input("-> Please type the name of the guest " + aux_num_guests);
				 auxroominitial = refcounter;
				 Guest newguest = new Guest(id, GuestName);
				 try {
						FileWriter writer = new FileWriter("data/guests.csv", true);
						writer.write("");
						writer.write(refcounter + ";" + id + ";" + GuestName);
						writer.close();
						++refcounter;
						System.out.println("*** The new user has been created and added to database correctly ***");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 auxroomfinal = refcounter;
				 roomchosed.addGuest(newguest);
				 roomchosed.setnumguest(auxroominitial, auxroomfinal);
				 System.out.println();
			 }//end for creating guests
			 System.out.println("-> The room will be added to your booking!");
			 guestRooms.add(roomchosed);
			 System.out.println();
		}//end for of number of rooms
		//INCOMPLETO
		System.out.println("*** The ´booking´ has been added to database, We are waiting for you! ***");
		Booking newbooking = new Booking(initialDate, finalDate, guestName, guestMail, guestPhone, id2);
		for(Room newroom : guestRooms) {
			newbooking.setRoom(newroom);
		}
		System.out.println("before opening function test");
		inventory.addRoomToCalendar(initialDate, finalDate, newbooking);
		System.out.println("test");
		inventory.addBooking(newbooking);
		System.out.println();
	}
	
	private void executeCancelABooking() {
		// TODO Auto-generated method stub
		
	}
	
	private void executeAddNewSpecialFee() {
		// TODO Auto-generated method stub
		
	}
	
	private void executeRegisterNewFee() {
		// TODO Auto-generated method stub
		
	}

	//Input function to catch values from terminal
	public String input(String message)
	{
		try
		{
			System.out.print(message + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error reading from console");
			e.printStackTrace();
		}
		return null;
	}
	
	//Main method to run the application
		public static void main(String[] args) throws FileNotFoundException, IOException
		{
			app new_app = new app();
			new_app.run_app();
		}
}
