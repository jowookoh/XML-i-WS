package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.Korisnik;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    List<Korisnik> findByTipKorisnika(String tipKorisnika);
    Korisnik findByKimeAndLozinkaAndTipKorisnika (String kime, String lozinka, String tipKorisnika);
}
