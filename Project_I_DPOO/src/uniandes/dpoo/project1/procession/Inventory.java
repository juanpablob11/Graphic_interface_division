package uniandes.dpoo.project1.procession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.project1.models.Bed;
import uniandes.dpoo.project1.models.Booking;
import uniandes.dpoo.project1.models.Guest;
import uniandes.dpoo.project1.models.Room;
import uniandes.dpoo.project1.models.User;

public class Inventory {
	//Attributes
	private String HotelName;
	private Map<Integer, List<Map<Integer, List<Booking>>>> ReservationsxYear = new HashMap<Integer, List<Map<Integer, List<Booking>>>>();
	private List<User> Hotel_staff = new ArrayList<>();
	private List<Room> Rooms = new ArrayList<>();
	private List<Booking> Bookings = new ArrayList<>();
	private Map<String, List<Integer>> pricexsizexbed = new HashMap<String, List<Integer>>();
	private Map<String, Integer> roomTypes;
	//constructor
	public Inventory (List<Room> Rooms, String HotelName, Map<String, List<Integer>> pricexsizexbed, 
			Map<String, Integer> roomTypes, List<User> Hotel_staff) {
		this.Rooms = Rooms;
		this.HotelName = HotelName;
		this.pricexsizexbed = pricexsizexbed;
		this.roomTypes = roomTypes;
		this.Hotel_staff = Hotel_staff;
	} //Rooms come from csv or added manually
	//Setters
	public void addWorker(String username, String password, String user_type) {
		User user = new User(username, password, user_type);
		Hotel_staff.add(user);
	}
	
	public void addBooking(Booking booking) {
		Bookings.add(booking);
	}
	
	public Guest createNewGuest(String id, String GuestName, Room guestRoom) {
		Guest newguest = new Guest(id, GuestName);
		return newguest;
	}
	
