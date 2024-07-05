package de.iamcrypta.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepageApplication.class, args);
	}

}

/**
 * TODO: Maybe abstract logic from sooooos to all spotify playlists?? :(
 * TODO: Check of all autowire is passed through constructor
 * TODO: Check for null on various places when saving to databases
 */