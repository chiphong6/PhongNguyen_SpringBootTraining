package com.nguyenchiphong.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nguyenchiphong.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
	
	@Query(value = "SELECT * FROM product", nativeQuery = true)
	List<ProductEntity> getAll();
	
	@Modifying
	@Query(value = "INSERT INTO product (item, category, inventory) VALUES (?,?,?)", nativeQuery = true)
	Integer insert(Integer item, String category, String inventory);
	
	@Modifying
	@Query(value = "UPDATE product SET item = ?, category = ?, inventory = ? WHERE id = ?", nativeQuery = true)
	Integer update(Integer item, String category, String inventory, UUID productId);
	
	@Modifying
	@Query(value = "DELETE FROM product p WHERE p.id = ?", nativeQuery = true)
	void deleteProduct(UUID productId);

}
