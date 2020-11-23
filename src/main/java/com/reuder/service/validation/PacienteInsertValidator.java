package com.reuder.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.reuder.DTO.PacienteNewDTO;
import com.reuder.domain.Paciente;
import com.reuder.repository.PacienteRepository;
import com.reuder.resources.exceptions.FieldMessage;

public class PacienteInsertValidator implements ConstraintValidator<PacienteInsert, PacienteNewDTO> {
	@Autowired
	private PacienteRepository repo;

	@Override
	public void initialize(PacienteInsert ann) {
	}

	@Override
	public boolean isValid(PacienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		Paciente aux = repo.findByEmail(objDto.getEmail());
		
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existente!!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldMessage())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
