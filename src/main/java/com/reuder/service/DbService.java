package com.reuder.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private AgendaRepository agendaRepo1;
	@Autowired
	private BCryptPasswordEncoder pe;


	public void instantiateTestDataBase() throws ParseException {
		Date d = new Date(System.currentTimeMillis());
		
		Date d1 = new Date(System.currentTimeMillis()+864000000);
		
		Date d2 = new Date();
		d2.setDate(26);
		d2.setHours(11);
		d2.setMinutes(00);
		
		// agendaRepo.save(agd);
		Exame exame1 = new Exame(null, "consulta1", 10.00);
		Exame exame2 = new Exame(null, "consulta2", 20.00);
		exameRepo.save(Arrays.asList(exame1,exame2));
		
		Paciente pac1 = new Paciente(null, "Reuder Cerqueira", "00208551506", "reudercerqueira@gmail.com", pe.encode("123"),
				"75999364144", "rua a, nº 35");
		pac1.addPerfil(Perfil.ADMIN);
		Paciente pac2 = new Paciente(null, "Levi Cerqueira", "00208551506", "levi@gmail.com", pe.encode("123"), "75999364144",
				"rua a, nº 35");
		pac2.addPerfil(Perfil.CLIENTE);
		pacienteRepo.save(Arrays.asList(pac1, pac2));

		Profissional prof1 = new Profissional(null, "Joana Dourado", "5590");
		profRepo.save(Arrays.asList(prof1));
				
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Agenda agd = new Agenda(null, d, pac1, exame1, prof1);
		
		
		Agenda agd1 = new Agenda(null, d2, pac2, exame2, prof1);
		
		
		agendaRepo.save(Arrays.asList(agd,agd1));
	

	}

}
