package com.nguyenchiphong.service;

import java.util.List;
import java.util.UUID;

import com.nguyenchiphong.dto.TimeDTO;

public interface ITimeService {
	List<TimeDTO> getAll();

	Integer insert(TimeDTO timeDTO);

	Integer update(TimeDTO timeDTO);

	void deleteTime(UUID idTime);
}
