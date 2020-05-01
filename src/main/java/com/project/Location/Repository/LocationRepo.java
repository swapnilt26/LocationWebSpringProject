package com.project.Location.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Location.Entities.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {
	
	@Query(value="select type,count(type) from location group by type", nativeQuery = true) //if value= and nativeQuery = true is removed then it will throw illegalArgument exception
	public List<Object[]> findTypeAndCountType();

}
