package ro.touristzone.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ro.touristzone.model.Spectacle;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {
	// find spectacle by name and ignoring case
	Page<Spectacle> findByNameContainingIgnoreCase(@Param("name") String keyword, Pageable pageable);
	
	//find spectacle by county id
	Page<Spectacle> findByCountyId(@Param("id") Long id, Pageable pageable);
	
	//find spectacle by country id
	Page<Spectacle> findByCountyCountryId(@Param("id") Long id, Pageable pageable);
	
	//find spectacle by country id and county id
	Page<Spectacle> findByCountyCountryIdAndCountyId(@Param("id") Long id, @Param("id2") Long id2, Pageable pageable);
}