package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// find user by username and confirmed is true
	public User findByUsernameAndIsConfirmedTrue(String username);
	
	// find user
    public User findOneByUsername(String username);
}