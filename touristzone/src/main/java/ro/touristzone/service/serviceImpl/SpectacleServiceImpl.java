package ro.touristzone.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.SpectacleRepository;
import ro.touristzone.service.SpectacleService;

@Service
public class SpectacleServiceImpl implements SpectacleService {

	@Autowired
    SpectacleRepository spectacleRepository;

	// find all
    @Override
    public List<Spectacle> getSpectacleList() {
        return spectacleRepository.findAll();
    }

    // get by id
    @Override
    public Spectacle getSpectacleById(Long id) {
        return spectacleRepository.findById(id).get();
    }

    // save
    @Override
    public void saveSpectacle(Spectacle spectacle) {
        spectacleRepository.save(spectacle);
    }

    // delete
    @Override
    public void deleteSpectacle(Long id) {
        spectacleRepository.deleteById(id);
    }
}