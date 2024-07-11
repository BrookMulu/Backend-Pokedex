package com.example.backend_podedex;
import com.example.backend_podedex.model.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendPodedexApplicationTests {

	@Test
	void contextLoads() {
	}
	public static void main(String[] args) throws Exception {
		// Create a Pokemon object with sample data
		Pokemon pokemon = new Pokemon();
		pokemon.setId(1);
		pokemon.setName("Bulbasaur");
		// Set other fields as needed

		// Serialize the Pokemon object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(pokemon);

		// Print the JSON string
		System.out.println(json);
	}

}
