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
	
	public Hotel findCheapestHotelInAGivenDateRangeWithBestRating(Date start, Date end, long weekDays, Customer customer) {
		long numberOfDays = (1 + (end.getTime() - start.getTime())) / (1000 * 60 * 60 * 24);
		long weekEnds = numberOfDays - weekDays;
		System.out.println("Weekends: "+weekEnds+ " Weekdays: " + weekDays);
		if (Customer.getCustomerType().equals("Regular")) {
			for(Hotel i :hotels) {
				long totalCostOfStay = (weekDays * i.getRegularCustomerRate())
						+ (weekEnds * i.getRegularCustomerRateForWeekend());
				i.setTotalRate(totalCostOfStay);
			}
		
		}else if(Customer.getCustomerType().equals("Reward")){
			for (Hotel hotel : hotels) {
				long totalRate = (weekDays * hotel.getRewardCustomerRateForWeekday())
						+ (weekEnds * hotel.getRewardCustomerRateForWeekend());
				hotel.setTotalRate(totalRate);
			}
		}
		
		List<Hotel> listOfHighestRatedHotels = hotels.stream().sorted(Comparator.comparing(Hotel::getRating))
				.collect(Collectors.toList());

		Hotel cheapestHotelStay = listOfHighestRatedHotels.get(0);
		for (Hotel i : listOfHighestRatedHotels) {
			if (i.getTotalRate() <= cheapestHotelStay.getTotalRate()) {
				if (i.getRating() > cheapestHotelStay.getRating())
					cheapestHotelStay = i;
			} else
				break;
		}
		return cheapestHotelStay;
	}
	
	long countWeekDays(Date start, Date end) {
		long Weekdays = 0;
		long Weekends = 0;
		Calendar startCalender = Calendar.getInstance();
		startCalender.setTime(start);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end);
		if (startCalender.getTimeInMillis() > endCal.getTimeInMillis()) {
			do {
				startCalender.add(Calendar.DAY_OF_MONTH, 1);
				if (startCalender.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
						&& startCalender.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					++Weekdays;
				}
				startCalender.add(Calendar.DAY_OF_MONTH, 1);
				
			} while (startCalender.getTimeInMillis() < endCal.getTimeInMillis());
			
		}
		return Weekdays;
	}
	
	public static void main(String[] args) throws Exception {
		Date startDate = null;
		Date endDate = null;
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation");
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110 , 90, 80, 80, 3.0);
		Hotel h2 = new Hotel("Bridgewood", 160, 50, 110, 50, 4.0);
		Hotel h3 = new Hotel("Ridgewood", 220, 150, 100, 40, 5.0);
		h.addHotel(h1);
		h.addHotel(h2);
		h.addHotel(h3);
		System.out.println("1.For Regular Customers \n2.For Reward Customers");
		int type = sc.nextInt();
		try {
			if (type == 1) {
				c.setCustomerType("Regular");
			} else if (type == 2) {
				c.setCustomerType("Reward");
				System.out.println(sc.nextLine());
			} else
				throw new InvalidCustomerException();
			
		} catch (InvalidCustomerException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Start date :");
			String start = sc.nextLine();
			sc.nextLine();
			startDate = new SimpleDateFormat("ddMMyyyy").parse(start);
			System.out.println("End date:");
			String end = sc.nextLine();
			endDate = new SimpleDateFormat("ddMMyyyy").parse(end);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long weekDays = h.countWeekDays(startDate, endDate);
		Hotel cheapestHotelStay = h.findCheapestHotelInAGivenDateRangeWithBestRating(startDate, endDate, weekDays, c);
		System.out.println(cheapestHotelStay);
		System.out.println("Total cost of stay: " + cheapestHotelStay.getTotalRate() + "$");
		
		
	}
}
