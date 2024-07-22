package com.techchallege.parquimetro.services.validation;

import com.techchallege.parquimetro.DTOs.CondutorDTO;
import com.techchallege.parquimetro.entities.Condutor;
import com.techchallege.parquimetro.repositories.CondutorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class CriacaoCondutorValidator implements ConstraintValidator<CriacaoCondutorValid, CondutorDTO> {

    @Autowired
    CondutorRepository repository;

    @Override
    public void initialize(CriacaoCondutorValid anotation) {}

    @Override
    public boolean isValid(CondutorDTO condutorDTO, ConstraintValidatorContext context) {
        Optional<Condutor> condutor = repository.findByEmail(condutorDTO.email());
        return condutor.isEmpty();

    }
}
