package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.CondutorDTO;
import com.techchallege.parquimetro.entities.Condutor;

import java.util.List;
import java.util.Optional;

public interface CondutorService {
    Condutor create(CondutorDTO condutorDTO);
    List<Condutor> getAllCondutors();
    Condutor getCondutorById(Long id);
    void deleteCondutorById(Long id);
    Condutor updateCondutorById(CondutorDTO condutorDTO, Long id);
    Optional<Condutor> getCondutorDTOByEmail(String email);
}
