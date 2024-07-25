package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.CalculoTempoResponseDTO;
import com.techchallege.parquimetro.DTOs.EstacionamentosDTO;
import com.techchallege.parquimetro.DTOs.ReciboResponseDTO;
import com.techchallege.parquimetro.entities.Estacionamentos;

public interface EstacionamentosService {
    Estacionamentos salvarEstacionamento(EstacionamentosDTO estacionamento);
    Estacionamentos buscarEstacionamentoPorId(Long id);
    Estacionamentos atualizarEstacionamento(EstacionamentosDTO estacionamento, Long id);
    void excluirEstacionamento(Long id);
    CalculoTempoResponseDTO calcularTempo(Long idEstacionamento);
    Estacionamentos encerrarEstacionamentoVariavel(Long idEstacionamento);
    ReciboResponseDTO gerarRecibo(Long idEstacionamento);


}
