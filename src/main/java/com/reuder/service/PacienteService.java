package com.reuder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.domain.Exame;
import com.reuder.domain.Paciente;
import com.reuder.repository.PacienteRepository;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;
	
	
public Paciente find(Integer id) {
		Paciente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, id: " + id + "Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
}
