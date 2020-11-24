package com.reuder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.DTO.ProfissionalDTO;
import com.reuder.DTO.ProfissionalNewDTO;
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

	@Transactional
	public Profissional insert(Profissional obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}
	public Profissional fromDTO(ProfissionalDTO objDTO) {
		return new Profissional(objDTO.getId(), objDTO.getNome(), objDTO.getRegitroConselhoProfissional());
	}
	
	public Profissional fromDTO(ProfissionalNewDTO objDTO) {
		Profissional prof = new Profissional(null, objDTO.getNome(), objDTO.getRegitroConselhoProfissional());
		return prof;
	}
	
	
}
