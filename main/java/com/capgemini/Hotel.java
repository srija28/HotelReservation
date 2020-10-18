package com.capgemini;

public class Hotel {
	private String hotelName;
	private int regularCustomerRate;
	private int regularCustomerRateForWeekend;
	private double rating;
	private long totalRate;
	
	public Hotel(String hotelName, int regularCustomerRate, int regularCustomerRateForWeekend, double rating) {
		this.hotelName=hotelName;
		this.regularCustomerRate = regularCustomerRate;
		this.regularCustomerRateForWeekend = regularCustomerRateForWeekend;
		this.rating=rating;
		this.totalRate = 0;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerRate() {
		return regularCustomerRate;
	}

	public void setRegularCustomerRate(int rate) {
		this.regularCustomerRate = rate;
	}
	
	public int getRegularCustomerRateForWeekend() {
		return regularCustomerRateForWeekend;
	}

	public void setRegularCustomerRateForWeekend(int rate) {
		this.regularCustomerRateForWeekend = rate;
	}
	
	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long rate) {
		this.totalRate = rate;
	}
	
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "\nHotel Name: " + hotelName + "\nHotel rates for a regular customer: " + regularCustomerRate
				+ "$ \n For Weekends: " + regularCustomerRateForWeekend + "$ \nRating: " + rating + "/5.0 ";
	}

}
