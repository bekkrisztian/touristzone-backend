package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Cover;

@Repository
public interface CoverRepository extends JpaRepository<Cover, Long> {

}