	public void setDates() {
		for (int auxyear = 2023; auxyear <= 2024; ++auxyear) {
		int i = 0;
			List<Map<Integer, List<Booking>>> Reservations = new ArrayList<Map<Integer, List<Booking>>>();
		while (i < 13) {
			i ++;
			switch (i) {
			case 1:
				Map<Integer, List<Booking>> January = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> JanuaryList = new ArrayList<Booking>();
					January.put(day, JanuaryList);
					} //end for loop
					Reservations.add(January); //January added to year list
					break;
			case 2:
				Map<Integer, List<Booking>> February = new HashMap<>();
				for (Integer day = 1; day <= 28; ++day) {
					List<Booking> FebruaryList = new ArrayList<Booking>();
					February.put(day, FebruaryList);
					} //end for loop
					Reservations.add(February); //February added to year list
					break;
			case 3:
				Map<Integer, List<Booking>> March = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> MarchList = new ArrayList<Booking>();
					March.put(day, MarchList);
					} //end for loop
					Reservations.add(March); //March added to year list
					break;
			case 4:
				Map<Integer, List<Booking>> April = new HashMap<>();
				for (Integer day = 1; day <= 30; ++day) {
					List<Booking> AprilList = new ArrayList<Booking>();
					April.put(day, AprilList);
					} //end for loop
					Reservations.add(April); //April added to year list
					break;
			case 5:
				Map<Integer, List<Booking>> May = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> MayList = new ArrayList<Booking>();
					May.put(day, MayList);
					} //end for loop
					Reservations.add(May); //May added to year list
					break;
			case 6:
				Map<Integer, List<Booking>> June = new HashMap<>();
				for (Integer day = 1; day <= 30; ++day) {
					List<Booking> JuneList = new ArrayList<Booking>();
					June.put(day, JuneList);
					} //end for loop
					Reservations.add(June); //June added to year list
					break;
			case 7:
				Map<Integer, List<Booking>> July = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> JulyList = new ArrayList<Booking>();
					July.put(day, JulyList);
					} //end for loop
					Reservations.add(July); //July added to year list
					break;
			case 8:
				Map<Integer, List<Booking>> August = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> AugustList = new ArrayList<Booking>();
					August.put(day, AugustList);
					} //end for loop
					Reservations.add(August); //August added to year list
					break;
			case 9:
				Map<Integer, List<Booking>> September = new HashMap<>();
				for (Integer day = 1; day <= 30; ++day) {
					List<Booking> SeptemberList = new ArrayList<Booking>();
					September.put(day, SeptemberList);
					} //end for loop
					Reservations.add(September); //September added to year list
					break;
			case 10:
				Map<Integer, List<Booking>> October = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> OctoberList = new ArrayList<Booking>();
					October.put(day, OctoberList);
					} //end for loop
					Reservations.add(October); //October added to year list
					break;
			case 11:
				Map<Integer, List<Booking>> November = new HashMap<>();
				for (Integer day = 1; day <= 30; ++day) {
					List<Booking> NovemberList = new ArrayList<Booking>();
					November.put(day, NovemberList);
					} //end for loop
					Reservations.add(November); //November added to year list
					break;
			case 12:
				Map<Integer, List<Booking>> December = new HashMap<>();
				for (Integer day = 1; day <= 31; ++day) {
					List<Booking> DecemberList = new ArrayList<Booking>();
					December.put(day, DecemberList);
					} //end for loop
					Reservations.add(December); //December added to year list
					break;
			} //end switch
		} //end while
		ReservationsxYear.put(auxyear, Reservations);
	  } //end for year
	} //end setDates
	
	public void addRoomToCalendar(String initial_date, String final_date, Booking booking) {
		String[] parts = initial_date.split("-");
		int ini_year = Integer.parseInt(parts[0]);
		int ini_month = Integer.parseInt(parts[1]);
		int ini_day = Integer.parseInt(parts[2]);
		String[] parts2 = final_date.split("-");
		int fin_year = Integer.parseInt(parts2[0]);
		int fin_month = Integer.parseInt(parts2[1]);
		int fin_day = Integer.parseInt(parts2[2]);
		if(ini_year == fin_year) {
			if (ini_month == fin_month) {
				for (Integer i = ini_day; i <= fin_day; ++i) {
					ReservationsxYear.get(ini_year).get(ini_month-1).get(i).add(booking);
				}//end for 
			}//end if equal year & month
			else {
				for(Integer i = ini_month; i <= fin_month; ++i) {
						if (i == ini_month) {
					for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
						ReservationsxYear.get(ini_year).get(i-1).get(day_aux).add(booking);
							}//end for day counter when it reaches the last day of the key set	
						}//end if for first month to set day counter as ini_day
						else if(i == fin_month) {
					for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {
						ReservationsxYear.get(ini_year).get(i-1).get(day_aux).add(booking);	
							}//end for day counter when it reaches the last day of the final month
						}//else if for last month to day counter to stop on last day
						else {
					for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
						ReservationsxYear.get(ini_year).get(i-1).get(day_aux).add(booking);
							}//end for day counter when it reaches the last day of the key set	
						}//else if we´re in another month than the first month
					
					}//end for by month
				}//else for different month
			}//end if equal year
		else { //ELSE FOR  DIFFERENT YEAR
			//for(Integer aux_year = ini_year; aux_year <= fin_year; ++aux_year) {
				for(Integer i = ini_month; i <= fin_month+12; ++i) { //FOR BY MONTH
					if (i == ini_month) { //INITIAL MONTH
				for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
					ReservationsxYear.get(ini_year).get(i-1).get(day_aux).add(booking);
						}//end for day counter when it reaches the last day of the key set	
					}//end if for first month to set day counter as ini_day
					else if(i <= 12) { //SAME YEAR BUT DIFFERENT MONTH
				for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
					ReservationsxYear.get(ini_year).get(i-1).get(day_aux).add(booking);	
						}//end for day counter when it reaches the last day of the final month
					}//else if for last month to day counter to stop on last day
					
				else if(i > 12) { //DIFFERENT YEAR
				int aux_module_month = i%12;
				if(aux_module_month == fin_month) { //DIFFERENT YEAR AND LAST MONTH OF RESERVATION
					for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {
						ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).add(booking);			
						}//end for day counter when it reaches the last day of the final month
					}//end if for  last month
				else { //DIFFERENT YEAR BUT NOT LAST MONTH OF RESERVATION
					for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year+1).get(aux_module_month-1).size(); ++day_aux) {
						ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).add(booking);	
							}//end for day counter when it reaches the last day of the final month
						}//end if for month counter in the new year
					}//else if for last month to day counter to stop on last day
				
				}//end for by month
			//}//end for by year
		}
	}

	public List<Room> getDisponibilityRoom(String initial_date, String final_date) {
		String[] parts = initial_date.split("-");
		int ini_year = Integer.parseInt(parts[0]);
		int ini_month = Integer.parseInt(parts[1]);
		int ini_day = Integer.parseInt(parts[2]);
		String[] parts2 = final_date.split("-");
		int fin_year = Integer.parseInt(parts2[0]);
		int fin_month = Integer.parseInt(parts2[1]);
		int fin_day = Integer.parseInt(parts2[2]);
		List<Room> busyrooms = new ArrayList<>();
		if(ini_year == fin_year) {
		if (ini_month == fin_month) {
			for (Integer i = ini_day; i <= fin_day; ++i) {
				List<Booking> Bookingsxday = ReservationsxYear.get(ini_year).get(ini_month-1).get(i);
				aux_getDisponibilityRoom(Bookingsxday, busyrooms);
			}//end for of the if 158
		}//end if equal year & month
		else {
			for(Integer i = ini_month; i <= fin_month; ++i) {
					if (i == ini_month) {
				for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
					List<Booking> Bookingsxday = ReservationsxYear.get(ini_year).get(i-1).get(day_aux);
					aux_getDisponibilityRoom(Bookingsxday, busyrooms);
					}//end for day counter when it reaches the last day of the key set	
					}//end if for first month to set day counter as ini_day
					else if(i == fin_month) {
				for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {
					List<Booking> Bookingsxday = ReservationsxYear.get(ini_year).get(i-1).get(day_aux);
					aux_getDisponibilityRoom(Bookingsxday, busyrooms);	
						}//end for day counter when it reaches the last day of the final month
					}//else if for last month to day counter to stop on last day
					else {
				for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
					List<Booking> Bookingsxday = ReservationsxYear.get(ini_year).get(i-1).get(day_aux);
					aux_getDisponibilityRoom(Bookingsxday, busyrooms);
						}//end for day counter when it reaches the last day of the key set	
					}//else if we´re in another month than the first month
				
			}//end for by month
		}//else for different month
		}//end if equal year 
		else { //ELSE FOR DIFFERENT YEAR
			for(Integer aux_year = ini_year; aux_year <= fin_year; ++aux_year) {
				for(Integer i = ini_month; i <= fin_month+12; ++i) {
					if(aux_year == ini_year) {
					
					if (i == ini_month) { //INITIAL MONTH
				for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(aux_year).get(i-1).size(); ++day_aux) {
					List<Booking> Bookingsxday = ReservationsxYear.get(aux_year).get(i-1).get(day_aux);
					aux_getDisponibilityRoom(Bookingsxday, busyrooms);
					}//end for day counter when it reaches the last day of the key set	
					}//end if for first month to set day counter as ini_day
					else if(i <= 12) { //SAME YEAR BUT DIFFERENT MONTH
				for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(aux_year).get(i-1).size(); ++day_aux) {
					List<Booking> Bookingsxday = ReservationsxYear.get(aux_year).get(i-1).get(day_aux);
					aux_getDisponibilityRoom(Bookingsxday, busyrooms);	
						}//end for day counter when it reaches the last day of the final month
					}//else if for last month to day counter to stop on last day
				}
					else {
					if(aux_year == fin_year) {}
					else if(i > 12) { //DIFFERENT YEAR
					Integer aux_i = i%12;
					if(aux_i == fin_month) { //DIFFERENT YEAR AND LAST MONTH OF RESERVATION
						for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {
							List<Booking> Bookingsxday = ReservationsxYear.get(aux_year).get(aux_i-1).get(day_aux);
							aux_getDisponibilityRoom(Bookingsxday, busyrooms);	
								}//end for day counter when it reaches the last day of the final month
					}//end if for  last month
					else { //DIFFERENT YEAR BUT NOT LAST MONTH OF RESERVATION
						for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(aux_year).get(aux_i-1).size(); ++day_aux) {
							List<Booking> Bookingsxday = ReservationsxYear.get(aux_year).get(aux_i-1).get(day_aux);
							aux_getDisponibilityRoom(Bookingsxday, busyrooms);	
								}//end for day counter when it reaches the last day of the final month
						}//end if for month counter in the new year
					}//else if for last month to day counter to stop on last day
					}
				}//end for by month
			}//end for by year
		}
		return busyrooms;
	}
	
	public void eliminateBooking(String initial_date, String final_date, Booking booking) {
		String[] parts = initial_date.split("-");
		int ini_year = Integer.parseInt(parts[0]);
		int ini_month = Integer.parseInt(parts[1]);
		int ini_day = Integer.parseInt(parts[2]);
		String[] parts2 = final_date.split("-");
		int fin_year = Integer.parseInt(parts2[0]);
		int fin_month = Integer.parseInt(parts2[1]);
		int fin_day = Integer.parseInt(parts2[2]);
		//Eliminating in dates
		if(ini_year == fin_year) {
			if (ini_month == fin_month) {
				for (Integer i = ini_day; i <= fin_day; ++i) {
					if(ReservationsxYear.get(ini_year).get(ini_month-1).get(i).contains(booking)) {
						int position = ReservationsxYear.get(ini_year).get(ini_month-1).get(i).indexOf(booking);
						ReservationsxYear.get(ini_year).get(ini_month-1).get(i).remove(position);
					}
				}//end for 
			}//end if equal year & month
			else {
				for(Integer i = ini_month; i <= fin_month; ++i) {
						if (i == ini_month) {
					for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
						if(ReservationsxYear.get(ini_year).get(i-1).get(day_aux).contains(booking)) {
							int position = ReservationsxYear.get(ini_year).get(i-1).get(day_aux).indexOf(booking);
							ReservationsxYear.get(ini_year).get(i-1).get(day_aux).remove(position);
						}
							}//end for day counter when it reaches the last day of the key set	
						}//end if for first month to set day counter as ini_day
						else if(i == fin_month) {
					for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {
						if(ReservationsxYear.get(ini_year).get(i-1).get(day_aux).contains(booking)) {
							int position = ReservationsxYear.get(ini_year).get(i-1).get(day_aux).indexOf(booking);
							ReservationsxYear.get(ini_year).get(i-1).get(day_aux).remove(position);
						}
							}//end for day counter when it reaches the last day of the final month
						}//else if for last month to day counter to stop on last day
						else {
					for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {						
						if(ReservationsxYear.get(ini_year).get(i-1).get(day_aux).contains(booking)) {
							int position = ReservationsxYear.get(ini_year).get(i-1).get(day_aux).indexOf(booking);
							ReservationsxYear.get(ini_year).get(i-1).get(day_aux).remove(position);
						}
							}//end for day counter when it reaches the last day of the key set	
						}//else if we´re in another month than the first month
					
					}//end for by month
				}//else for different month
			}//end if equal year
		else { //ELSE FOR  DIFFERENT YEAR
			//for(Integer aux_year = ini_year; aux_year <= fin_year; ++aux_year) {
				for(Integer i = ini_month; i <= fin_month+12; ++i) { //FOR BY MONTH
					if (i == ini_month) { //INITIAL MONTH
				for(Integer day_aux = ini_day; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {
					if(ReservationsxYear.get(ini_year).get(i-1).get(day_aux).contains(booking)) {
						int position = ReservationsxYear.get(ini_year).get(i-1).get(day_aux).indexOf(booking);
						ReservationsxYear.get(ini_year).get(i-1).get(day_aux).remove(position);
					}
						}//end for day counter when it reaches the last day of the key set	
					}//end if for first month to set day counter as ini_day
					else if(i <= 12) { //SAME YEAR BUT DIFFERENT MONTH
				for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year).get(i-1).size(); ++day_aux) {	
					if(ReservationsxYear.get(ini_year).get(i-1).get(day_aux).contains(booking)) {
						int position = ReservationsxYear.get(ini_year).get(i-1).get(day_aux).indexOf(booking);
						ReservationsxYear.get(ini_year).get(i-1).get(day_aux).remove(position);
					}
						}//end for day counter when it reaches the last day of the final month
					}//else if for last month to day counter to stop on last day
					
				else if(i > 12) { //DIFFERENT YEAR
				int aux_module_month = i%12;
				if(aux_module_month == fin_month) { //DIFFERENT YEAR AND LAST MONTH OF RESERVATION
					for(Integer day_aux = 1; day_aux <= fin_day; ++day_aux) {						
						if(ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).contains(booking)) {
							int position = ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).indexOf(booking);
							ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).remove(position);
						}
						}//end for day counter when it reaches the last day of the final month
					}//end if for  last month
				else { //DIFFERENT YEAR BUT NOT LAST MONTH OF RESERVATION
					for(Integer day_aux = 1; day_aux <= ReservationsxYear.get(ini_year+1).get(aux_module_month-1).size(); ++day_aux) 
						if(ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).contains(booking)) {
							int position = ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).indexOf(booking);
							ReservationsxYear.get(ini_year+1).get(aux_module_month-1).get(day_aux).remove(position);
						}
							}//end for day counter when it reaches the last day of the final month
						}//end if for month counter in the new year
					}//else if for last month to day counter to stop on last day
				
				}//end for by month
			//}//end for by year
		}
	
	
	public void aux_getDisponibilityRoom(List<Booking> Bookingsxday, List<Room> busyrooms) {
		for (Booking reservation : Bookingsxday) {
			List<Room> roomsperbooking = reservation.getRooms();
			for (Room room : roomsperbooking) {
				busyrooms.add(room);
			}//end for room in a booking
		}//end for reservations in a day
	}// end aux_getDisponibilityRoom
	
	public List<Bed> createListBedsXRoom (String size, int numbeds){
		List<Bed> listBeds = new ArrayList<>();
		int numpeople = getBedInfo().get(size).get(1);
		boolean kidfriendly;
		if (size == "individuales" || size == "doble") {
			kidfriendly = false;
		} 
		else {
			kidfriendly = true;
		}
		int price = getBedInfo().get(size).get(0);
		for (int i = 1; i <= numbeds; ++i) {
			Bed bed = new Bed(size, numpeople, kidfriendly, price);
			listBeds.add(bed);
		}
		return listBeds;
	}
	
	public void createRoom(int id, String type, int capacity, List<Bed> listBeds, boolean view,
			boolean kitchen, boolean balcony) {
		Room room = new Room(id, type, capacity, listBeds, view, kitchen, balcony);
		Rooms.add(room);
	}
	//Getters
	public String getHotelName(){
		return HotelName;
	}
	public Map<Integer, List<Map<Integer, List<Booking>>>> getReservationCalendar() {
		return ReservationsxYear;
	}
	
	public List<User> getHotel_staff(){
		return Hotel_staff;
	}
	public List<Room> getRooms(){
		return Rooms;
	}
	public List<Booking> getBookings() {
		return Bookings;
	}
	public Map<String, List<Integer>> getBedInfo() {
		return pricexsizexbed;
	}
	public Map<String, Integer> getRoomsInfo() {
		return roomTypes;
	}
	public boolean ValidId(int newid) {
		boolean validid = true;
		for (Room room : Rooms) {
			if (room.getId() == newid) {
				validid = false;
			}
		}
		return validid;
	}
	public boolean ValidIdforBooking(int newid) {
		boolean validid = true;
		for (Booking booking : Bookings) {
			if (booking.getId() == newid) {
				validid = false;
			}
		}
		return validid;
	}
}

