package com.techchallege.parquimetro.DTOs;

import com.techchallege.parquimetro.entities.Condutor;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class VeiculoResponseDTO {
    private Long id;
    private LocalDateTime dataRegistro;
    private String placa;
    private String modelo;
    private String marca;
//    private Condutor condutor;
//
//
//    public Condutor getCondutor() {
//        return condutor;
//    }
//
//    public void setCondutor(Condutor condutor) {
//        this.condutor = condutor;
//    }

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
