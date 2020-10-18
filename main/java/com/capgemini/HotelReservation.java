package com.capgemini;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
public class HotelReservation {
	private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	
	public boolean addHotel(Hotel newHotel) {
		hotels.add(newHotel);
		return true;
	}
	
	public Hotel findCheapestHotelInAGivenDateRange(Date start, Date end, long weekDays) {
		long numberOfDays = (1 + (end.getTime() - start.getTime())) / (1000 * 60 * 60 * 24);
		long weekEnds = numberOfDays - weekDays;
		System.out.println("Weekends: "+weekEnds+ " Weekdays: " + weekDays);
		for(Hotel i :hotels) {
			long totalCostOfStay = (weekDays * i.getRegularCustomerRate())
					+ (weekEnds * i.getRegularCustomerRateForWeekend());
			i.setTotalRate(totalCostOfStay);
		}
		Hotel cheapestHotel = hotels.stream().sorted(Comparator.comparing(Hotel::getTotalRate)).findFirst()
				.orElse(null);
		return cheapestHotel;

	}
	
	private long countWeekDays(Date start, Date end) {
		long Weekdays = 0;
		long Weekends = 0;
		Calendar startCalender = Calendar.getInstance();
		startCalender.setTime(start);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end);
		if (startCalender.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCalender.setTime(end);
			endCal.setTime(start);
		}

		do {
			startCalender.add(Calendar.DAY_OF_MONTH, 1);
			if (startCalender.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCalender.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++Weekdays;
			}
		} while (startCalender.getTimeInMillis() < endCal.getTimeInMillis());

		return Weekdays;
	}
	
	public static void main(String[] args) throws Exception {
		Date startDate = null;
		Date endDate = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation");
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110 , 90);
		Hotel h2 = new Hotel("Bridgewood", 160, 50);
		Hotel h3 = new Hotel("Ridgewood", 220, 150);
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
		long weekDays = h.countWeekDays(startDate, endDate);
		Hotel cheapestHotelStay = h.findCheapestHotelInAGivenDateRange(startDate, endDate, weekDays);
		System.out.println(cheapestHotelStay);
		System.out.println("Total cost of stay: " + cheapestHotelStay.getTotalRate() + "$");
	}
}
