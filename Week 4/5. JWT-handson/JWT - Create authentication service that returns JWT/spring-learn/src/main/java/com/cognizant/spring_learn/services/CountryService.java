package com.cognizant.spring_learn.services;
import com.cognizant.spring_learn.models.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service; // Import @Service

import java.util.List;
import java.util.Optional; // Import Optional for cleaner handling of null

@Service // Marks this class as a Spring Service component
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {
        LOGGER.debug("Inside CountryService getCountry() method for code: {}", code);

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries = (List<Country>) context.getBean("countryList");

        Optional<Country> foundCountry = countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code)) // Case-insensitive comparison
                .findFirst();

        if (foundCountry.isPresent()) {
            LOGGER.debug("Found Country: {}", foundCountry.get().toString());
            return foundCountry.get();
        } else {
            LOGGER.warn("Country with code '{}' not found.", code);
            return null;
        }
    }
}