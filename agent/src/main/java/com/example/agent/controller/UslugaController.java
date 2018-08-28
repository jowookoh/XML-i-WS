package com.example.agent.controller;

import com.example.agent.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usluga")
public class UslugaController {
    @Autowired
    UslugaRepository uslugaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/secured/svi")
    public ResponseEntity getSveTipSmestaja() {
        return new ResponseEntity<>(uslugaRepository.findAll(), HttpStatus.OK);
    }
}
