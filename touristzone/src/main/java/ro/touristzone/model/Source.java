package ro.touristzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sources")
public class Source {
    
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_generator")
    @SequenceGenerator(name="source_generator", sequenceName = "source_seq", allocationSize=50)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "source")
	private String source;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "spectacle_id", nullable = false)
    private Spectacle spectacle;

    
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }
}