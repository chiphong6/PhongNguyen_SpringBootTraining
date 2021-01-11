package com.nguyenchiphong.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nguyenchiphong.entity.ProductEntity;
import com.nguyenchiphong.entity.SalesEntity;

public interface SalesRepository extends JpaRepository<SalesEntity, UUID> {
	@Query(value = "SELECT * FROM sales", nativeQuery = true)
	List<SalesEntity> getAll();
	
	@Modifying
	@Query(value = "INSERT INTO sales (dollars, product_id, location_id, time_id) VALUES (?,?,?,?)", nativeQuery = true)
	Integer insert(Integer dollars, UUID product_id, UUID location_id, UUID time_id);
	
	@Modifying
	@Query(value = "UPDATE sales SET dollars = ?, product_id = ?, location_id = ?, time_id = ? WHERE id = ?", nativeQuery = true)
	Integer update(Integer dollars, UUID product_id, UUID location_id, UUID time_id, UUID salesId);
	
	@Modifying
	@Query(value = "DELETE FROM sales s WHERE s.id = ?", nativeQuery = true)
	void deleteSales(UUID salesId);
}
