package uniandes.dpoo.project1.procession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.project1.models.Bed;
import uniandes.dpoo.project1.models.Room;
import uniandes.dpoo.project1.models.User;


public class loader_hotel {
		static File hotel_rooms = new File("data/habitaciones_hotelfinal.txt");
		static File pricesnstatistics = new File("data/precios_final.txt");
		static File hotel_users = new File("data/usuarios_dpoo_csv.csv");
		// methods of restaurant_loader to access the files from another scope
		public static File roomsFile() {
			return hotel_rooms;
		}
		public static File priceFile() {
			return pricesnstatistics;
		}
		public static File usersFile() {
			return hotel_users;
		}
		public static Inventory cargarArchivo() throws FileNotFoundException, IOException
		{
			//Creating Data structures to store the info
			List<Room> Rooms = new ArrayList<>();
			Map<String, Integer> RoomTypes = new HashMap<>();
			Map<String, List<Integer>> pricexsizexbed = new HashMap<>();
			//Accessing from another scope the static files of the app 
			File hotel_roomfile = loader_hotel.roomsFile();
			File pricesFile = loader_hotel.priceFile();
			File users_file = loader_hotel.usersFile();
			//Reading and processing the files
			BufferedReader br1 = new BufferedReader(new FileReader(pricesFile));
			
			String line1 = br1.readLine();
			line1 = br1.readLine();
			while (line1 != null) // When it comes to the end of the file the variable line will have null value
			{
				//System.out.println(line);
				String[] parts = line1.split(";");
				String bed_type = parts[0];
				int priceperbed = Integer.parseInt(parts[1]);
				int peopleperbed = Integer.parseInt(parts[2]);
				String room_type = null;
				int room_price = 0;
				if(parts[3].equals("-") != true  && parts[4].equals("-") != true) {
					room_type = parts[3];
					room_price = Integer.parseInt(parts[4]);
					RoomTypes.put(room_type, room_price);
				}
				List<Integer> bed_info = new ArrayList<>();
				bed_info.add(priceperbed);
				bed_info.add(peopleperbed);
				pricexsizexbed.put(bed_type, bed_info);
				line1 = br1.readLine(); // To read next line of the text file
			}

			br1.close();
			
			BufferedReader br = new BufferedReader(new FileReader(hotel_roomfile));
			String line = br.readLine(); // The first line of the file is ignored because it only has 
			//column titles
			line = br.readLine();
			while (line != null) // When it comes to the end of the file the variable line will have null value
			{
				String[] parts = line.split(";");
				int id = Integer.parseInt(parts[0]);
				String roomtype = parts[1];
				int numbeds = Integer.parseInt(parts[2]);
				String bedtypes = parts[3];
				int capacity = pricexsizexbed.get(bedtypes).get(1)*numbeds;
				boolean balcony;
				if(parts[4].equals("si")) {
					balcony = true;
				}
				else {
					balcony = false;
				}
				boolean kitchen;
				if(parts[5].equals("si")) {
					kitchen = true;
				}
				else {
					kitchen = false;
				}
				boolean view;
				if(parts[6].equals("si")) {
					view = true;
				}
				else {
					view = false;
				}
				List<Bed> listBeds = new ArrayList<>();
				for (Integer counter = 1; counter <= numbeds; ++counter) {
					int numpeople = pricexsizexbed.get(bedtypes).get(1);
					boolean kidfriendly;
					if (bedtypes.equals("individuales") || bedtypes.equals("doble")) {
						kidfriendly = false;
					} 
					else {
						kidfriendly = true;
					}
					int price = pricexsizexbed.get(bedtypes).get(0);
					Bed bed = new Bed(bedtypes, numpeople, kidfriendly, price);
					listBeds.add(bed);
				}
				Room room = new Room(id, roomtype, capacity, listBeds, view, kitchen, balcony);
				Rooms.add(room);
				line = br.readLine(); // To read next line of the text file
			} //end while for 1st csv

			br.close();
			
			List<User> hotel_users_list = new ArrayList<>();
			BufferedReader br2 = new BufferedReader(new FileReader(users_file));
			String line2 = br2.readLine();
			line2 = br2.readLine();
			while (line2 != null) // When it comes to the end of the file the variable line will have null value
			{
				//System.out.println(line);
				String[] parts = line2.split(";");
				String name = parts[0];
				String password = parts[1];
				String user_type = parts[2];
				User new_user = new User (name, password, user_type);
				hotel_users_list.add(new_user);  
				line2 = br2.readLine(); // To read next line of the text file
			}

			br2.close();
			
			//Creating the super class Inventory and passing the loaded elements
			Inventory inventory = new Inventory(Rooms, "Hotel DPOO", pricexsizexbed, RoomTypes, hotel_users_list);
			return inventory;	
		}
	

}
