package ro.touristzone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.touristzone.model.Spectacle;

@Service
public interface SpectacleService {
	
	// spectacle list
    List <Spectacle> getSpectacleList();
    
    // spectacle by id
    Spectacle getSpectacleById(Long id);
    
    // save spectacle
    void saveSpectacle(Spectacle spectacle);
    
    // delete spectacle
    void deleteSpectacle(Long id);
}