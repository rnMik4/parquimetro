package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.PeriodoDTO;
import com.techchallege.parquimetro.entities.Periodo;

import java.util.List;

public interface PeriodoService {
    Periodo create(PeriodoDTO periodoDTO);
    List<Periodo> findAll();
    Periodo findById(Long id);
    Periodo update(PeriodoDTO periodoDTO, Long id);
    void delete(Long id);
    Periodo findByDescricao(String descricao);
}
