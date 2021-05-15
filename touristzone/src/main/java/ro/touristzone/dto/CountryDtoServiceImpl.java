package ro.touristzone.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Country;
import ro.touristzone.model.County;
import ro.touristzone.repository.CountryRepository;

@Service
public class CountryDtoServiceImpl {

	// country repository implementation
	@Autowired
	private CountryRepository countryRepository;
	
	// mapping
	public List<CountryDto> getCountryDtoList() {
		return ((List<Country>) countryRepository
				.findAll())
				.stream()
				.map(this::convertList)
				.collect(Collectors.toList());
}
	
	// set dto's value
	private CountryDto convertList(Country country) {
		
		CountryDto countryDto = new CountryDto();
		List<County> counties = new ArrayList<>();
		
		countryDto.setId(country.getId());
		countryDto.setName(country.getName());
		countryDto.setFlag(country.getFlags());
		counties.addAll(country.getCounties());
		countryDto.setCounties(counties);
		
		return countryDto;
	}
}