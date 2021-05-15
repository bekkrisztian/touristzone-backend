package ro.touristzone.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "spectacles")
public class Spectacle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spectacle_generator")
    @SequenceGenerator(name="spectacle_generator", sequenceName = "spectacle_seq", allocationSize=50)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "history", columnDefinition = "TEXT")
	private String history;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "county_id"), nullable = false)
    private County county;
	
	@ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "pin_id"), nullable = false)
    private Pin pin;
	
	@OneToMany(mappedBy = "spectacle", fetch = FetchType.EAGER)
	@OrderBy(value = "id ASC")
    private Set<Image> images;
	
	@OneToOne(mappedBy = "spectacle", fetch = FetchType.EAGER)
	@OrderBy(value = "id ASC")
    private Cover covers;
	
	@OneToMany(mappedBy = "spectacle")
    private Set<Source> sources;
	
	@OneToMany(mappedBy = "spectacle")
    private Set<Other> others;

    
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }

    public Set<Other> getOthers() {
        return others;
    }

    public void setOthers(Set<Other> others) {
        this.others = others;
    }

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Cover getCovers() {
		return covers;
	}

	public void setCovers(Cover covers) {
		this.covers = covers;
	}
}