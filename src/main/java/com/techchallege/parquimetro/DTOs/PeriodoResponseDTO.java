package com.techchallege.parquimetro.DTOs;

import java.time.LocalDateTime;

public class PeriodoResponseDTO {
    Long id;
    LocalDateTime dataRegistro;
    String descPeriodo;
    Double valor;

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDescPeriodo() {
        return descPeriodo;
    }

    public void setDescPeriodo(String descPeriodo) {
        this.descPeriodo = descPeriodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
