package ro.touristzone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "covers")
public class Cover {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cover_generator")
	@SequenceGenerator(name="cover_generator", sequenceName = "cover_seq", allocationSize=50)
    private Long id;

	private String name;

    private String contentType;

    private Long size;

    @Lob
    private byte[] data;
    
    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "spectacle_id", nullable = true)
    private Spectacle spectacle;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContentType() {
		return contentType;
	}

	public Long getSize() {
		return size;
	}

	public byte[] getData() {
		return data;
	}

	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}   
}