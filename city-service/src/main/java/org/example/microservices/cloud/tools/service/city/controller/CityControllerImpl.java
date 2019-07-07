package org.example.microservices.cloud.tools.service.city.controller;

import org.example.microservices.cloud.tools.service.city.data.City;
import org.example.microservices.cloud.tools.service.city.endpoint.CityController;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityControllerImpl implements CityController {

    private List<City> cities = new ArrayList<>();

    @PostConstruct
    public void init() {

        this.cities.add(new City(1, "Ankara", 1));
        this.cities.add(new City(2, "Istanbul", 1));
        this.cities.add(new City(3, "Izmir", 1));

        this.cities.add(new City(4, "Atina", 2));
        this.cities.add(new City(5, "Thessaloniki", 2));
        this.cities.add(new City(6, "Larissa", 2));

        this.cities.add(new City(7, "Rome", 3));
        this.cities.add(new City(8, "Turin", 3));
        this.cities.add(new City(9, "Naples", 3));

        this.cities.add(new City(10, "Paris", 4));
        this.cities.add(new City(11, "Marseille", 4));
        this.cities.add(new City(12, "Lyon", 4));

        this.cities.add(new City(13, "Madrid", 5));
        this.cities.add(new City(14, "Barcelona", 5));
        this.cities.add(new City(15, "Valencia", 5));

    }

    @Override
    public City findById(Integer id) {
        return cities.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<City> findByCountryId(Integer id) {
        return cities.stream().filter(c -> c.getCountryId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<City> getAll() {
        return cities;
    }

    @Override
    public City add(City city) {
        city.setId(cities.size() + 1);
        cities.add(city);
        return city;
    }
}
