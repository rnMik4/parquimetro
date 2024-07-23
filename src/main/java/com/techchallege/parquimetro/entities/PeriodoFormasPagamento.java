package com.techchallege.parquimetro.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "periodo_formas_pagamento")
public class PeriodoFormasPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", insertable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "id_periodo")
    private Long idPeriodo;

    @Column(name = "id_formas_pagamento")
    private Long idFormasPagamento;

    @OneToMany(mappedBy = "id")
    private List<FormasPagamento> formasPagamento;

    public List<FormasPagamento> getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(List<FormasPagamento> formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
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
