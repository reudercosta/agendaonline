package com.reuder.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.reuder.DTO.ProfissionalNewDTO;
import com.reuder.domain.Profissional;
import com.reuder.repository.ProfissionalRepository;
import com.reuder.resources.exceptions.FieldMessage;

public class ProfissionalInsertValidator implements ConstraintValidator<ProfissionalInsert, ProfissionalNewDTO> {
	@Autowired
	private ProfissionalRepository repo;

	@Override
	public void initialize(ProfissionalInsert ann) {
	}

	@Override
	public boolean isValid(ProfissionalNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		Profissional aux = repo.findByRegitroConselhoProfissional(objDto.getRegitroConselhoProfissional());
		
		if(aux != null) {
			list.add(new FieldMessage("Registro Profissional", "Registro Profissional já cadastrado!!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldMessage())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
