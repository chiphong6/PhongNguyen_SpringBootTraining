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

import com.nguyenchiphong.dto.LocationDTO;
import com.nguyenchiphong.service.ILocationService;

@RestController
public class LocationAPI {
	@Autowired
	private ILocationService iLocationService;
	
	@GetMapping(value = {"/api/location"})
	public List<LocationDTO> getAll(){
		return iLocationService.getAll();
	}
	
	@PostMapping(value = {"/api/location"})
	public Integer insert(@RequestBody LocationDTO locationDTO) {
		return iLocationService.insert(locationDTO);
	}
	
	
	@PutMapping(value = {"/api/location"})
	public Integer update(@RequestBody LocationDTO locationDTO) {
		return iLocationService.update(locationDTO);
	}
	
	@DeleteMapping(value= {"/api/location/{idLocation}"})
	public void delete(@PathVariable("idLocation") UUID idLocation) {
		iLocationService.deleteLocation(idLocation);
	}
	
}