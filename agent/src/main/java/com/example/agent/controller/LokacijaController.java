package com.example.agent.controller;

import com.example.agent.model.Lokacija;
import com.example.agent.service.LokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lokacija")
public class LokacijaController {

    @Autowired
    LokacijaService lokacijaService;

    @RequestMapping(method = RequestMethod.PUT, value = "/nova")
    public ResponseEntity dodajemLokaciju(@RequestBody Lokacija lokacija){
        Lokacija loka = lokacijaService.novaLokacija(lokacija);
        if (loka != null) {
            return ResponseEntity.ok(loka);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
