package ro.touristzone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.touristzone.model.Pin;

@Service
public interface PinService {

	// pin list
	List <Pin> getPinList();
    
	// pin by id
	Pin getPinById(Long id);
    
	 // save pin
	void savePin(Pin pin);
    
	// delete pin
	void deletePin(Long id);
}
