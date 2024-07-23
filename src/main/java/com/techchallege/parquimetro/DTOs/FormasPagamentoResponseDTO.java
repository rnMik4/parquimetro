package com.techchallege.parquimetro.DTOs;

import java.time.LocalDateTime;

public class FormasPagamentoResponseDTO {
    private Long id;
    private LocalDateTime dataRegistro;
    private String formaPagamento;

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
