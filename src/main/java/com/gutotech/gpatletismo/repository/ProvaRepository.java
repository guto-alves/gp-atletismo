package com.gutotech.gpatletismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.gpatletismo.model.Prova;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long> {

}
