package com.techchallege.parquimetro.repositories;

import com.techchallege.parquimetro.entities.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {

    Optional<Condutor> findByEmail(String email);
}
