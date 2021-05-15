package ro.touristzone.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_generator")
    @SequenceGenerator(name="country_generator", sequenceName = "country_seq", allocationSize=50)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "country")
    private Set<County> counties;
    
    @OneToOne(mappedBy = "country", fetch = FetchType.EAGER)
	@OrderBy(value = "id ASC")
    private Flag flags;

    
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

    public Set<County> getCounties() {
        return counties;
    }

    public void setCounties(Set<County> counties) {
        this.counties = counties;
    }

	public Flag getFlags() {
		return flags;
	}

	public void setFlags(Flag flags) {
		this.flags = flags;
	}
}