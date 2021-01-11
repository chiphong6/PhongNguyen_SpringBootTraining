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

import com.nguyenchiphong.dto.TimeDTO;
import com.nguyenchiphong.service.ITimeService;

@RestController
public class TimeAPI {
	@Autowired
	private ITimeService iTimeService;
	
	@GetMapping(value = {"/api/time"})
	public List<TimeDTO> getAll(){
		return iTimeService.getAll();
	}
	
	@PostMapping(value = {"/api/time"})
	public Integer insert(@RequestBody TimeDTO TimeDTO) {
		return iTimeService.insert(TimeDTO);
	}
	
	
	@PutMapping(value = {"/api/time"})
	public Integer update(@RequestBody TimeDTO TimeDTO) {
		return iTimeService.update(TimeDTO);
	}
	
	@DeleteMapping(value= {"/api/time/{idTime}"})
	public void delete( @PathVariable("idTime") UUID idTime) {
		iTimeService.deleteTime(idTime);
	}
	
}
