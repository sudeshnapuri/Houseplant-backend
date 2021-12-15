package com.bae.houseplants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.houseplants.domain.Houseplant;
import com.bae.houseplants.repository.HouseplantRepository;

@Service
public class HouseplantServiceDB implements HouseplantService{
	
	private HouseplantRepository repo;
	
	@Autowired
	public HouseplantServiceDB(HouseplantRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Houseplant createHouseplant(Houseplant plant) {
		Houseplant created = this.repo.save(plant); 
		return created;
	}

	@Override
	public List<Houseplant> getAllPlants() {
		return this.repo.findAll(); 
	}

	@Override
	public Houseplant getPlant(Integer id) {
		Optional<Houseplant> found = this.repo.findById(id); 
		return found.get();
	}
	
	@Override
	public List<Houseplant> getAllPlantsByName(String plantName) {
		List<Houseplant> found = this.repo.getAllByPlantName(plantName);
		return found;
	}
	
	@Override
		public void removePlant(Integer id) {
			this.repo.deleteById(id);
		}
	
	@Override
	public Houseplant replacePlant(Integer id, Houseplant newPlant) {
		Houseplant existing = this.repo.findById(id).get();

		existing.setPlantName(newPlant.getPlantName());
		existing.setWater(newPlant.getWater());
		existing.setSunlight(newPlant.getSunlight());
		existing.setHumidity(newPlant.getHumidity());
		existing.setQuantity(newPlant.getQuantity());

		Houseplant updated = this.repo.save(existing);
		return updated;
	}
	
}
