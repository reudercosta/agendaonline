package com.reuder.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.reuder.domain.Agenda;
import com.reuder.domain.Exame;
import com.reuder.domain.Paciente;
import com.reuder.domain.Profissional;
import com.reuder.domain.Enum.Perfil;
import com.reuder.repository.AgendaRepository;
import com.reuder.repository.ExameRepository;
import com.reuder.repository.PacienteRepository;
import com.reuder.repository.ProfissionalRepository;

@Service
public class DbService {

	@Autowired
	private ExameRepository exameRepo;
	@Autowired
	private PacienteRepository pacienteRepo;
	@Autowired
	private ProfissionalRepository profRepo;
	@Autowired
	private AgendaRepository agendaRepo;

	public void instantiateTestDataBase() throws ParseException {
		Date d = new Date();
		
		
		//agendaRepo.save(agd);
		Exame exame2 = new Exame(null, "consulta2", 150.00);
		exameRepo.save(exame2);
		Paciente pac1 = new Paciente(null, "Reuder Cerqueira", "00208551506", "reudercerqueira@gmail.com", "123",
				"75999364144", "rua a, nº 35");
		pac1.addPerfil(Perfil.ADMIN);
		Paciente pac2 = new Paciente(null, "Levi Cerqueira", "00208551506", "levi@gmail.com", "123", "75999364144",
				"rua a, nº 35");
		//pac1.getAgendas();
		pac2.addPerfil(Perfil.CLIENTE);
		//pac2.getAgendas();
		
		Profissional prof1 = new Profissional(null, "Joana Dourado", "5590");
		profRepo.save(prof1);
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		pacienteRepo.save(Arrays.asList(pac1, pac2));
		
	}

}
