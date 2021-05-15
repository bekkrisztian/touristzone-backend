package ro.touristzone.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import ro.touristzone.model.Country;
import ro.touristzone.model.Flag;
import ro.touristzone.repository.CountryRepository;
import ro.touristzone.repository.FlagRepository;

@Service
public class FlagServiceImpl {
	
	@Autowired
	FlagRepository flagRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	// save
	public void save(MultipartFile file, @PathVariable Long id) throws Exception {
        Flag flag = new Flag();
        flag.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        flag.setContentType(file.getContentType());
        flag.setData(file.getBytes());
        flag.setSize(file.getSize());
        
        Country country = countryRepository.findById(id).orElseThrow(()->new Exception());
        flag.setCountry(country);
        
        flagRepository.save(flag).getId();
	}
	
	// delete
	public void deleteFlag(Long id) {
		flagRepository.deleteById(id);
	}
}