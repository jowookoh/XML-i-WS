package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Korisnik;
import sesta.projekat.repository.KorisnikRepository;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id) {
        return korisnikRepository.findOne(id);
    }

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public List<Korisnik> getAll() {
        return korisnikRepository.findAll();
    }
}
