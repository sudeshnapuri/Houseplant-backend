package com.bae.houseplants.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.houseplants.domain.Houseplant;
import com.bae.houseplants.service.HouseplantService;



@RestController 

public class HouseplantController {

private HouseplantService service;
	
	@Autowired
	
	public HouseplantController(HouseplantService service) {
	super();
	this.service = service;
	}
	
	
// CREATE
	@PostMapping("/create")
	public ResponseEntity<Houseplant> createHouseplant(@RequestBody Houseplant plant) {
		Houseplant created = this.service.createHouseplant(plant);
		ResponseEntity<Houseplant> response = new ResponseEntity<Houseplant>(created, HttpStatus.CREATED);
		return response;
	}
		
// READ ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<Houseplant>> getAllPlants() {
		return ResponseEntity.ok(this.service.getAllPlants());
	}

// READ BY ID	
	@GetMapping("/get/{id}")
	public Houseplant getPlant(@PathVariable Integer id) {
		return this.service.getPlant(id);
	}
		

// UPDATE BY ID	
	@PutMapping("/replace/{id}")
	public ResponseEntity<Houseplant> replacePlant(@PathVariable Integer id, @RequestBody Houseplant newPlant) {
		Houseplant body = this.service.replacePlant(id, newPlant);
		ResponseEntity<Houseplant> response = new ResponseEntity<Houseplant>(body, HttpStatus.ACCEPTED);
		return response;
	}

// DELETE BY ID	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Houseplant> removePlant(@PathVariable Integer id) {
		this.service.removePlant(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
