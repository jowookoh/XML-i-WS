package com.example.agent.repository;

import com.example.agent.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik findById(Long id);
}
