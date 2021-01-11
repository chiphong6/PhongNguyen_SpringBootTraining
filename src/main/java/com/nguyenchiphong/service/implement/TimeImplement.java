package com.nguyenchiphong.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenchiphong.dto.TimeDTO;
import com.nguyenchiphong.entity.TimeEntity;
import com.nguyenchiphong.repository.TimeRepository;
import com.nguyenchiphong.service.ITimeService;

@Service
public class TimeImplement implements ITimeService{
	@Autowired
	TimeRepository timeRepository;
	
	@Override
	@Transactional
	public List<TimeDTO> getAll() {
		List<TimeDTO> lstDTO = new ArrayList<TimeDTO>(); 
		List<TimeEntity> lstEntity = timeRepository.getAll();
		TimeDTO pDTO = new TimeDTO();
		for (TimeEntity pE : lstEntity) {
			pDTO.setId(pE.getId());
			pDTO.setMonth(pE.getQuater());
			pDTO.setQuater(pE.getMonth());
			pDTO.setYear(pE.getYear());
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
	public Integer insert(TimeDTO timeDTO) {
		return timeRepository.insert(timeDTO.getMonth(), timeDTO.getQuater(), timeDTO.getYear());
	}

	@Override
	@Transactional
	public Integer update(TimeDTO timeDTO) {
		return timeRepository.update(timeDTO.getMonth(), timeDTO.getQuater(), timeDTO.getYear(), timeDTO.getId());
	}

	@Override
	@Transactional
	public void deleteTime(UUID idTime) {
		timeRepository.deleteTime(idTime);
	}

}
