package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {

}