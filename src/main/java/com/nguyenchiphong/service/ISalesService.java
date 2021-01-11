package com.nguyenchiphong.service;

import java.util.List;
import java.util.UUID;

import com.nguyenchiphong.dto.SalesDTO;

public interface ISalesService {
	List<SalesDTO> getAll();

	Integer insert(SalesDTO salesDTO);

	Integer update(SalesDTO salesDTO);

	void deleteSales(UUID idSales);
}
