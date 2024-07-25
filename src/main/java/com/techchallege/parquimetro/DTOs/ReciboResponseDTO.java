package com.techchallege.parquimetro.DTOs;

import com.techchallege.parquimetro.entities.Condutor;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.entities.Periodo;
import com.techchallege.parquimetro.entities.Veiculo;

import java.time.LocalDateTime;

public class ReciboResponseDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Long tempoEstacionado;
    private double valorTotal;
    private Periodo periodo;
    private Condutor condutor;
    private FormasPagamento formaPagamento;
    private Veiculo veiculo;

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormasPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Long getTempoEstacionado() {
        return tempoEstacionado;
    }

    public void setTempoEstacionado(Long tempoEstacionado) {
        this.tempoEstacionado = tempoEstacionado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
