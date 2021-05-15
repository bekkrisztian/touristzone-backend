package ro.touristzone.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Other;
import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.OtherRepository;
import ro.touristzone.repository.SpectacleRepository;
import ro.touristzone.service.OtherService;

@Service
public class OtherServiceImpl implements OtherService {
	
	@Autowired
	OtherRepository otherRepository;
	
	@Autowired
	SpectacleRepository spectacleRepository;

	// find all
	@Override
	public List<Other> getOtherList() {
		return otherRepository.findAll();
	}

	// get by id
	@Override
	public Other getOtherById(Long id) {
		return otherRepository.findById(id).get();
	}

	// save
	@Override
	public void saveOther(Other other) {
		otherRepository.save(other);
	}

	// delete
	@Override
	public void deleteOther(Long id) {
		otherRepository.deleteById(id);
	}

	// save others
	@Override
	public void saveOtherBySpectacleId(Other[] others, Long id) throws Exception {
		for (int i = 0; i < others.length; i++) {
			
			Other other = new Other();
			
			other.setName(others[i].getName());
			other.setSource(others[i].getSource());
			
			Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
			other.setSpectacle(spectacle);
	        
	        otherRepository.save(other).getId();
		}
		
	}

	// save by spectacle id
	@Override
	public void saveOtherBySpectacleId(Other others, Long id) throws Exception {
		Other other = new Other();
		
		other.setName(others.getName());
		other.setSource(others.getSource());
		
		Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
		other.setSpectacle(spectacle);
        
        otherRepository.save(other).getId();
	}
}