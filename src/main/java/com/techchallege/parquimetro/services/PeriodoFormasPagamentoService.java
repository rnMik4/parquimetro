package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.FormasPagamentoPeriodoResponseDTO;
import com.techchallege.parquimetro.DTOs.FormasPagamentoResponseDTO;
import com.techchallege.parquimetro.DTOs.PeriodoFormasPagamentoDTO;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.entities.PeriodoFormasPagamento;

import java.util.List;

public interface PeriodoFormasPagamentoService {
    PeriodoFormasPagamento cadastrarPeriodoFormasPagamento(PeriodoFormasPagamentoDTO dto);
    List<PeriodoFormasPagamento> listarPeriodoFormasPagamento();
    FormasPagamentoPeriodoResponseDTO listarFormasPagamentoByPeriodo(Long idPeriodo);
    PeriodoFormasPagamento atualizarPeriodoFormasPagamento(PeriodoFormasPagamentoDTO dto, Long id);
    void excluirPeriodoFormasPagamento(Long id);
    PeriodoFormasPagamento buscarPeriodoFormasPagamento(Long id);
}
