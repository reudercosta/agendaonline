package com.reuder.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Profissional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String regitroConselhoProfissional;

	@JsonIgnore
	@OneToMany(mappedBy = "profissional")
	private Set<Agenda> agendas = new HashSet<>();

	public Profissional() {
		
	}
	public Profissional(Integer id, String nome, String regitroConselhoProfissional) {
		super();
		this.id = id;
		this.nome = nome;
		this.regitroConselhoProfissional = regitroConselhoProfissional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegitroConselhoProfissional() {
		return regitroConselhoProfissional;
	}

	public void setRegitroConselhoProfissional(String regitroConselhoProfissional) {
		this.regitroConselhoProfissional = regitroConselhoProfissional;
	}

	public Set<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
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
		Profissional other = (Profissional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
