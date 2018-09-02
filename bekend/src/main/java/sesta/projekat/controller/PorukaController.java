package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.dto.PorukaDtoRequest;
import sesta.projekat.model.Korisnik;
import sesta.projekat.model.Poruka;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.service.KorisnikService;
import sesta.projekat.service.PorukaService;
import sesta.projekat.service.RezervacijaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/poruka")
public class PorukaController {

    @Autowired
    private PorukaService porukaService;
    @Autowired
    private RezervacijaService rezervacijaService;
    @Autowired
    private KorisnikService korisnikService;


    @RequestMapping(method = RequestMethod.POST, value = "/nova")
    public ResponseEntity novaPoruka(@RequestBody PorukaDtoRequest poruka){
        List<Poruka> porukeRezervacije = new ArrayList<>();
        for(Poruka p : porukaService.getAll()){
            if(p.getRezervacija().getId() == poruka.getIdRezervacije()){
                porukeRezervacije.add(p);
            }
        }
        Poruka porukaSacuvana = new Poruka();
        for(Korisnik k : korisnikService.getAll()){
            if(k.getKime().equals(poruka.getPosiljalac())){
                porukaSacuvana.setPosiljalac(k);
            }
        }
        porukaSacuvana.setRezervacija(rezervacijaService.findOne(poruka.getIdRezervacije()));
        porukaSacuvana.setTekst(poruka.getTekst());
        porukaSacuvana.setPoRedu(porukeRezervacije.size() + 1);
        porukaSacuvana = porukaService.save(porukaSacuvana);
        return ResponseEntity.ok(porukaSacuvana);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/porukeRezervacije/{id}")
    public ResponseEntity getPorukeRezervacije(@PathVariable Long id) {
        List<Poruka> tempPoruke = new ArrayList<>();
        List<Poruka> svePoruke = porukaService.getAll();
        for(Poruka poruka : svePoruke){
            if(poruka.getRezervacija().getId() == id){
                tempPoruke.add(poruka);
            }
        }
        return ResponseEntity.ok(tempPoruke);
    }

}
