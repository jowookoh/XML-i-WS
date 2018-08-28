package sesta.projekat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.service.RezervacijaService;

@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.POST, value = "/rezervisiSmestaj")
    public ResponseEntity novaRezervacija(@RequestBody Rezervacija rezervacija){
        Rezervacija rezervacijaSacuvana = rezervacijaService.save(rezervacija);
        return ResponseEntity.ok(rezervacijaSacuvana);
    }
}
