package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
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

    public List<Korisnik> getAllAgents(){
        return korisnikRepository.findByTipKorisnika("agent");
    }

    public List<Korisnik> getAllKorisnici(){
        List<Korisnik> sviKorisnici;
        List<Korisnik> bKlijenti = korisnikRepository.findByTipKorisnika("bklijent");
        List<Korisnik> oKlijenti = korisnikRepository.findByTipKorisnika("oklijent");
        sviKorisnici = korisnikRepository.findByTipKorisnika("klijent");
        sviKorisnici.addAll(bKlijenti);
        sviKorisnici.addAll(oKlijenti);

        return sviKorisnici;
    }

    public void deleteOne(Korisnik k) { korisnikRepository.delete(k);}

    public void deleteOne(Long id){ korisnikRepository.delete(id);}
}
