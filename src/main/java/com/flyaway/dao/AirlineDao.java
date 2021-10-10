package com.flyaway.dao;

import java.util.List;

import com.flyaway.bean.Airline;

public interface AirlineDao {
	
	public boolean addAirline(String airlineName);
	public boolean deleteAirline(long airlineID);
	public List<Airline> getAllAirline();

}
