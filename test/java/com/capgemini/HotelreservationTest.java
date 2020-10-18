package com.capgemini;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class HotelreservationTest {
	@Test
	public void  CheckforHotelPresentorNot() {
		HotelReservation h = new HotelReservation();
		Hotel newHotel  = new Hotel("Ridgewood", 220, 150);
		boolean check = h.addHotel(newHotel);
		Assert.assertEquals(check, true);
	}
	@Test
	public void findTheCheapestHotel() {
		HotelReservation h = new HotelReservation();
		Hotel h1 = new Hotel("Lakewood", 110 , 90);
		Hotel h2 = new Hotel("Bridgewood", 160, 50);
		Hotel h3 = new Hotel("Ridgewood", 220, 150);
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
	


}
