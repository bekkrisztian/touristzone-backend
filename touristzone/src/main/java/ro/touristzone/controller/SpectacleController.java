package ro.touristzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.SpectacleRepository;
import ro.touristzone.service.SpectacleService;


@RestController
@RequestMapping("/api/v1")
public class SpectacleController {
    
	// spectacle repository implementation
    @Autowired
    SpectacleRepository spectacleRepository;

    // spectacle service implementation
    @Autowired
    SpectacleService spectacleService;
    
    // display list of spectacles
    @RequestMapping("/spectacles")
    public List<Spectacle> getSpectacleList() {
        return spectacleRepository.findAll();
    }

    // get spectacle by id
    @GetMapping("/spectacles/{id}")
    public ResponseEntity<Spectacle> getSpectacle(@PathVariable Long id) {
        return new ResponseEntity<Spectacle>(spectacleService.getSpectacleById(id), HttpStatus.OK);
    }

    // save spectacle
    @PostMapping("/spectacles/save")
    public ResponseEntity<Void> saveSpectacle(@RequestBody Spectacle spectacle) {
        spectacleService.saveSpectacle(spectacle);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // update spectacle
    @PutMapping("/spectacles/save/{id}")
    Spectacle updateSpectacle(@RequestBody Spectacle newSpectacle, @PathVariable Long id) {
      
      return spectacleRepository.findById(id)
        .map(spectacle -> {
        	spectacle.setName(newSpectacle.getName());
        	spectacle.setLatitude(newSpectacle.getLatitude());
        	spectacle.setLongitude(newSpectacle.getLongitude());
        	spectacle.setCounty(newSpectacle.getCounty());
        	spectacle.setDescription(newSpectacle.getDescription());
        	spectacle.setHistory(newSpectacle.getHistory());
        	spectacle.setPin(newSpectacle.getPin());
          return spectacleRepository.save(spectacle);
        })
        .orElseGet(() -> {
        	newSpectacle.setId(id);
        	return spectacleRepository.save(newSpectacle);
        });
    }

    // delete spectacle by id
    @DeleteMapping("/spectacles/delete/{id}")
    public ResponseEntity<Void> deleteSpectacle(@PathVariable Long id) {
        spectacleService.deleteSpectacle(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    // search spectacle by name
    @RequestMapping("/spectacles/searchbykeyword")
    public Page<Spectacle> searchByKeyword(@RequestParam String keyword, Pageable pageable) {
    	if(keyword != null) {
			return spectacleRepository.findByNameContainingIgnoreCase(keyword, pageable);
		}
		return null;
    }
    
    // find spectacle by county id
	@RequestMapping("/spectacles/findByCountyId")
    public Page<Spectacle> findByCountyId(@RequestParam Long id, Pageable pageable) {
    	if(id != null) {
			return spectacleRepository.findByCountyId(id, pageable);
		}
		return null;
    }
	
	// find spectacle by country id
	@RequestMapping("/spectacles/findByCountryId")
    public Page<Spectacle> findByCountryId(@RequestParam Long id, Pageable pageable) {
    	if(id != null) {
			return spectacleRepository.findByCountyCountryId(id, pageable);
		}
		return null;
    }
	
	// find spectacle by country id and county id
	@RequestMapping("/spectacles/findByCountryId&CountyId")
    public Page<Spectacle> findByCountryId(@RequestParam Long countryid, @RequestParam Long countyid, Pageable pageable) {
    	if(countryid != null && countyid != null) {
			return spectacleRepository.findByCountyCountryIdAndCountyId(countryid, countyid, pageable);
		}
		return null;
    }
}