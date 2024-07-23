package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.entities.FormasPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormasPagamentoRepository extends JpaRepository<FormasPagamento, Long> {
    FormasPagamento findByFormaPagamento(String formaPagamento);
}
