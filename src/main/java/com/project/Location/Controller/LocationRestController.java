package com.project.Location.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Location.Entities.Location;
import com.project.Location.Repository.LocationRepo;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	
	@Autowired
	LocationRepo repo;
	
	@GetMapping
	public List<Location> getLocations(Location location)
	{
		return repo.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location)
	{
		return repo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location)
	{
		return repo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id)
	{
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Location> GetOneLocation(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
}
