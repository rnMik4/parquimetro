package com.techchallege.parquimetro.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techchallege.parquimetro.DTOs.CondutorResponseDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "veiculo")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", insertable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "id_condutor", nullable = false)
    private Long idCondutor;


//    @ManyToOne
//    @JoinColumn(name = "id_condutor", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//    private Condutor condutor;
//
//    public Condutor getCondutor() {
//        return condutor;
//    }
//
//    public void setCondutor(Condutor condutor) {
//        this.condutor = condutor;
//    }

    public Long getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(Long idCondutor) {
        this.idCondutor = idCondutor;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) && Objects.equals(dataRegistro, veiculo.dataRegistro) && Objects.equals(placa, veiculo.placa) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(marca, veiculo.marca) && Objects.equals(idCondutor, veiculo.idCondutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataRegistro, placa, modelo, marca, idCondutor);
    }
}
