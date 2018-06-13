package sesta.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesta.projekat.model.TipSmestaja;

public interface TipSmestajaRepository extends JpaRepository<TipSmestaja, Long> {
}
