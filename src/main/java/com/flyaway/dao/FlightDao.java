package com.flyaway.dao;

import java.util.List;

import com.flyaway.bean.Flight;

public interface FlightDao {
	
	public boolean saveFlight(Flight flight);
	public boolean deleteFlight(long flightId);
	public Flight getFlight(long flightId);
	public List<Flight> getAllFlights();

}
