package com.nguyenchiphong.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nguyenchiphong.entity.TimeEntity;

public interface TimeRepository extends JpaRepository<TimeEntity, UUID> {
	@Query(value = "SELECT * FROM time", nativeQuery = true)
	List<TimeEntity> getAll();
	
	@Modifying
	@Query(value = "INSERT INTO time (month, quater, year) VALUES (?,?,?)", nativeQuery = true)
	Integer insert(Integer month, Integer quater, Integer year);
	
	@Modifying
	@Query(value = "UPDATE time SET month = ?, quater = ?, year = ? WHERE id = ?", nativeQuery = true)
	Integer update(Integer month, Integer quater, Integer year, UUID timeId);
	
	@Modifying
	@Query(value = "DELETE FROM time t WHERE t.id = ?", nativeQuery = true)
	void deleteTime(UUID timeId);
}
