package ro.touristzone.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.touristzone.model.Country;
import ro.touristzone.repository.CountryRepository;
import ro.touristzone.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // find all
	@Override
	public List<Country> getCountryList() {
		return countryRepository.findAll();
	}

	// get by id
	@Override
	public Country getCountryById(Long id) {
		return countryRepository.findById(id).get();
	}

	// save
	@Override
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}

	// delete
	@Override
	public void deleteCountry(Long id) {
		countryRepository.deleteById(id);
	}
}