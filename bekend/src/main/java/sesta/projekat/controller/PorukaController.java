package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Poruka;
import sesta.projekat.model.Rezervacija;
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


    @RequestMapping(method = RequestMethod.POST, value = "/nova")
    public ResponseEntity novaPoruka(@RequestBody Poruka poruka){

        Poruka porukaSacuvana = porukaService.save(poruka);
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
