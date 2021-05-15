package ro.touristzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Other;

@Repository
public interface OtherRepository extends JpaRepository<Other, Long> {

}