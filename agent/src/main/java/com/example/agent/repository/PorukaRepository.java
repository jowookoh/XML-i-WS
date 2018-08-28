package com.example.agent.repository;

import com.example.agent.model.Poruka;
import com.example.agent.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PorukaRepository extends JpaRepository<Poruka,Long> {

    List<Poruka> findByRezervacija(Rezervacija rezervacija);
}
