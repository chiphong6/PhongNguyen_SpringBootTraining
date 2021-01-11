package com.nguyenchiphong.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenchiphong.dto.ProductDTO;
import com.nguyenchiphong.service.IProductService;

@RestController
public class ProductAPI {
	@Autowired
	private IProductService iProductService;
	
	@GetMapping(value = {"/api/product"})
	public List<ProductDTO> getAll(){
		return iProductService.getAll();
	}
	
	@PostMapping(value = {"/api/product"})
	public Integer insert(@RequestBody ProductDTO productDTO) {
		return iProductService.insert(productDTO);
	}
	
	
	@PutMapping(value = {"/api/product"})
	public Integer update(@RequestBody ProductDTO productDTO) {
		return iProductService.update(productDTO);
	}
	
	@DeleteMapping(value= {"/api/product/{idProduct}"})
	public void delete( @PathVariable("idProduct") UUID idProduct) {
		iProductService.delete(idProduct);
	}
	
}
