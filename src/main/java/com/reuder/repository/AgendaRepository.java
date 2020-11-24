package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reuder.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	@Transactional(readOnly = true)
	Agenda findById(Integer id);


}
