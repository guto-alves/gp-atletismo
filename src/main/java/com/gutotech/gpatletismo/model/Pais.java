package com.gutotech.gpatletismo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	private String nome;
	private String sigla;
	private String imagemUrl;
	
	public Pais() {
	}

	public Pais(String name) {
		this.nome = name;
	}

	public Pais(long id, String nome, String imagemUrl) {
		this.id = id;
		this.nome = nome;
		this.imagemUrl = imagemUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	@Override
	public String toString() {
		return "Pais [nome=" + nome + ", sigla=" + sigla + "]";
	}
}
