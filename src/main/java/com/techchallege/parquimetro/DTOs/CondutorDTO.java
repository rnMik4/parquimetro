package com.techchallege.parquimetro.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techchallege.parquimetro.services.validation.CriacaoCondutorValid;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;

@CriacaoCondutorValid()
public record CondutorDTO(
        String nomeCompleto,
        Integer ddd,
        String telefone,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String uf,
        @Email(message = "Email inválido")
        String email,
        String cpf
) {}
