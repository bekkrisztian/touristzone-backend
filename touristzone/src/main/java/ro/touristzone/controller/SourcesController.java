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

import ro.touristzone.model.Other;
import ro.touristzone.model.Source;
import ro.touristzone.repository.OtherRepository;
import ro.touristzone.repository.SourceRepository;
import ro.touristzone.service.OtherService;
import ro.touristzone.service.SourceService;

@RestController
@RequestMapping("/api/v1")
public class SourcesController {

	// source service implementation
	@Autowired
	SourceService sourceService;
	
	// source repository implementation
	@Autowired
	SourceRepository sourceRepository;
	
	// source service implementation
	@Autowired
	OtherService otherService;
	
	// other repository implementation
	@Autowired
	OtherRepository otherRepository;
	
	// display list of sources
	@RequestMapping("/sources")
    public List<Source> getSpectacleSourceList() {
        return sourceRepository.findAll();
    }

	// get source by id
    @GetMapping("/sources/{id}")
    public ResponseEntity<Source> getSource(@PathVariable Long id) {
        return new ResponseEntity<Source>(sourceService.getSourceById(id), HttpStatus.OK);
    }

    // save source
    @PostMapping("/sources/save")
    public ResponseEntity<Void> saverOrUpdateSource(@RequestBody Source source) {
        sourceService.saveSource(source);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // save sources by spectacle id
    @PostMapping("/sources/save/{id}")
    public ResponseEntity<Void> saveSource(@RequestBody Source[] sources, @PathVariable Long id) throws Exception {
        sourceService.saveSourceBySpectacleId(sources, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // save source by spectacle id
    @PostMapping("/source/save/{id}")
    public ResponseEntity<Void> saveSource(@RequestBody Source sources, @PathVariable Long id) throws Exception {
        sourceService.saveSourceBySpectacleId(sources, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // delete source by id
    @DeleteMapping("/sources/delete/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        sourceService.deleteSource(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // display list of others
    @RequestMapping("/others")
    public List<Other> getSpectacleOtherList() {
        return otherRepository.findAll();
    }

    // get other by id
    @GetMapping("/others/{id}")
    public ResponseEntity<Other> getOther(@PathVariable Long id) {
        return new ResponseEntity<Other>(otherService.getOtherById(id), HttpStatus.OK);
    }

    // save other
    @PostMapping("/others/save")
    public ResponseEntity<Void> saverOrUpdateOther(@RequestBody Other other) {
        otherService.saveOther(other);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // save others by spectacle id
    @PostMapping("/others/save/{id}")
    public ResponseEntity<Void> saveOther(@RequestBody Other[] others, @PathVariable Long id) throws Exception {
        otherService.saveOtherBySpectacleId(others, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // save other by spectacle id
    @PostMapping("/other/save/{id}")
    public ResponseEntity<Void> saveOther(@RequestBody Other others, @PathVariable Long id) throws Exception {
        otherService.saveOtherBySpectacleId(others, id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // delete other by id
    @DeleteMapping("/others/delete/{id}")
    public ResponseEntity<Void> deleteOther(@PathVariable Long id) {
        otherService.deleteOther(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}