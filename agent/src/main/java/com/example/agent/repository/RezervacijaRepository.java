package com.example.agent.repository;

import com.example.agent.model.Rezervacija;
import com.example.agent.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long>{
    Rezervacija findById(Long id);

    List<Rezervacija> findBySmestaj(Smestaj smestaj);
}
