package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.DTOs.FormasPagamentoPeriodoResponseDTO;
import com.techchallege.parquimetro.DTOs.FormasPagamentoResponseDTO;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.entities.PeriodoFormasPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoFormasPagamentoRepository extends JpaRepository<PeriodoFormasPagamento, Long> {
    @Query(value = "SELECT " +
            "fp.forma_pagamento FROM periodo_formas_pagamento as pfp " +
            "inner join formas_pagamento as fp " +
            "on pfp.id_formas_pagamento = fp.id " +
            "where pfp.id_periodo = :id ", nativeQuery = true)
    List<String> findByIdPeriodo(@Param("id") Long id);




}
