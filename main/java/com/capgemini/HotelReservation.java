package com.capgemini;
import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class HotelReservation {
	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	
	public boolean addHotel(Hotel newHotel) {
		hotels.add(newHotel);
		return true;
	}
	
	public Hotel findCheapestHotelInAGivenDateRange(Date start, Date end) {
		long numberOfDays = (1 + (end.getTime() - start.getTime())) / (1000 * 60 * 60 * 24);
		Hotel cheapestHotel = hotels.stream().sorted(Comparator.comparing(Hotel::getRegularCustomerRate)).findFirst()
				.orElse(null);
		long totalCostOfStay = numberOfDays * cheapestHotel.getRegularCustomerRate();
		cheapestHotel.setTotalRate(totalCostOfStay);
		return cheapestHotel;

	}
	
	public static void main(String[] args) throws Exception {
		Date startDate = null;
		Date endDate = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation");
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110);
		Hotel h2 = new Hotel("Bridgewood", 160);
		Hotel h3 = new Hotel("Ridgewood", 220);
		h.addHotel(h1);
		h.addHotel(h2);
		h.addHotel(h3);
		
		try {
			System.out.println("Start date :");
			String start = sc.nextLine();
			startDate = new SimpleDateFormat("ddMMyyyy").parse(start);
			System.out.println("End date:");
			String end = sc.nextLine();
			endDate = new SimpleDateFormat("ddMMyyyy").parse(end);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Hotel cheapestHotelStay = h.findCheapestHotelInAGivenDateRange(startDate, endDate);
		System.out.println(cheapestHotelStay);
	}
}
