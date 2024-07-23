package com.techchallege.parquimetro.DTOs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techchallege.parquimetro.entities.FormasPagamento;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PeriodoFormasPagamentoResponseDTO {
    private Long id;
    private LocalDateTime dataRegistro;
    private Long idPeriodo;
    private Long idFormasPagamento;
    private List<FormasPagamento> formasPagamento;

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<FormasPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormasPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFormasPagamento() {
        return idFormasPagamento;
    }

    public void setIdFormasPagamento(Long idFormasPagamento) {
        this.idFormasPagamento = idFormasPagamento;
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
