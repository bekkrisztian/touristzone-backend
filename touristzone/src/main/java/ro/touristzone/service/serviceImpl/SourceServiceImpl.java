package ro.touristzone.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.touristzone.model.Source;
import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.SourceRepository;
import ro.touristzone.repository.SpectacleRepository;
import ro.touristzone.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService {
	
	@Autowired
	SourceRepository sourceRepository;
	
	@Autowired
	SpectacleRepository spectacleRepository;

	// find all
	@Override
	public List<Source> getSourceList() {
		return sourceRepository.findAll();
	}

	// get by id
	@Override
	public Source getSourceById(Long id) {
		return sourceRepository.findById(id).get();
	}

	// save
	@Override
	public void saveSource(Source source) {
		sourceRepository.save(source);
	}

	// delete
	@Override
	public void deleteSource(Long id) {
		sourceRepository.deleteById(id);
	}

	// save sources
	@Override
	public void saveSourceBySpectacleId(Source[] sources, Long id) throws Exception {
		
		for (int i = 0; i < sources.length; i++) {
		
			Source source = new Source();
			
			source.setName(sources[i].getName());
			source.setSource(sources[i].getSource());
			
			Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
	        source.setSpectacle(spectacle);
	        
	        sourceRepository.save(source).getId();
		}
	}

	// save by spectacle id
	@Override
	public void saveSourceBySpectacleId(Source sources, Long id) throws Exception {
		Source source = new Source();
		
		source.setName(sources.getName());
		source.setSource(sources.getSource());
		
		Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
        source.setSpectacle(spectacle);
        
        sourceRepository.save(source).getId();
	}
}