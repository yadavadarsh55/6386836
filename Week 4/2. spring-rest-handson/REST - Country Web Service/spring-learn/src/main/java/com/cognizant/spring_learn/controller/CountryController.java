package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.models.Country; // Import the Country class
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);


    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.debug("Inside CountryController getCountryIndia() method.");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = (Country) context.getBean("country", Country.class);
        LOGGER.debug("Returning Country: {}", country.toString());
        return country;
    }
}
