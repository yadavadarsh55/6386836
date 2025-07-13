package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.models.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

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
}
