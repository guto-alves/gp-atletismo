package com.gutotech.gpatletismo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Fase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	@Column(columnDefinition = "TINYINT DEFAULT 0")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean iniciada;

	@ManyToOne
	private Prova prova;

	@OneToMany(mappedBy = "fase", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Resultado> resultados = new ArrayList<Resultado>();

	public Fase() {
	}

	public Fase(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Fase(long id, String nome, boolean iniciada, Prova prova, List<Resultado> resultados) {
		this.id = id;
		this.nome = nome;
		this.iniciada = iniciada;
		this.prova = prova;
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

	public boolean isIniciada() {
		return iniciada;
	}

	public void setIniciada(boolean iniciada) {
		this.iniciada = iniciada;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public void addResultado(Resultado resultado) {
		resultados.add(resultado);
		resultado.setFase(this);
	}

	public void removeResultado(Resultado resultado) {
		resultados.remove(resultado);
		resultado.setFase(null);
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
		if (!(obj instanceof Fase)) {
			return false;
		}
		Fase other = (Fase) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Fase [id=" + id + ", nome=" + nome + ", iniciada=" + iniciada + ", prova=" + prova.getNome() + "]";
	}

}
