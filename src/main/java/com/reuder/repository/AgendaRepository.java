package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reuder.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {



}
