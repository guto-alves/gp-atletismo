package com.gutotech.gpatletismo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutotech.gpatletismo.model.Prova;
import com.gutotech.gpatletismo.repository.ProvaRepository;

@Service
public class ProvaService {
	@Autowired
	private ProvaRepository repository;

	public List<Prova> findAll() {
		return repository.findAll();
	}

	public Prova findById(long provaId) {
		Optional<Prova> optional = repository.findById(provaId);

		Prova prova;

		if (optional.isPresent()) {
			prova = optional.get();
		} else {
			throw new RuntimeException("Prova não encontrada");
		}

		return prova;
	}
}
