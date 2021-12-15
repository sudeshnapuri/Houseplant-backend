package com.bae.houseplants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.houseplants.domain.Houseplant;

@Repository
public interface HouseplantRepository extends JpaRepository<Houseplant, Integer> {
	
	List<Houseplant> getAllByPlantName(String plantName);

}
