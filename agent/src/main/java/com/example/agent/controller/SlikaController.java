package com.example.agent.controller;

import com.example.agent.model.Slika;
import com.example.agent.repository.SlikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/slika")
public class SlikaController {

    @Autowired
    SlikaRepository slikaRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "/nove")
    public ResponseEntity slikeSmestaja(@RequestBody List<Slika> slike){
        List<Slika> slidze = slikaRepository.save(slike);
        if (slidze != null) {
            return ResponseEntity.ok(slidze);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
