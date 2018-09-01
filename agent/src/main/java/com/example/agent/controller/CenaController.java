package com.example.agent.controller;

import com.example.agent.model.Cena;
import com.example.agent.repository.CenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cena")
public class CenaController {
    @Autowired
    CenaRepository cenaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/nove")
    public ResponseEntity cenovnikSmestaja(@RequestBody List<Cena> cene){
        List<Cena> cent = cenaRepository.save(cene);
        if (cent != null) {
            return ResponseEntity.ok(cent);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
