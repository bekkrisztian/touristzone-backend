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

import ro.touristzone.model.Opinion;
import ro.touristzone.repository.OpinionRepository;
import ro.touristzone.service.OpinionService;

@RestController
@RequestMapping("/api/v1")
public class OpinionController {

	// opinion repository implementation
	@Autowired
	OpinionRepository opinionRepository;
	
	// opinion service implementation
	@Autowired
	OpinionService opinionService;
	
	// display list of opinions
	@RequestMapping("/opinions")
    public List<Opinion> getOpinionList() {
        return opinionRepository.findAll();
    }
	
	// get opinion by id
	@GetMapping("/opinions/{id}")
    public ResponseEntity<Opinion> getOpinion(@PathVariable Long id) {
        return new ResponseEntity<Opinion>(opinionService.getOpinionById(id), HttpStatus.OK);
    }

	// save opinion
    @PostMapping("/opinions/save")
    public ResponseEntity<Void> saverOrUpdateOpinion(@RequestBody Opinion opinion) {
        opinionService.saveOpinion(opinion);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // delete opinion by id rest api
    @DeleteMapping("/opinions/delete/{id}")
    public ResponseEntity<Void> deleteOpinion(@PathVariable Long id) {
        opinionService.deleteOpinion(id);;
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
