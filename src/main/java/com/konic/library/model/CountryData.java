package com.konic.library.model;

import java.util.List;

public class CountryData {

    private String country;
    private String code;
    private String iso3;
    private List<PopulationCount> populationCounts;

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getIso3() { return iso3; }
    public void setIso3(String iso3) { this.iso3 = iso3; }

    public List<PopulationCount> getPopulationCounts() { return populationCounts; }
    public void setPopulationCounts(List<PopulationCount> populationCounts) { this.populationCounts = populationCounts; }
}
