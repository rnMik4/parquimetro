package com.techchallege.parquimetro.DTOs;

import jakarta.persistence.Column;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record EstacionamentosDTO(
        LocalDateTime dataHoraInicio,
        LocalDateTime dataHoraFim,
        Long idVeiculo,
        Long idPeriodo,
        Long idFormasPagamento
) {
}
