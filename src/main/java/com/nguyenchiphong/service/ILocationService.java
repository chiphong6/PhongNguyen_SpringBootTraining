package com.nguyenchiphong.service;

import java.util.List;
import java.util.UUID;

import com.nguyenchiphong.dto.LocationDTO;

public interface ILocationService {
	List<LocationDTO> getAll();

	Integer insert(LocationDTO locationDTO);

	Integer update(LocationDTO locationDTO);

	void deleteLocation(UUID idLocation);
}
