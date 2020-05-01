package com.project.Location.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Location.Entities.Location;
import com.project.Location.Repository.LocationRepo;

@Service
public class LocationImpl implements LocationService {

	@Autowired
	LocationRepo repo;
	
	public Location saveLocation(Location location) {
		return repo.save(location);
	}

	public Location updateLocation(Location location) {
		return repo.save(location);
	}

	public void deletLocation(Location location) {
		repo.delete(location);
	}

	public Location getLocationById(int id) {
		return repo.findById(id).get();
	}

	public List<Location> getAllLocation(Location location) {
		return repo.findAll();
	}
	
	
}
