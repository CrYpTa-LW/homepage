package de.iamcrypta.homepage;

import de.iamcrypta.homepage.scheduledTask.ScheduledTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepageApplication.class, args);
		Logger logger = LoggerFactory.getLogger(HomepageApplication.class);
		logger.info("Homepage Backend Version 1.0");
	}

}
