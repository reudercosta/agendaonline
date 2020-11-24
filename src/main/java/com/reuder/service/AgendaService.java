package com.reuder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.DTO.AgendaDTO;
import com.reuder.DTO.AgendaNewDTO;
import com.reuder.domain.Agenda;
import com.reuder.domain.Profissional;
import com.reuder.repository.AgendaRepository;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;

	public Agenda find(Integer id) {
		Agenda obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, id: " + id + "Tipo: " + Agenda.class.getName());
		}
		return obj;
	}

	@Transactional
	public Agenda insert(Agenda obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}

	public Agenda fromDTO(AgendaDTO objDTO) {
		return new Agenda(objDTO.getId(), objDTO.getInstante(), objDTO.getPaciente(), objDTO.getExame() ,objDTO.getProfissional());
	}

	public Agenda fromDTO(AgendaNewDTO objDTO) {
		Agenda agenda = new Agenda(objDTO.getId(), objDTO.getInstante(), objDTO.getPaciente(), objDTO.getExame(),
				objDTO.getProfissional());
		return agenda;
	}

}
