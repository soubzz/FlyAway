package com.flyaway.dao;

import java.util.List;

import com.flyaway.bean.Location;

public interface LocationDao {
	
	public boolean saveLocation(Location location);
	public boolean deleteLocation(long locationId);
	public List<Location> getAllLocations();
}
