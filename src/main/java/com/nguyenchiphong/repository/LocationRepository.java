package com.nguyenchiphong.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nguyenchiphong.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, UUID> {
	@Query(value = "SELECT * FROM location", nativeQuery = true)
	List<LocationEntity> getAll();
	
	@Modifying
	@Query(value = "INSERT INTO location (city, country) VALUES (?,?)", nativeQuery = true)
	Integer insert(String city, String country);
	
	@Modifying
	@Query(value = "UPDATE location SET city = ?, country = ? WHERE id = ?", nativeQuery = true)
	Integer update(String city, String country, UUID locationId);
	
	@Modifying
	@Query(value = "DELETE FROM location l WHERE l.id = ?", nativeQuery = true)
	void deleteLocation(UUID locationId);
}
