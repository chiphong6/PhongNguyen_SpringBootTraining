package com.nguyenchiphong.service;

import java.util.List;
import java.util.UUID;

import com.nguyenchiphong.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> getAll();
	
	Integer insert(ProductDTO productDTO);
	
	Integer update(ProductDTO productDTO);
	
	void delete(UUID idProduct);
}
