package ro.touristzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ro.touristzone.repository.CoverRepository;
import ro.touristzone.repository.ImageRepository;
import ro.touristzone.service.serviceImpl.CoverServiceImpl;
import ro.touristzone.service.serviceImpl.FlagServiceImpl;
import ro.touristzone.service.serviceImpl.ImageServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class ImageController {

	// image service implementation
	@Autowired
	ImageServiceImpl imageService;
	
	@Autowired
	ImageRepository imageRepository;
	
	// cover service implementation
	@Autowired
	CoverServiceImpl coverService;
	
	@Autowired
	CoverRepository coverRepository;
	
	// flag service implementation
	@Autowired
	FlagServiceImpl flagService;
	
	// save images by spectacle id
	@PostMapping("/images/save/{id}")
	public ResponseEntity<String> upload(@RequestParam("image") MultipartFile[] file, @PathVariable Long id) throws Exception {
		
		for (int i = 0; i < file.length;) {
			try {
				imageService.save(file, id);
				return ResponseEntity.status(HttpStatus.OK)
						.body(String.format("A képek sikeresen feltöltve", file[i].getOriginalFilename()));
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body(String.format("Sikertelen feltölés!", file[i].getOriginalFilename()));
			}
		}
		return null;
	}
	
	// delete image by id
	@DeleteMapping("/images/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	// save cover by id
	@PostMapping("/cover/save/{id}")
	public ResponseEntity<String> uploadCover(@RequestParam("image") MultipartFile file, @PathVariable Long id) throws Exception {
			try {
				coverService.save(file, id);
				return ResponseEntity.status(HttpStatus.OK)
						.body(String.format("A kép sikeresen feltöltve: %s", file.getOriginalFilename()));
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body(String.format("Sikertelen feltölés: %s!", file.getOriginalFilename()));
			}
	}
	
	// delete cover by id
	@DeleteMapping("/cover/delete/{id}")
    public ResponseEntity<Void> deleteCover(@PathVariable Long id) {
        coverService.deleteCover(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	// save flag image by country id
	@PostMapping("/flag/save/{id}")
	public ResponseEntity<String> uploadFlag(@RequestParam("image") MultipartFile file, @PathVariable Long id) throws Exception {
			try {
				flagService.save(file, id);
				return ResponseEntity.status(HttpStatus.OK)
						.body(String.format("A kép sikeresen feltöltve: %s", file.getOriginalFilename()));
			} catch (Exception e) {
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body(String.format("Sikertelen feltölés: %s!", file.getOriginalFilename()));
			}
	}
	
	// delete flag image by id
	@DeleteMapping("/flag/delete/{id}")
    public ResponseEntity<Void> deleteFlag(@PathVariable Long id) {
		flagService.deleteFlag(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}