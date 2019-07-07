package org.example.microservices.cloud.tools.service.country.client;

import org.example.microservices.cloud.tools.service.country.data.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "city-service")
public interface CityClient {

    @GetMapping("/find-by-country/{id}")
    List<City> findByCountryId(@PathVariable("id") Integer id);

}


