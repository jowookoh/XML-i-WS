package com.example.agent.repository;

import com.example.agent.model.Korisnik;
import com.example.agent.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmestajRepository extends JpaRepository<Smestaj,Long> {
    List<Smestaj> findByAgent(Korisnik agent);
}
