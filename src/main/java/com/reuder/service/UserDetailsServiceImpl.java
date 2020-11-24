package com.reuder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reuder.domain.Paciente;
import com.reuder.repository.PacienteRepository;
import com.reuder.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private PacienteRepository repo;

	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Paciente pac = repo.findByEmail(email);
		if(pac == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(pac.getId(), pac.getEmail(), pac.getSenha(), pac.getPerfis());
	}

}
