package com.reuder.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.reuder.DTO.AgendaNewDTO;
import com.reuder.domain.Agenda;
import com.reuder.repository.AgendaRepository;
import com.reuder.resources.exceptions.FieldMessage;

public class AgendaInsertValidator implements ConstraintValidator<AgendaInsert, AgendaNewDTO> {
	@Autowired
	private AgendaRepository repo;

	@Override
	public void initialize(AgendaInsert ann) {
	}

	@Override
	public boolean isValid(AgendaNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		Agenda aux = repo.findById(objDto.getId());
		
		if(aux != null) {
			list.add(new FieldMessage("agenda", "Agendamento cadastrado!!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldMessage())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
