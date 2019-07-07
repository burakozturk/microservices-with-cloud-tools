package org.example.microservices.cloud.tools.service.country.endpoint;

import org.example.microservices.cloud.tools.service.country.data.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CountryController {

    @GetMapping("/find/{id}")
    Country findById(@PathVariable("id") Integer id);

    @GetMapping("/find-with-cities/{id}")
    Country findByIdWithCities(@PathVariable("id") Integer id);

    @GetMapping("/find/all")
    List<Country> getAll();

    @PostMapping("/add")
    Country add(@RequestBody Country country);

}
