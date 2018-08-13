package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Lokacija;

public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {
}
