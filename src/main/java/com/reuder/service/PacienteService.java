package com.reuder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reuder.DTO.PacienteNewDTO;
import com.reuder.domain.Paciente;
import com.reuder.domain.Enum.Perfil;
import com.reuder.repository.PacienteRepository;
import com.reuder.security.UserSS;
import com.reuder.service.exceptions.AuthorizationException;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	

	public Paciente find(Integer id) {
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasHole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado!!");
			
		}
		Paciente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado, id: " + id + "Tipo: " + Paciente.class.getName());
		}
		return obj;
	}
	@Transactional
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
	}
	
	public Paciente fromDTO(PacienteNewDTO objDTO) {
		Paciente pac = new Paciente(null, objDTO.getNome(), objDTO.getRgOuCpf(), objDTO.getEmail(), pe.encode(objDTO.getSenha()), objDTO.getTelefone(), objDTO.getEndereço());
		pac.addPerfil(Perfil.CLIENTE);	 
		return pac;
	}
}
