package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.PeriodoDTO;
import com.techchallege.parquimetro.entities.Periodo;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.PeriodoRepository;
import com.techchallege.parquimetro.services.PeriodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeriodoServiceImpl implements PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Override
    public Periodo create(PeriodoDTO periodoDTO) {
        Periodo periodo = new Periodo();
        periodo = findByDescricao(periodoDTO.descPeriodo());
        if(periodo != null) {
            throw new ResourceNotFoundException("Período já cadastrado");
        }
        Periodo save = new Periodo();
        BeanUtils.copyProperties(periodoDTO, save);
        return periodoRepository.save(save);
    }

    @Override
    public List<Periodo> findAll() {
        return periodoRepository.findAll();
    }

    @Override
    public Periodo findById(Long id) {
        return periodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo não encontrado"));
    }

    @Override
    public Periodo update(PeriodoDTO periodoDTO, Long id) {
        Periodo periodo = findById(id);
        if(periodo == null) {
            throw new ResourceNotFoundException("Periodo não encontrado");
        }
        BeanUtils.copyProperties(periodoDTO, periodo);
        return periodoRepository.save(periodo);
    }

    @Override
    public void delete(Long id) {
        periodoRepository.deleteById(id);
    }

    @Override
    public Periodo findByDescricao(String descricao) {
        return periodoRepository.findByDescPeriodo(descricao);
    }
}
