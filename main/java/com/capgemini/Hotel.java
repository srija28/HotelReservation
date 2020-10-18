package com.capgemini;

public class Hotel {
	private String hotelName;
	private int regularCustomerRate;
	private int regularCustomerRateForWeekend;
	private int rewardCustomerRateForWeekday;
	private int rewardCustomerRateForWeekend;
	private double rating;
	private long totalRate;
	
	public Hotel(String hotelName, int regularCustomerRate, int regularCustomerRateForWeekend, int rewardCustomerRateForWeekday, int rewardCustomerRateForWeekend, double rating) {
		this.hotelName=hotelName;
		this.regularCustomerRate = regularCustomerRate;
		this.regularCustomerRateForWeekend = regularCustomerRateForWeekend;
		this.rewardCustomerRateForWeekday = rewardCustomerRateForWeekday;
		this.rewardCustomerRateForWeekend = rewardCustomerRateForWeekend;
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
	
	public int getRewardCustomerRateForWeekday() {
		return rewardCustomerRateForWeekday;
	}

	public void setRewardCustomerRateForWeekday(int rate) {
		this.rewardCustomerRateForWeekday = rate;
	}

	public int getRewardCustomerRateForWeekend() {
		return rewardCustomerRateForWeekend;
	}

	public void setRewardCustomerRateForWeekend(int rate) {
		this.rewardCustomerRateForWeekend = rate;
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
		return "Hotel [hotelName=" + hotelName + ", regularCustomerRate=" + regularCustomerRate
				+ ", regularCustomerRateForWeekend=" + regularCustomerRateForWeekend + ", rewardCustomerRateForWeekday="
				+ rewardCustomerRateForWeekday + ", rewardCustomerRateForWeekend=" + rewardCustomerRateForWeekend
				+ ", rating=" + rating + "]";
	}

}
