package com.gutotech.gpatletismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.gpatletismo.model.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

}
