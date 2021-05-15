package ro.touristzone.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CountryDtoController {

	// countryDto service implementation
	@Autowired
	CountryDtoServiceImpl countryDtoServiceImpl;
	
	// get countryDto list
	@RequestMapping(value = "/countries/countrydto", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CountryDto> getAllCountries() {
		List<CountryDto> countryDtos = countryDtoServiceImpl.getCountryDtoList();
		return countryDtos;
	}
}
