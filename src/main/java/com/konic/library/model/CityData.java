package com.konic.library.model;

import java.util.List;

public class CityData {
    private String city;
    private String country;
    private List<PopulationCount> populationCounts;

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public List<PopulationCount> getPopulationCounts() { return populationCounts; }
    public void setPopulationCounts(List<PopulationCount> populationCounts) { this.populationCounts = populationCounts; }
}
