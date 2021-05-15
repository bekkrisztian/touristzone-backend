package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}