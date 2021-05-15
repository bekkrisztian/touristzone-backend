package ro.touristzone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.County;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
	List<County> findByCountryId(@Param("id") Long id);
}