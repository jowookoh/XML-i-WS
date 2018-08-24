package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Poruka;

public interface PorukaRepository extends JpaRepository<Poruka, Long> {
}
