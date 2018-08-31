package com.example.agent.controller;

import com.example.agent.model.Poruka;
import com.example.agent.service.PorukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poruka")
public class PorukaController {
    @Autowired
    PorukaService porukaService;

    @RequestMapping(method = RequestMethod.GET, value = "/porukeRezervacije/{id}")
    public ResponseEntity getPorukeRezervacije(@PathVariable Long id) {
        List<Poruka> poruke = porukaService.porukaRezervacije(id);
        return ResponseEntity.ok(poruke);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/nova")
    public ResponseEntity napisiPoruku(@RequestBody Poruka poruka) {
        Poruka pora = porukaService.novaPoruka(poruka);
        if (pora != null) {
            return ResponseEntity.ok(pora);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/izbrisi/{id}")
    public  ResponseEntity izbrisiPorukeRezervacije(@PathVariable Long id){
        List<Poruka> poruke = porukaService.porukaRezervacije(id);
        if (poruke != null) {
            porukaService.izbrisiPoruke(poruke);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
