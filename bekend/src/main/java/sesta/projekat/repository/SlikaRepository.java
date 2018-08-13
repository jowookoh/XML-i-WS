package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Slika;

public interface SlikaRepository extends JpaRepository<Slika, Long> {
}
