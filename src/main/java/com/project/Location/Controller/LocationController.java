package com.project.Location.Controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Location.Entities.Location;
import com.project.Location.Repository.LocationRepo;
import com.project.Location.Service.LocationService;
import com.project.Location.Utility.EmailUtil;
import com.project.Location.Utility.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService impl;
	
	@Autowired
	EmailUtil email;
	
	@Autowired
	LocationRepo repo;
	
	@Autowired
	ReportUtil report;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/show")
	String show(Location location,HttpServletRequest req)
	{
		req.setAttribute("location", location);
		return "Show";
	}
	
	@RequestMapping("/save")
	String save(Location location)
	{
		impl.saveLocation(location);
		//email.sendMail("goel.ayushi.2505@gmail.com", "TEST MAIL", "This is a message generated from my location Web Project");   //This is used to send mail but it takes time to send so it is commented.
		return "Show";
	}
	
	@RequestMapping("/display")
	String display(Location location, HttpServletRequest req)
	{
		List<Location> loc = impl.getAllLocation(location);
		req.setAttribute("loc", loc);
		return "displayLoc";
	}
	
	@RequestMapping("/del")
	String deletebyId(@RequestParam("id")int id, HttpServletRequest req)
	{
		Location location = impl.getLocationById(id);
		impl.deletLocation(location);
		List<Location> loc = impl.getAllLocation(location);
		req.setAttribute("loc", loc);
		return "displayLoc";
	}
	
	@RequestMapping("/edit")
	String updateLocation(@RequestParam("id")int id, HttpServletRequest req)
	{
		Location location = impl.getLocationById(id);
		//List<Location> loc = impl.getAllLocation(location);
		req.setAttribute("loc", location);
		return "editLocation";
	}
	
	@RequestMapping("/update")
	String editLocation(Location location, HttpServletRequest req)
	{
		impl.updateLocation(location);
		List<Location> loc = impl.getAllLocation(location);
		req.setAttribute("loc", loc);
		return "displayLoc";
	}
	
	@RequestMapping("/chart")
	String generateChart()
	{
		String path = sc.getRealPath("/");
		List<Object[]> data = repo.findTypeAndCountType();
		report.generatePieChart(path, data);
		return "piechart";
	}
	
}
