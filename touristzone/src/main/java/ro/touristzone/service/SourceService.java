package ro.touristzone.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ro.touristzone.model.Source;

@Service
public interface SourceService {   
	
	// source list
    List <Source> getSourceList();
    
    // source by id
    Source getSourceById(Long id);
    
    // save source
    void saveSource(Source source);
    
    // delete source
    void deleteSource(Long id);
	
    // save sources by spectacle id
    void saveSourceBySpectacleId(Source[] sources, Long id) throws Exception;
	
    // save source by spectacle id
    void saveSourceBySpectacleId(Source source, Long id) throws Exception;
}