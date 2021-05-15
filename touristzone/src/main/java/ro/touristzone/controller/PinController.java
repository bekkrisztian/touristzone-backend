package ro.touristzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.touristzone.model.Pin;
import ro.touristzone.repository.PinRepository;
import ro.touristzone.service.PinService;

@RestController
@RequestMapping("/api/v1")
public class PinController {

	// pin repository implementation
	@Autowired
	PinRepository pinRepository;
	
	// pin service implementation
	@Autowired
	PinService pinService;
	
	// display list of pins
	@RequestMapping("/pins")
    public List<Pin> getPinList() {
        return pinRepository.findAll();
    }

	// get pin by id
    @GetMapping("/pins/{id}")
    public ResponseEntity<Pin> getPin(@PathVariable Long id) {
        return new ResponseEntity<Pin>(pinService.getPinById(id), HttpStatus.OK);
    }

    // save pin
    @PostMapping("/pins/save")
    public ResponseEntity<Void> saverOrUpdatePin(@RequestBody Pin pin) {
        pinService.savePin(pin);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // delete pin by id rest api
    @DeleteMapping("/pins/delete/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id) {
        pinService.deletePin(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}