package com.example.agent.controller;

import com.example.agent.model.Poruka;
import com.example.agent.service.PorukaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
