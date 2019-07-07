package org.example.microservices.cloud.tools.service.city.endpoint;

import org.example.microservices.cloud.tools.service.city.data.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CityController {

    @GetMapping("/find/{id}")
    City findById(@PathVariable("id") Integer id) ;

    @GetMapping("/find-by-country/{id}")
    List<City> findByCountryId(@PathVariable("id") Integer id);

    @GetMapping("/find/all")
    List<City> getAll();

    @PostMapping("/add")
    City add(@RequestBody City city);

}
