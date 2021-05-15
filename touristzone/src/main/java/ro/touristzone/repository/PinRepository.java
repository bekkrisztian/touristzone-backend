package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Pin;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {

}