package com.project.Location.Service;

import java.util.List;

import com.project.Location.Entities.Location;

public interface LocationService {

	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	void deletLocation(Location location);
	
	Location getLocationById(int id);
	
	List<Location> getAllLocation(Location location);
	
}
