package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByIdCondutor(Long id);
    Veiculo findByPlaca(String placa);
}
