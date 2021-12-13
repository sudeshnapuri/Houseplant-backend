package com.bae.houseplants.web;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:houseplant-schema.sql",
"classpath:houseplant-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class HouseplantControllerIntegrationTest {

}
