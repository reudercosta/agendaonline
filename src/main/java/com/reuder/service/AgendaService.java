package com.reuder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.domain.Agenda;
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
}
