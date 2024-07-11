package com.example.backend_podedex;

import com.example.backend_podedex.model.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class BackendPodedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPodedexApplication.class, args);
	}


}
