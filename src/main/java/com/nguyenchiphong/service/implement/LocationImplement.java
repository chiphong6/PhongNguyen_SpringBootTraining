package com.nguyenchiphong.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchiphong.dto.LocationDTO;
import com.nguyenchiphong.dto.ProductDTO;
import com.nguyenchiphong.entity.LocationEntity;
import com.nguyenchiphong.entity.ProductEntity;
import com.nguyenchiphong.repository.LocationRepository;
import com.nguyenchiphong.repository.ProductRepository;
import com.nguyenchiphong.service.ILocationService;
import com.nguyenchiphong.service.IProductService;

@Service
public class LocationImplement implements ILocationService{
	@Autowired
	LocationRepository locationRepository;
	
	@Override
	@Transactional
	public List<LocationDTO> getAll() {
		List<LocationDTO> lstDTO = new ArrayList<LocationDTO>(); 
		List<LocationEntity> lstEntity = locationRepository.getAll();
		LocationDTO pDTO = new LocationDTO();
		for (LocationEntity pE : lstEntity) {
			pDTO.setId(pE.getId());
			pDTO.setCity(pE.getCity());
			pDTO.setCountry(pE.getCountry());
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
	public Integer insert(LocationDTO locationDTO) {
		return locationRepository.insert(locationDTO.getCity(), locationDTO.getCountry());
	}

	@Override
	@Transactional
	public Integer update(LocationDTO locationDTO) {
		return locationRepository.update(locationDTO.getCity(), locationDTO.getCountry(), locationDTO.getId());
	}

	@Override
	@Transactional
	public void deleteLocation(UUID idLocation) {
		locationRepository.deleteLocation(idLocation);
	}

}
