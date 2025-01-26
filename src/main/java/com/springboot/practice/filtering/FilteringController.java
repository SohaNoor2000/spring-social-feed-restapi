package com.springboot.practice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    Person person = new Person("Soha","Noor",29);

    @GetMapping(path = "/static-filtering")
    public Person getPersonDetails(){
        return person;
    }

    @GetMapping(path = "/dynamic-filtering")
    public MappingJacksonValue getFiteredItems(){
        Person person1 = new Person("Soha","Noor",29);

        MappingJacksonValue mapping= new MappingJacksonValue(person1);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName");

        FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFilter",filter);

        mapping.setFilters(filters);

        return mapping;
    }
}
