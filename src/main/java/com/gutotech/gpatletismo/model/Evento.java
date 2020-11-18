package com.gutotech.gpatletismo.model;

public class Evento {
	private long id;
	private String nome;
	private double recorde;

	public Evento(long id, String nome, double recorde) {
		this.id = id;
		this.nome = nome;
		this.recorde = recorde;
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

	public double getRecorde() {
		return recorde;
	}

	public void setRecorde(double recorde) {
		this.recorde = recorde;
	}
}
