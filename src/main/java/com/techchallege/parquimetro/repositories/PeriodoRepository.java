package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.entities.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
    Periodo findByDescPeriodo(String descPeriodo);
}
