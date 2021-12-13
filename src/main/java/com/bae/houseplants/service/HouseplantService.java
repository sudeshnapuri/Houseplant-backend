
package com.bae.houseplants.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bae.houseplants.domain.Houseplant;


@Service
public interface HouseplantService {
	
	Houseplant createHouseplant(Houseplant plant);
	
	List<Houseplant> getAllPlants();
	
	Houseplant getPlant(Integer id);
	
	Houseplant replacePlant(Integer id, Houseplant newPlant);
	
	void removePlant(@PathVariable Integer id);


}

