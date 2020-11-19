package com.reuder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.domain.Paciente;
import com.reuder.domain.Profissional;
import com.reuder.repository.ProfissionalRepository;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository repo;
	
	
public Profissional find(Integer id) {
		Profissional obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, id: " + id + "Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
}
