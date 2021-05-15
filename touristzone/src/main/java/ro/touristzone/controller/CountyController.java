package ro.touristzone.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.touristzone.model.County;
import ro.touristzone.repository.CountyRepository;
import ro.touristzone.service.CountyService;

@RestController
@RequestMapping("/api/v1")
public class CountyController {
    
	// county service implementation
    @Autowired
    CountyService countyService;

    // county repository implementation
    @Autowired
    CountyRepository countyRepository;

    // display list of counties
    @RequestMapping("/counties")
    public List<County> getCountyList() {
        return countyRepository.findAll();
    }

    // get county by id
    @GetMapping("/counties/{id}")
    public ResponseEntity<County> getCounty(@PathVariable Long id) {
        return new ResponseEntity<County>(countyService.getCountyById(id), HttpStatus.OK);
    }

    // save county
    @PostMapping("/counties/save")
    public ResponseEntity<Void> saverOrUpdateCounty(@RequestBody County county) {
        countyService.saveCounty(county);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // update county rest api
    @PutMapping("/counties/save/{id}")
    public ResponseEntity<County> updateCounty(@PathVariable Long id, @RequestBody County countyDetails) {
        County county = countyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("County not exist with id: " + id));
        county.setName(countyDetails.getName());
        county.setCountry(countyDetails.getCountry());
        County updatedCounty = countyRepository.save(county);
        return ResponseEntity.ok(updatedCounty);
    }

    // delete country by id rest api
    @DeleteMapping("/counties/delete/{id}")
    public ResponseEntity<Void> deleteCounty(@PathVariable Long id) {
        countyService.deleteCounty(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // find county by country id
    @RequestMapping("/counties/findByCountryId")
    public List<County> findByCountyId(@RequestParam Long id) {
    	if(id != null) {
			return countyRepository.findByCountryId(id);
		}
		return countyRepository.findAll();
    }
}