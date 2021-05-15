package ro.touristzone.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.touristzone.model.County;
import ro.touristzone.repository.CountyRepository;
import ro.touristzone.service.CountyService;

@Service
public class CountyServiceImpl implements CountyService {
	
	@Autowired
    private CountyRepository countyRepository;

	// find all
	@Override
    public List<County> getCountyList() {
        return countyRepository.findAll();
    }

	// get by id
    @Override
    public County getCountyById(Long id) {
        return countyRepository.findById(id).get();
    }

	// save
    @Override
    public void saveCounty(County county) {
        countyRepository.save(county);
    }

	// delete
    @Override
    public void deleteCounty(Long id) {
        countyRepository.deleteById(id);
    }
}