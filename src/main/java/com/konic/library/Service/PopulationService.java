package com.konic.library.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.konic.library.model.CityData;
import com.konic.library.model.PopulationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PopulationService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public PopulationService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public CityData getCityPopulation(String cityName) {
        // External API endpoint for city-level population
        String url = "https://countriesnow.space/api/v0.1/countries/population/cities";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            // Convert JSON string → Java object
            PopulationResponse populationResponse =
                    objectMapper.readValue(response.getBody(), PopulationResponse.class);

            List<CityData> allCities = populationResponse.getData();
//allCities.stream().filter(cityData -> cityData.getCountry().equalsIgnoreCase(cityName)).c.
            // Loop through all city data to find the selected city
            for (CityData city : allCities) {
                if (city.getCity().equalsIgnoreCase(cityName)) {
                    return city; // return that city object
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}