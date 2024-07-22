package com.techchallege.parquimetro.DTOs;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public record VeiculoDTO(
    String placa,
    String modelo,
    String marca,
    Long idCondutor
) {
}
