package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Rezervacija;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {
}
