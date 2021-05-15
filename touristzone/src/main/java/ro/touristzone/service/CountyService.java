package ro.touristzone.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ro.touristzone.model.County;

@Service
public interface CountyService {
	// county list
    List <County> getCountyList();
    
    // county by id
    County getCountyById(Long id);
    
    // save county
    void saveCounty(County county);
    
    // delete county
    void deleteCounty(Long id);
}