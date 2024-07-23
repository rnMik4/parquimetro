package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.FormasPagamentoPeriodoResponseDTO;
import com.techchallege.parquimetro.DTOs.FormasPagamentoResponseDTO;
import com.techchallege.parquimetro.DTOs.PeriodoFormasPagamentoDTO;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.entities.PeriodoFormasPagamento;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.PeriodoFormasPagamentoRepository;
import com.techchallege.parquimetro.services.PeriodoFormasPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoFormasPagamentoServiceImpl implements PeriodoFormasPagamentoService {
    @Autowired
    private PeriodoFormasPagamentoRepository repository;

    @Override
    public PeriodoFormasPagamento cadastrarPeriodoFormasPagamento(PeriodoFormasPagamentoDTO dto) {
        PeriodoFormasPagamento entity = new PeriodoFormasPagamento();
        BeanUtils.copyProperties(dto, entity);
        return repository.save(entity);
    }

    @Override
    public List<PeriodoFormasPagamento> listarPeriodoFormasPagamento() {
        return repository.findAll();
    }

    @Override
    public FormasPagamentoPeriodoResponseDTO listarFormasPagamentoByPeriodo(Long idPeriodo) {
        FormasPagamentoPeriodoResponseDTO responseDTO = new FormasPagamentoPeriodoResponseDTO();
        responseDTO.setFormasPagamento(repository.findByIdPeriodo(idPeriodo));
        return responseDTO;
    }

    @Override
    public PeriodoFormasPagamento atualizarPeriodoFormasPagamento(PeriodoFormasPagamentoDTO dto, Long id) {
        PeriodoFormasPagamento entity = new PeriodoFormasPagamento();
        entity = buscarPeriodoFormasPagamento(id);
        BeanUtils.copyProperties(dto, entity);
        return repository.save(entity);
    }

    @Override
    public void excluirPeriodoFormasPagamento(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PeriodoFormasPagamento buscarPeriodoFormasPagamento(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Referência não encontrada"));
    }


}
