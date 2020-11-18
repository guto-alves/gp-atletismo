package com.gutotech.gpatletismo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Atleta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String sexo;

	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;

	@ManyToMany(mappedBy = "atletas", fetch = FetchType.EAGER)
	private List<Prova> provas = new ArrayList<>();

	@OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Resultado> resultados = new ArrayList<>();

	public Atleta() {
	}

	public Atleta(long id, String nome, String sexo, Pais pais, List<Prova> provas, List<Resultado> resultados) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.pais = pais;
		this.provas = provas;
		this.resultados = resultados;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Atleta)) {
			return false;
		}
		Atleta other = (Atleta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Atleta [id=" + id + ", nome=" + nome + ", sexo=" + sexo + "]";
	}
}
