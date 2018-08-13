package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Cena;

public interface CenaRepository extends JpaRepository<Cena, Long> {
}
