package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Korisnik;
import sesta.projekat.service.KorisnikService;

import java.util.List;

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

        korisnik.setTipKorisnika("bklijent");
        Korisnik korisnikSacuvaj = korisnikService.save(korisnik);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dajKorisnika/{kime}")
    public ResponseEntity obrisi(@PathVariable String kime) {
        Korisnik k  = new Korisnik();
        for (Korisnik korisnik : korisnikService.getAll()) {
            if (korisnik.getKime().equals(kime)) {
                k = korisnikService.findOne(korisnik.getId());
            }
        }
        return ResponseEntity.ok(k);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/obrisi/{id}")
    public ResponseEntity obrisi(@PathVariable Long id) {
        Korisnik korisnik = korisnikService.findOne(id);
        korisnik.setTipKorisnika("oklijent");
        korisnikService.save(korisnik);
        return ResponseEntity.ok(true);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update(@RequestBody Korisnik k, @PathVariable Long id){
        Korisnik kUpdated;
        kUpdated = korisnikService.findOne(id);
        if (kUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        kUpdated.setIme(k.getIme());
        kUpdated.setPrezime(k.getPrezime());
        kUpdated.setKime(k.getKime());
        kUpdated.setAdresa(k.getAdresa());
        kUpdated.setPoslovniMaticniBroj(k.getPoslovniMaticniBroj());
        kUpdated.setTipKorisnika(k.getTipKorisnika());
        kUpdated = korisnikService.save(kUpdated);
        return ResponseEntity.ok(kUpdated);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Korisnik> klijenti = korisnikService.getAllKorisnici();
        return ResponseEntity.ok(klijenti);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getOne(@PathVariable final Long id){
        Korisnik k = korisnikService.findOne(id);
        if (k == null || !(k.getTipKorisnika().equals("oklijent") || k.getTipKorisnika().equals("bklijent") || k.getTipKorisnika().equals("klijent"))){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(k);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteOne(@PathVariable final Long id){
        Korisnik k = korisnikService.findOne(id);
        if (k == null || !(k.getTipKorisnika().equals("oklijent") || k.getTipKorisnika().equals("bklijent") || k.getTipKorisnika().equals("klijent"))){
            return ResponseEntity.notFound().build();
        }
        korisnikService.deleteOne(k);
        return ResponseEntity.ok().build();
    }
}
