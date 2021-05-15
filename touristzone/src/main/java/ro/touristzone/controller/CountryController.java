package ro.touristzone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.touristzone.model.Country;
import ro.touristzone.repository.CountryRepository;
import ro.touristzone.service.CountryService;

@RestController
@RequestMapping("/api/v1")
public class CountryController {
    
	// country service implementation
    @Autowired
    private CountryService countryService;

    // country repository implementation
    @Autowired
    private CountryRepository countryRepository;

    // display list of countries
    @RequestMapping("/countries")
    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    // get country by id
    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable Long id) {
        return new ResponseEntity<Country>(countryService.getCountryById(id), HttpStatus.OK);
    }

    // save country
    @PostMapping("/countries/save")
    public ResponseEntity<Void> saverOrUpdateCountry(@RequestBody Country country) {
        countryService.saveCountry(country);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // update country rest api
    @PutMapping("/countries/save/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country countryDetails) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not exist with id: " + id));
        country.setName(countryDetails.getName());
        Country updatedCountry = countryRepository.save(country);
        return ResponseEntity.ok(updatedCountry);
    }

    // delete country by id rest api
    @DeleteMapping("/countries/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCountry(@PathVariable Long id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not exist with id: " + id));

        countryRepository.delete(country);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}