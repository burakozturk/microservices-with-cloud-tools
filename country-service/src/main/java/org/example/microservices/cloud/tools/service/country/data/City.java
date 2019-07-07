package org.example.microservices.cloud.tools.service.country.data;

public class City {

    private Integer id;
    private String name;
    private Integer countryId;

    public City() {
    }

    public City(Integer id, String name, Integer countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
