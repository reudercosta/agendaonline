package com.reuder.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "exame_id")
	private Exame exame;

	@ManyToOne
	@JoinColumn(name = "profissinal_id")
	private Profissional profissional;

	public Agenda() {

	}

	public Agenda(Integer id, Date instante, Paciente paciente, Exame exame, Profissional profissional) {
		super();
		this.id = id;
		this.instante = instante;
		this.paciente = paciente;
		this.exame = exame;
		this.profissional = profissional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda ID:  ");
		builder.append(id);
		builder.append(" ");
		builder.append("Instante: ");
		builder.append(getInstante());
		builder.append(" ");
		builder.append("Paciente: ");
		builder.append(getPaciente().getNome());
		builder.append(" ");
		builder.append("Exame: ");
		builder.append(getExame().getNome());
		builder.append(" ");
		builder.append("Profissional: ");
		builder.append(getProfissional().getNome());
		return builder.toString();
	}

}
