package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
}
