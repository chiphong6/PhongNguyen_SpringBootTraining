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

import com.nguyenchiphong.dto.SalesDTO;
import com.nguyenchiphong.service.ISalesService;

@RestController
public class SalesAPI {
	@Autowired
	private ISalesService iSalesService;
	
	@GetMapping(value = {"/api/sales"})
	public List<SalesDTO> getAll(){
		return iSalesService.getAll();
	}
	
	@PostMapping(value = {"/api/sales"})
	public Integer insert(@RequestBody SalesDTO salesDTO) {
		return iSalesService.insert(salesDTO);
	}
	
	
	@PutMapping(value = {"/api/sales"})
	public Integer update(@RequestBody SalesDTO salesDTO) {
		return iSalesService.update(salesDTO);
	}
	
	@DeleteMapping(value= {"/api/sales/{idSales}"})
	public void delete( @PathVariable("idSales") UUID idSales) {
		iSalesService.deleteSales(idSales);
	}
	
}
