package com.reuder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.reuder.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	@Transactional(readOnly = true)
	Profissional findByRegitroConselhoProfissional(String regitroConselhoProfissional);

}
