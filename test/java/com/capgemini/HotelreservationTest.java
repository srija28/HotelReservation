package com.capgemini;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;


public class HotelreservationTest {
	@Test
	public void  CheckforHotelPresentorNot() {
		HotelReservation h = new HotelReservation();
		Hotel newHotel  = new Hotel("Ridgewood", 220, 150, 5.0);
		boolean check = h.addHotel(newHotel);
		Assert.assertEquals(check, true);
	}
	@Test
	public void findTheCheapestHotel() {
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110 , 90, 3.0);
		Hotel h2 = new Hotel("Bridgewood", 160, 50, 4.0);
		Hotel h3 = new Hotel("Ridgewood", 220, 150, 5.0);
		h.addHotel(h1);
		h.addHotel(h2);
		h.addHotel(h3);
		Date start = null;
		Date end = null;
		try {
			start = new SimpleDateFormat("ddMMyyyy").parse("08-10-2020");
			end = new SimpleDateFormat("ddMMyyyy").parse("12-10-2020");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Hotel hotel = h.findCheapestHotelInAGivenDateRange(start, end, 3);

		Assert.assertEquals("Lakewood", hotel.getHotelName());
	}
	
	@Test
	public void findTheCheapestHotelWithRating() {
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110 , 90, 3.0);
		Hotel h2 = new Hotel("Bridgewood", 160, 50, 4.0);
		Hotel h3 = new Hotel("Ridgewood", 220, 150, 5.0);
		h.addHotel(h1);
		h.addHotel(h2);
		h.addHotel(h3);
		Date start = null;
		Date end = null;
		try {
			start = new SimpleDateFormat("ddMMyyyy").parse("11-09-2020");
			end = new SimpleDateFormat("ddMMyyyy").parse("12-09-2020");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		long weekDays = h.countWeekDays(start, end);
		Hotel hotel = h.findCheapestHotelInAGivenDateRange(start, end, weekDays);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}
	


}
