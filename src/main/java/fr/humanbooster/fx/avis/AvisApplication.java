package fr.humanbooster.fx.avis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AvisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvisApplication.class, args);
	}

}
