package ro.touristzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_generator")
	@SequenceGenerator(name="user_role_generator", sequenceName = "user_role_seq", allocationSize=50)
	private Long id;
	
	@Column(name = "role")
    private String role;
	

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}