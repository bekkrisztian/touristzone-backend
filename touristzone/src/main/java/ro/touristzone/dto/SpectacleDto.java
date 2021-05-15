package ro.touristzone.dto;

import java.util.List;

import ro.touristzone.model.Cover;
import ro.touristzone.model.Pin;


//Data Transfer Object for getting spectacleDto
public class SpectacleDto {

	private Long id;
	private String name;
	private Cover cover;
	private List<Double> coordinates; 
	private Pin pin;
	private Double lat;
	private Double lon;
	

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}
}