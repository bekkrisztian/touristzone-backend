package ro.touristzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "opinions")
public class Opinion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opinion_generator")
	@SequenceGenerator(name="opinion_generator", sequenceName = "opinion_seq", allocationSize=50)
    private Long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "opinion", columnDefinition = "TEXT")
	private String opinion;
	

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
}