package com.reuder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.DTO.ExameDTO;
import com.reuder.DTO.ProfissionalNewDTO;
import com.reuder.domain.Exame;
import com.reuder.domain.Profissional;
import com.reuder.repository.ExameRepository;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repo;

	public Exame find(Integer id) {
		Exame obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, id: " + id + "Tipo: " + Exame.class.getName());
		}
		return obj;
	}

	@Transactional
	public Exame insert(Exame obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}

	public Exame fromDTO(ExameDTO objDTO) {
		return new Exame(objDTO.getId(), objDTO.getNome(), objDTO.getValor()); 
				}

	public Profissional fromDTO(ProfissionalNewDTO objDTO) {
		Profissional prof = new Profissional(null, objDTO.getNome(), objDTO.getRegitroConselhoProfissional());
		return prof;
	}

}
