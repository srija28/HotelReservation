package com.capgemini;

import org.junit.Assert;

import org.junit.Test;


public class HotelreservationTest {
	@Test
	public void  CheckforHotelPresentorNot() {
		HotelReservation h = new HotelReservation();
		Hotel newHotel  = new Hotel("Bridgewood", 160);
		boolean check = h.addHotel(newHotel);
		Assert.assertEquals(check, true);
	}

}
