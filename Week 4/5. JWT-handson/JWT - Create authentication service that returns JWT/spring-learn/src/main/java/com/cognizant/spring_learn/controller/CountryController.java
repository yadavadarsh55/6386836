package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.models.Country;
import com.cognizant.spring_learn.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping("/country") // Using @RequestMapping for consistency with previous hands-on
    public Country getCountryIndia() {
        LOGGER.debug("Inside CountryController getCountryIndia() method.");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = (Country) context.getBean("country", Country.class);
        LOGGER.debug("Returning Country: {}", country.toString());
        return country;
    }


    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.debug("Inside CountryController getAllCountries() method.");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countries = (List<Country>) context.getBean("countryList");

        LOGGER.debug("Returning Countries: {}", countries);

        return countries;
    }

    @GetMapping("/countries/{code}") // Maps HTTP GET requests to /countries/{code} to this method
    public Country getCountry(@PathVariable String code) {
        LOGGER.debug("Inside CountryController getCountry() method for code: {}", code);

        // Delegate the logic to the CountryService
        Country country = countryService.getCountry(code);

        // If the service returns null (country not found), throw a 404 Not Found exception
        if (country == null) {
            LOGGER.error("Country with code '{}' not found, throwing 404.", code);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found for code: " + code);
        }

        LOGGER.debug("Returning specific Country: {}", country.toString());
        return country;
    }
}
