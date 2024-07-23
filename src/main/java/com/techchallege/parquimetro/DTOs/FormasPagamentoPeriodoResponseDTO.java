package com.techchallege.parquimetro.DTOs;

import com.techchallege.parquimetro.entities.FormasPagamento;

import java.util.List;

public class FormasPagamentoPeriodoResponseDTO {
    private List<String> formasPagamento;

    public List<String> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<String> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }
}
