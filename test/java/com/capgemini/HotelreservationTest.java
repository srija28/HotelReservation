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
		Hotel newHotel  = new Hotel("Ridgewood", 220, 150, 100, 40, 5.0);
		boolean check = h.addHotel(newHotel);
		Assert.assertEquals(check, true);
	}
	
	


}
