package com.techchallege.parquimetro.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "estacionamentos")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Estacionamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", insertable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @Column(name = "idPeriodo")
    private Long idPeriodo;

    @Column(name = "id_formas_pagamento")
    private Long idFormasPagamento;

    @Column(name = "valor_total")
    private Double valorTotal;

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
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

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
