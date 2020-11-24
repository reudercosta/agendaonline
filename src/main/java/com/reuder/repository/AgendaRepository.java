package com.reuder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reuder.domain.Agenda;
import com.reuder.domain.Paciente;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	@Transactional(readOnly = true)
	Agenda findById(Integer id);
	
	@Transactional(readOnly = true)
	Page<Agenda> findByPaciente(Paciente paciente, Pageable pageRquest);


}
