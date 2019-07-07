package org.example.microservices.cloud.tools.service.country.controller;

import org.example.microservices.cloud.tools.service.country.client.CityClient;
import org.example.microservices.cloud.tools.service.country.data.City;
import org.example.microservices.cloud.tools.service.country.data.Country;
import org.example.microservices.cloud.tools.service.country.endpoint.CountryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryControllerImpl implements CountryController {

    private List<Country> countries = new ArrayList<>();

    @Autowired
    CityClient cityClient;

    @PostConstruct
    public void init() {

        this.countries.add(new Country(1, "Turkey"));
        this.countries.add(new Country(2, "Greece"));
        this.countries.add(new Country(3, "Italy"));
        this.countries.add(new Country(4, "France"));
        this.countries.add(new Country(5, "Spain"));

    }

    @Override
    public Country findById(Integer id) {
        return countries.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Country findByIdWithCities(Integer id) {

        Optional<Country> countryOptional = countries.stream().filter(c -> c.getId().equals(id)).findFirst();
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            List<City> cities = this.cityClient.findByCountryId(id);
            country.setCities(cities);
            return country;
        }

        return null;
    }

    @Override
    public List<Country> getAll() {
        return countries;
    }

    @Override
    public Country add(Country country) {
        country.setId(countries.size() + 1);
        countries.add(country);
        return country;
    }
}
