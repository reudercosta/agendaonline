package com.reuder.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.reuder.DTO.ExameNewDTO;
import com.reuder.domain.Exame;
import com.reuder.repository.ExameRepository;
import com.reuder.repository.PacienteRepository;
import com.reuder.resources.exceptions.FieldMessage;

public class ExameInsertValidator implements ConstraintValidator<ExameInsert, ExameNewDTO> {
	@Autowired
	private ExameRepository repo;

	@Override
	public void initialize(ExameInsert ann) {
	}

	@Override
	public boolean isValid(ExameNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista
		Exame aux = repo.findByNome(objDto.getNome());
		
		if(aux != null) {
			list.add(new FieldMessage("nome", "Nome já existente!!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldMessage())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
