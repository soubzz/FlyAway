package com.flyaway.dao;

import java.util.List;

import com.flyaway.bean.Booking;

public interface BookingDao {
	
	public long saveBooking(Booking booking);
	public boolean deleteBooking(long bookingID);
	public List<Booking> getAllBooking();
	public void updateBooking(Booking booking);

}
