package com.gutotech.gpatletismo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.gpatletismo.model.Pais;
import com.gutotech.gpatletismo.model.PaisDto;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	@Query("SELECT " +
			"new com.gutotech.gpatletismo.model.PaisDto(p, COUNT(a)) " +
			"FROM Atleta a JOIN a.pais p GROUP BY p")
	List<PaisDto> findAllAndCountTotalAtletas();

}
