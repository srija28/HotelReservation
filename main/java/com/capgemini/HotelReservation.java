package com.capgemini;
import java.util.*;
import java.util.ArrayList;

public class HotelReservation {
	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	
	public boolean addHotel(Hotel newHotel) {
		hotels.add(newHotel);
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation");
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110);
		Hotel h2 = new Hotel("Bridgewood", 160);
		Hotel h3 = new Hotel("Ridgewood", 220);
		h.addHotel(h1);
		h.addHotel(h2);
		h.addHotel(h3);
		
	}
}
