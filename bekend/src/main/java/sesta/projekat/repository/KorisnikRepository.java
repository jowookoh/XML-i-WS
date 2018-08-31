package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
