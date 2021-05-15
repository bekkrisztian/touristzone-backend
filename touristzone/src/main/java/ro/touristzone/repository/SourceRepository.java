package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

}