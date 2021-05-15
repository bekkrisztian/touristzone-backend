package ro.touristzone.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pins")
public class Pin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pin_generator")
	@SequenceGenerator(name="pin_generator", sequenceName = "pin_seq", allocationSize=50)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@JsonBackReference
    @OneToMany(mappedBy = "pin")
    private Set<Spectacle> spectacles;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public Set<Spectacle> getSpectacles() {
		return spectacles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setSpectacles(Set<Spectacle> spectacles) {
		this.spectacles = spectacles;
	}
}