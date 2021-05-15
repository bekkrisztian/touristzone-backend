package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Flag;

@Repository
public interface FlagRepository extends JpaRepository<Flag, Long> {

}