package ro.touristzone.dto;

import java.util.List;

import ro.touristzone.model.County;
import ro.touristzone.model.Flag;

// county data transfer object
public class CountryDto {

	private Long id;
	private String name;
	private Flag flag;
	private List<County> counties;
	
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Flag getFlag() {
		return flag;
	}
	
	public List<County> getCounties() {
		return counties;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	
	public void setCounties(List<County> counties) {
		this.counties = counties;
	}
}