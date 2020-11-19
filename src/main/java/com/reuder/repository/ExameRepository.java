package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reuder.domain.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {



}
