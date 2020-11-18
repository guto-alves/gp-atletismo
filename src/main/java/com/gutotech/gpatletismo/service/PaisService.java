package com.gutotech.gpatletismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.gpatletismo.model.Pais;
import com.gutotech.gpatletismo.model.PaisDto;
import com.gutotech.gpatletismo.repository.PaisRepository;

@Service
public class PaisService {
	@Autowired
	private PaisRepository repository;
	
	public List<Pais> findAll() {
		return repository.findAll();
	}
	
	public List<PaisDto> findAllAndCountTotalAtletas() {
		return repository.findAllAndCountTotalAtletas();
	}
}
