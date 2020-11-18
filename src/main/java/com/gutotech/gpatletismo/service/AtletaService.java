package com.gutotech.gpatletismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.gpatletismo.model.Atleta;
import com.gutotech.gpatletismo.repository.AtletaRepository;

@Service
public class AtletaService {
	@Autowired
	private AtletaRepository repository;

	public List<Atleta> findAll() {
		return repository.findAll();
	}

	public void save(Atleta atleta) {
		repository.save(atleta);
	}
}
