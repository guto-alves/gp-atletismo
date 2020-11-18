package com.gutotech.gpatletismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.gpatletismo.model.Atleta;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Long> {

}
