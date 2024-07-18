package com.techchallege.parquimetro.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "condutor")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Condutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", insertable = false, nullable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "ddd")
    private Integer ddd;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf")
    private String cpf;

}
