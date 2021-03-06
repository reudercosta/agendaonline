package com.reuder.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.reuder.domain.Agenda;
import com.reuder.domain.Exame;
import com.reuder.domain.Paciente;
import com.reuder.domain.Profissional;
import com.reuder.service.validation.AgendaInsert;


public class AgendaNewDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private Date instante;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private Exame exame;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private Paciente paciente;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private Profissional profissional;
	
	public AgendaNewDTO() {
		
	}
	
	public AgendaNewDTO(Agenda objDTO) {
		
		id = objDTO.getId();
		instante = objDTO.getInstante();
		exame = objDTO.getExame();
		paciente = objDTO.getPaciente();
		profissional = objDTO.getProfissional();
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

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
		AgendaNewDTO other = (AgendaNewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
