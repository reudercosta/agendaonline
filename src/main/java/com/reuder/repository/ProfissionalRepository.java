package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reuder.domain.Exame;
import com.reuder.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {



}
