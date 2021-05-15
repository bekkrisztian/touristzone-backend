package ro.touristzone.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ro.touristzone.model.Country;

@Service
public interface CountryService {
	// country list
    List <Country> getCountryList();
    
    // country by id
    Country getCountryById(Long id);
    
    // save country
    void saveCountry(Country country);
    
    // delete country
    void deleteCountry(Long id);
}