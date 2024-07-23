package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.FormasPagamentoDTO;
import com.techchallege.parquimetro.entities.FormasPagamento;

import java.util.List;

public interface FormasPagamentoService {
    FormasPagamento create(FormasPagamentoDTO formasPagamentoDTO);
    FormasPagamento update(FormasPagamentoDTO formasPagamentoDTO, Long id);
    void delete(Long id);
    FormasPagamento getById(Long id);
    List<FormasPagamento> getAll();
    FormasPagamento getByFormaPagamento(String formaPagamento);
}
