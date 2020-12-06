package com.reuder.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reuder.domain.Paciente;
import com.reuder.repository.PacienteRepository;
import com.reuder.service.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptPassowordEncoder;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassoword(String email) {
		Paciente paciente = pacienteRepository.findByEmail(email);

		if (paciente == null) {
			throw new ObjectNotFoundException("Email não encontrado!!");
		}
		String newPass = newPassword();
		paciente.setSenha(bcryptPassowordEncoder.encode(newPass));

		pacienteRepository.save(paciente);
		emailService.sendNewPasswordEmail(paciente, newPass);

	}

	private String newPassword() {
		char[] vet = new char[10];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { //gera um digito
			return (char) (rand.nextInt(10)+48);
		}
		if (opt == 1) { // gera uma letra minuscúla
			return (char) (rand.nextInt(26)+65); 
		} else { // gera letra maiuscula
			return (char) (rand.nextInt(26)+97);
		}
	}
}
