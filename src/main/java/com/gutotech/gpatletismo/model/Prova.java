package com.gutotech.gpatletismo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Prova {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String tipo;
	private String sexo;
	private double recordeEvento;
	private double recordeMundial;

	@OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Fase> fases = new ArrayList<Fase>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "prova_atleta",
			joinColumns = @JoinColumn(name = "prova_id"), 
			inverseJoinColumns = @JoinColumn(name = "atleta_id")
	)
	private List<Atleta> atletas = new ArrayList<>();

	public Prova() {
	}

	public Prova(long id, String nome, String tipo, String sexo, double recordeEvento, double recordeMundial,
			List<Fase> fases, List<Atleta> atletas) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.sexo = sexo;
		this.recordeEvento = recordeEvento;
		this.recordeMundial = recordeMundial;
		this.fases = fases;
		this.atletas = atletas;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getRecordeEvento() {
		return recordeEvento;
	}

	public void setRecordeEvento(double recordeEvento) {
		this.recordeEvento = recordeEvento;
	}

	public double getRecordeMundial() {
		return recordeMundial;
	}

	public void setRecordeMundial(double recordeMundial) {
		this.recordeMundial = recordeMundial;
	}

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	public void addAtleta(Atleta atleta) {
		atletas.add(atleta);
		atleta.getProvas().add(this);
	}

	public void removeAtleta(Atleta atleta) {
		atletas.remove(atleta);
		atleta.getProvas().remove(this);
	}

	@Override
	public String toString() {
		return "Prova [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", sexo=" + sexo + "]";
	}
}
