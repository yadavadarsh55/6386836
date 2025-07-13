package com.cognizant.spring_learn.models;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {


    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;


    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }


    public String getCode() {
        LOGGER.debug("Inside Country getCode() method.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside Country setCode() method. Setting code to: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside Country getName() method.");
        return name;
    }


    public void setName(String name) {
        LOGGER.debug("Inside Country setName() method. Setting name to: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        LOGGER.debug("Inside Country toString() method.");
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
