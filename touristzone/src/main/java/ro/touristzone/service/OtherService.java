package ro.touristzone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.touristzone.model.Other;

@Service
public interface OtherService {   
	// other list
    List <Other> getOtherList();
    
    // other by id
    Other getOtherById(Long id);
    
    // save other
    void saveOther(Other other);
    
    // delete other
    void deleteOther(Long id);
    
    // save others by spectacle id
    void saveOtherBySpectacleId(Other[] others, Long id) throws Exception;
    
    // save other by spectacle id
    void saveOtherBySpectacleId(Other other, Long id) throws Exception;
}