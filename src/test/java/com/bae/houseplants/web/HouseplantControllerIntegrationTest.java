package com.bae.houseplants.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.houseplants.domain.Houseplant;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:houseplant-schema.sql", "classpath:houseplant-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class HouseplantControllerIntegrationTest {
	 
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Houseplant testPlant = new Houseplant(null, "Parlor Palm", "Medium Demand", "Low Demand", "High Demand", 1);
		String testPlantAsJSON = this.mapper.writeValueAsString(testPlant);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testPlantAsJSON);

		Houseplant testCreatedPlant = new Houseplant(2, "Parlor Palm", "Medium Demand", "Low Demand", "High Demand", 1);
		String testCreatedPlantAsJSON = this.mapper.writeValueAsString(testCreatedPlant);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedPlantAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
	
	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");
		
		List<Houseplant> testPlant = List.of(new Houseplant(1, "Dragon Tree", "Low Demand", "Low Demand", "Low Demand", 2));
		String testPlantAsJSON = this.mapper.writeValueAsString(testPlant);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPlantAsJSON); 

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void getByIdTest() throws Exception {
		RequestBuilder req = get("/get/1");
		
		Houseplant testPlant = new Houseplant(1, "Dragon Tree", "Low Demand", "Low Demand", "Low Demand", 2);
		String testPlantAsJSON = this.mapper.writeValueAsString(testPlant);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPlantAsJSON); 

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void getByNameTest() throws Exception {
		List<Houseplant> testPlant = List.of(new Houseplant(1, "Dragon Tree", "Low Demand", "Low Demand", "Low Demand", 2));
		String testPlantAsJSON = this.mapper.writeValueAsString(testPlant);
		
		RequestBuilder req = get("/getByPlantName/Dragon Tree");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPlantAsJSON); 

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test
	void updateByIdTest() throws Exception {
		Houseplant updatePlant = new Houseplant(null, "Dracaena", "Low Demand", "Low Demand", "Low Demand", 2);
		String updatePlantAsJSON = this.mapper.writeValueAsString(updatePlant);
		
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(updatePlantAsJSON);

		Houseplant testCreatedPlant = new Houseplant(1, "Dracaena", "Low Demand", "Low Demand", "Low Demand", 2);
		String testCreatedPlantAsJSON = this.mapper.writeValueAsString(testCreatedPlant);
		ResultMatcher checkStatus = status().isAccepted(); 
		ResultMatcher checkBody = content().json(testCreatedPlantAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void removeByIdTest() throws Exception {
		RequestBuilder req = delete("/remove/1");
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
	}
	
	
}
	