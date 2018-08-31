package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Korisnik;
import sesta.projekat.service.KorisnikService;

@RestController
@RequestMapping(value = "/korisnik")
public class KlijentController {
    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody Korisnik korisnik) {
        if(korisnik.getKime() == null || korisnik.getLozinka() == null){
            return ResponseEntity.ok(false);
        }
        for(Korisnik kor : korisnikService.getAll()){

            if(kor.getKime().equals(korisnik.getKime()) && kor.getLozinka().equals(korisnik.getLozinka()) && kor.getTipKorisnika().equals("klijent")){
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.ok(false);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity registruj(@RequestBody Korisnik korisnik) {
        if(korisnik.getLozinka() == null || korisnik.getKime() == null || korisnik.getTipKorisnika() == null){
            return ResponseEntity.ok(false);
        }

        for(Korisnik k : korisnikService.getAll()){
            if(k.getKime().equals(korisnik.getKime())){
                return ResponseEntity.ok(false);
            }
        }

        Korisnik korisnikSacuvaj = korisnikService.save(korisnik);
        return ResponseEntity.ok(true);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/obrisi/{id}")
    public ResponseEntity obrisi(@PathVariable Long id) {
        Korisnik korisnik = korisnikService.findOne(id);
        korisnik.setTipKorisnika("oklijent");
        korisnikService.save(korisnik);
        return ResponseEntity.ok(true);
    }
}
