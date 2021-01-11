package com.nguyenchiphong.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchiphong.dto.ProductDTO;
import com.nguyenchiphong.entity.ProductEntity;
import com.nguyenchiphong.repository.ProductRepository;
import com.nguyenchiphong.service.IProductService;

@Service
public class ProductImplement implements IProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	@Transactional
	public List<ProductDTO> getAll() {
		List<ProductDTO> lstDTO = new ArrayList<ProductDTO>(); 
		List<ProductEntity> lstEntity = productRepository.getAll();
		ProductDTO pDTO = new ProductDTO();
		for (ProductEntity pE : lstEntity) {
			pDTO.setId(pE.getId());
			pDTO.setItem(pE.getItem());
			pDTO.setCategory(pE.getCategory());
			pDTO.setInventory(pE.getInventory());
			pDTO.setCreatedBy(pE.getCreatedBy());
			pDTO.setCreatedDate(pE.getCreatedDate());
			pDTO.setModifiedBy(pE.getModifiedBy());
			pDTO.setModifiedDate(pE.getModifiedDate());
			
			lstDTO.add(pDTO);
		}
		return lstDTO; 
	}

	@Override
	@Transactional
	public Integer insert(ProductDTO productDTO) {
		return productRepository.insert(productDTO.getItem(), productDTO.getCategory(), productDTO.getInventory());
	}

	@Override
	@Transactional
	public Integer update(ProductDTO productDTO) {
		return productRepository.update(productDTO.getItem(), productDTO.getCategory(), productDTO.getInventory(), productDTO.getId());
	}

	@Override
	@Transactional
	public void delete(UUID idProduct) {
		productRepository.deleteProduct(idProduct);
	}

}
