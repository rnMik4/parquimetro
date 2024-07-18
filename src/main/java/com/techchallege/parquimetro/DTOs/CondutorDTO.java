package com.techchallege.parquimetro.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties
public record CondutorDTO(
        Long id,
        LocalDateTime dataRegistro,
        String nomeCompleto,
        Integer ddd,
        String telefone,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String uf,
        String email,
        String cpf
) {}
