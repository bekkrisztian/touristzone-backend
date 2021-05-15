package ro.touristzone.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.touristzone.model.Spectacle;
import ro.touristzone.repository.SpectacleRepository;

@Service
public class SpectacleDtoServiceImpl {
	
	// spectacle repository implementation
	@Autowired
	private SpectacleRepository spectacleRepository;
	
	// mapping
	public List<SpectacleDto> getSpectacleDtoList() {
		return ((List<Spectacle>) spectacleRepository
				.findAll())
				.stream()
				.map(this::convertGeoJson)
				.collect(Collectors.toList());
	}
	
	// set dto's value
	private SpectacleDto convertGeoJson(Spectacle spectacle) {
		SpectacleDto geoDto = new SpectacleDto();
		List<Double> coordinate = new ArrayList<>();
		
		geoDto.setId(spectacle.getId());
		geoDto.setCover(spectacle.getCovers());
		geoDto.setName(spectacle.getName());
		coordinate.add(Double.valueOf(spectacle.getLatitude()));
		coordinate.add(Double.valueOf(spectacle.getLongitude()));
		geoDto.setCoordinates(coordinate);
		geoDto.setLat(Double.parseDouble(spectacle.getLatitude()));
		geoDto.setLon(Double.parseDouble(spectacle.getLongitude()));
		geoDto.setPin(spectacle.getPin());
		
		return geoDto;
	}
}