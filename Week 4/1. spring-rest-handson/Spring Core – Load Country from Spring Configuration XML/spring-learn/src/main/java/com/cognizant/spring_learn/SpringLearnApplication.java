package com.cognizant.spring_learn;

import com.cognizant.spring_learn.models.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {


	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {

		LOGGER.debug("Starting SpringLearnApplication main method...");

		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountry();

		LOGGER.debug("SpringLearnApplication main method finished.");
	}

	public static void displayCountry() {
		LOGGER.debug("Starting displayCountry method...");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());

		LOGGER.debug("displayCountry method finished.");
	}
}
