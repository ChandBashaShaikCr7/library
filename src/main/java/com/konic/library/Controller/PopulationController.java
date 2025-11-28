package com.konic.library.Controller;

import com.konic.library.Service.PopulationService;
import com.konic.library.model.CityData;
import com.konic.library.model.CountryData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PopulationController {

    private final PopulationService populationService;

    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    // Example: http://localhost:8080/api/population?city=MARIEHAMN
    @GetMapping("/population")
    public ResponseEntity<?> getCityPopulation(@RequestParam String city) {
        CityData result = populationService.getCityPopulation(city);

        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body("City not found: " + city);
        }
    }
}
