package ro.touristzone.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import ro.touristzone.model.Cover;
import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.CoverRepository;
import ro.touristzone.repository.SpectacleRepository;

@Service
public class CoverServiceImpl {
	
	@Autowired
	CoverRepository coverRepository;
	
	@Autowired
	SpectacleRepository spectacleRepository;
	
	// save
	public void save(MultipartFile file, @PathVariable Long id) throws Exception {
	    Cover cover = new Cover();
	    cover.setName(StringUtils.cleanPath(file.getOriginalFilename()));
	    cover.setContentType(file.getContentType());
	    cover.setData(file.getBytes());
	    cover.setSize(file.getSize());
	    
	    Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
	    cover.setSpectacle(spectacle);
	    
	    coverRepository.save(cover).getId();
	}
	
	// delete
	public void deleteCover(Long id) {
		coverRepository.deleteById(id);
	}
}