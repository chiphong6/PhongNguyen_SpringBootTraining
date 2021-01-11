package com.nguyenchiphong.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchiphong.dto.SalesDTO;
import com.nguyenchiphong.entity.SalesEntity;
import com.nguyenchiphong.repository.SalesRepository;
import com.nguyenchiphong.service.ISalesService;

@Service
public class SalesImplement implements ISalesService{
	@Autowired
	SalesRepository salesRepository;
	
	@Override
	@Transactional
	public List<SalesDTO> getAll() {
		List<SalesDTO> lstDTO = new ArrayList<SalesDTO>(); 
		List<SalesEntity> lstEntity = salesRepository.getAll();
		SalesDTO pDTO = new SalesDTO();
		for (SalesEntity pE : lstEntity) {
			pDTO.setId(pE.getId());
			pDTO.setDollars(pE.getDollars());
			pDTO.setProduct_id(pE.getProductEntity().getId());
			pDTO.setLocation_id(pE.getLocationEntity().getId());
			pDTO.setTime_id(pE.getTimeEntity().getId());
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
	public Integer insert(SalesDTO salesDTO) {
		return salesRepository.insert(salesDTO.getDollars(), salesDTO.getProduct_id(), salesDTO.getLocation_id(), salesDTO.getTime_id());
	}

	@Override
	@Transactional
	public Integer update(SalesDTO salesDTO) {
		return salesRepository.update(salesDTO.getDollars(), salesDTO.getProduct_id(), salesDTO.getLocation_id(), salesDTO.getTime_id(), salesDTO.getId());
	}

	@Override
	@Transactional
	public void deleteSales(UUID idSales) {
		salesRepository.deleteSales(idSales);
	}

}

