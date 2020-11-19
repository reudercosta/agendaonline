package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reuder.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {



}
