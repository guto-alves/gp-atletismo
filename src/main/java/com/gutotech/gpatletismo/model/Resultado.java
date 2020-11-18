package com.gutotech.gpatletismo.model;

import java.util.Date;
import java.util.Objects;
import java.util.stream.DoubleStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Fase fase;

	@ManyToOne
	private Atleta atleta;

	@Temporal(TemporalType.TIME)
	private Date tempo;

	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m1;
	
	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m2;
	
	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m3;
	
	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m4;

	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m5;
	
	@Column(columnDefinition = "DEC DEFAULT 0.0")
	private double m6;

	public Resultado() {
	}

	public Resultado(long id, Fase fase, Atleta atleta, Date tempo, double m1, double m2, double m3, double m4,
			double m5, double m6) {
		this.id = id;
		this.fase = fase;
		this.atleta = atleta;
		this.tempo = tempo;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;
		this.m6 = m6;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public double getM1() {
		return m1;
	}

	public void setM1(double m1) {
		this.m1 = m1;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public double getM3() {
		return m3;
	}

	public void setM3(double m3) {
		this.m3 = m3;
	}

	public double getM4() {
		return m4;
	}

	public void setM4(double m4) {
		this.m4 = m4;
	}

	public double getM5() {
		return m5;
	}

	public void setM5(double m5) {
		this.m5 = m5;
	}

	public double getM6() {
		return m6;
	}

	public void setM6(double m6) {
		this.m6 = m6;
	}

	public double getMelhorMarca() {
		return DoubleStream.of(m1, m2, m3, m4, m5, m6).max().getAsDouble();
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
		if (!(obj instanceof Resultado)) {
			return false;
		}
		Resultado other = (Resultado) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Resultado [id=" + id + "]";
	}
}
