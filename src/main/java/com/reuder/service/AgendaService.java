package com.reuder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.reuder.DTO.AgendaDTO;
import com.reuder.DTO.AgendaNewDTO;
import com.reuder.domain.Agenda;
import com.reuder.domain.Paciente;
import com.reuder.repository.AgendaRepository;
import com.reuder.repository.ExameRepository;
import com.reuder.repository.PacienteRepository;
import com.reuder.repository.ProfissionalRepository;
import com.reuder.security.UserSS;
import com.reuder.service.exceptions.AuthorizationException;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repo;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private EmailService emailService;

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
		obj.setInstante(obj.getInstante());
		obj.setPaciente(pacienteRepository.findOne(obj.getPaciente().getId()));
		obj.setExame(exameRepository.findOne(obj.getExame().getId()));
		obj.setProfissional(profissionalRepository.findOne(obj.getProfissional().getId()));
		repo.save(obj);
		emailService.sendOrderConfirmationEmail(obj);
		emailService.sendOrderConfirmationHtmlEmail(obj);
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
	
	public Page<Agenda> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso negado!!");
		}
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Paciente paciente = pacienteRepository.findOne(user.getId());
		
		return repo.findByPaciente(paciente, pageRequest);
	}

}
