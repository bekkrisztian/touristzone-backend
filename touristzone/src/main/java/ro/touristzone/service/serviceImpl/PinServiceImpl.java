package ro.touristzone.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Pin;
import ro.touristzone.repository.PinRepository;
import ro.touristzone.service.PinService;

@Service
public class PinServiceImpl implements PinService {
	
	@Autowired
	PinRepository pinRepository;
	
	// find all
	@Override
	public List<Pin> getPinList() {
		return pinRepository.findAll();
	}

	// get by id
	@Override
	public Pin getPinById(Long id) {
		return pinRepository.findById(id).get();
	}

	// save
	@Override
	public void savePin(Pin pin) {
		pinRepository.save(pin);
	}

	// delete
	@Override
	public void deletePin(Long id) {
		pinRepository.deleteById(id);
	}
}