package com.example.agent.repository;

import com.example.agent.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long>{
    Rezervacija findById(Long id);
}
