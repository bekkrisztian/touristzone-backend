package ro.touristzone.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import ro.touristzone.model.Image;
import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.ImageRepository;
import ro.touristzone.repository.SpectacleRepository;

@Service
public class ImageServiceImpl {

	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	SpectacleRepository spectacleRepository;
	
	// save images
	public void save(MultipartFile[] file, @PathVariable Long id) throws Exception {
		for (int i = 0; i < file.length; i++) {
	        Image image = new Image();
	        image.setName(StringUtils.cleanPath(file[i].getOriginalFilename()));
	        image.setContentType(file[i].getContentType());
	        image.setData(file[i].getBytes());
	        image.setSize(file[i].getSize());
	        
	        Spectacle spectacle = spectacleRepository.findById(id).orElseThrow(()->new Exception());
	        image.setSpectacle(spectacle);
	        
	        imageRepository.save(image).getId();
		}
    }
	
	// find image by id
	public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }
	
	// find all
	public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
	
	// delete
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
}