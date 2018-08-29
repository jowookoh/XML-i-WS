package com.example.agent.controller;

import com.example.agent.model.Rezervacija;
import com.example.agent.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.POST, value = "/fejk")
    public ResponseEntity samostalnoRezervisi(@RequestBody Rezervacija rezervacija) {
        Rezervacija reza=rezervacijaService.novaFejk(rezervacija);
        if (reza != null) {
            return ResponseEntity.ok(reza);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/secured/izmeni")
    public ResponseEntity realizujRezu(@RequestBody Rezervacija rezervacija) {
        rezervacijaService.realizujRezervaciju(rezervacija);
        return ResponseEntity.ok(rezervacija);
    }
}
