package com.reuder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reuder.domain.Exame;
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
}
