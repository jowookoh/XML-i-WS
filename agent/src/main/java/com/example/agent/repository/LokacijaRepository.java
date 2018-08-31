package com.example.agent.repository;

import com.example.agent.model.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
}
