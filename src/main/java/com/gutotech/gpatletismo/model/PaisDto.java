package com.gutotech.gpatletismo.model;

public class PaisDto {
	private Pais pais;
	private long totalAtletas;

	public PaisDto(Pais pais, long totalAtletas) {
		this.pais = pais;
		this.totalAtletas = totalAtletas;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public long getTotalAtletas() {
		return totalAtletas;
	}

	public void setTotalAtletas(long totalAtletas) {
		this.totalAtletas = totalAtletas;
	}
}
