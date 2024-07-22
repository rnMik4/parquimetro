package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.CondutorDTO;
import com.techchallege.parquimetro.entities.Condutor;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.CondutorRepository;
import com.techchallege.parquimetro.services.CondutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorServiceImpl implements CondutorService {

    @Autowired
    private CondutorRepository repository;

    @Override
    public Condutor create(CondutorDTO condutorDTO) {
        Condutor condutor = new Condutor();
        BeanUtils.copyProperties(condutorDTO, condutor);
        return repository.save(condutor);
    }

    @Override
    public List<Condutor> getAllCondutors() {
        return repository.findAll();
    }

    @Override
    public Condutor getCondutorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Condutor não encontrado"));
    }

    @Override
    public void deleteCondutorById(Long id) {
        Condutor condutor = getCondutorById(id);
        repository.delete(condutor);
    }

    @Override
    public Condutor updateCondutorById(CondutorDTO condutorDTO, Long id) {
        Condutor condutor = getCondutorById(id);
        BeanUtils.copyProperties(condutorDTO, condutor);
        return repository.save(condutor);
    }

    @Override
    public Optional<Condutor> getCondutorDTOByEmail(String email) {
        return repository.findByEmail(email);
    }
}
