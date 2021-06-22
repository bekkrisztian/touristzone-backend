package ro.touristzone.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SpectacleDtoController {
	
	// spectacleDto service implementation
	@Autowired
	SpectacleDtoServiceImpl spectacleDtoServiceImpl;
	
	// get spectacleDto list
	@RequestMapping(value = "/spectacles/spectacledto", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SpectacleDto> getAllSpectacleByDto() {
		List<SpectacleDto> spectacleDtos = spectacleDtoServiceImpl.getSpectacleDtoList();
		return spectacleDtos;
	}
}
