package ro.touristzone.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "counties")
public class County {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "county_generator")
    @SequenceGenerator(name="county_generator", sequenceName = "county_seq", allocationSize=50)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "country_id"), nullable = false)
    private Country country;

    @JsonBackReference
    @OneToMany(mappedBy = "county")
    private Set<Spectacle> spectacles;


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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Spectacle> getSpectacles() {
        return spectacles;
    }

    public void setSpectacles(Set<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }
}