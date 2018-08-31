package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.model.Poruka;
import sesta.projekat.service.PorukaService;

@RestController
@RequestMapping("/poruka")
public class PorukaController {

    @Autowired
    private PorukaService porukaService;
    @Autowired


    @RequestMapping(method = RequestMethod.POST, value = "/dodajPoruku")
    public ResponseEntity novaPoruka(@RequestBody Poruka poruka){

        Poruka porukaSacuvana = porukaService.save(poruka);
        return ResponseEntity.ok(porukaSacuvana);
    }
}
