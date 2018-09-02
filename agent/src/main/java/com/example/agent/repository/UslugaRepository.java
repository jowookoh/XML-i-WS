package com.example.agent.repository;

import com.example.agent.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UslugaRepository extends JpaRepository<Usluga,Long> {
    Usluga findUslugaByBekendId(Long id);
}
