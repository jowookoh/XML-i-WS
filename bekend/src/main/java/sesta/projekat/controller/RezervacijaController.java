package sesta.projekat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Korisnik;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.service.KorisnikService;
import sesta.projekat.service.RezervacijaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;
    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(method = RequestMethod.POST, value = "/rezervisiSmestaj")
    public ResponseEntity novaRezervacija(@RequestBody Rezervacija rezervacija){
        System.out.println(rezervacija.getSmestaj().getAgent());
        Rezervacija rezervacijaSacuvana = rezervacijaService.save(rezervacija);
        return ResponseEntity.ok(rezervacijaSacuvana);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sveRezervacijeKorisnika/{kime}")
    public ResponseEntity sveRezervacijeKorisnika(@PathVariable String kime){
        List<Rezervacija> sveRezervacije = rezervacijaService.getAll();

        List<Rezervacija> returnRezervacije = new ArrayList<>();
        for(Rezervacija r : sveRezervacije){
            if(r.getKlijent().getKime().equals(kime)){
                returnRezervacije.add(r);
            }
        }
        return ResponseEntity.ok(returnRezervacije);
    }
}
