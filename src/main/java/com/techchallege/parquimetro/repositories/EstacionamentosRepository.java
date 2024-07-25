package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.entities.Estacionamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EstacionamentosRepository extends JpaRepository<Estacionamentos, Long> {
    Estacionamentos findFirstByIdVeiculoOrderByDataRegistroDesc(Long idVeiculo);


}
