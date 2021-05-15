package ro.touristzone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.touristzone.model.Opinion;

@Service
public interface OpinionService {
	// opinion list
	List <Opinion> getOpinionList();
	
	// opinion by id
	Opinion getOpinionById(Long id);
	
	// save opinion
    void saveOpinion(Opinion opinion);
    
    // delete opinion
    void deleteOpinion(Long id);
}
