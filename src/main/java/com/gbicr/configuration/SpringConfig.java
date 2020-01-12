package com.gbicr.configuration;

import com.gbicr.services.*;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    @Bean
    public KomselService komselService() {
        return new KomselServiceImpl();
    }

    @Bean
    public GenderService genderService() {
        return new GenderServiceImpl();
    }

    @Bean
    public StatusPersonService statusPersonService() {
        return new StatusPersonServiceImpl();
    }

    @Bean
    public StatusCongregationService statusCongregationService() {
        return new StatusCongregationServiceImpl();
    }

    @Bean
    public WorshipService worshipService() {
        return new WorshipServiceImpl();
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Bean
    public FamilyService familyService() {
        return new FamilyServiceImpl();
    }
}
