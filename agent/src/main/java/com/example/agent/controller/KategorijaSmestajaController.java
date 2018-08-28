package com.example.agent.controller;

import com.example.agent.repository.KategorijaSmestajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kategorijasmestaja")
public class KategorijaSmestajaController {


    @Autowired KategorijaSmestajaRepository kategorijaSmestajaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/secured/svi")
    public ResponseEntity getSveKategorijeSmestaja() {
        return new ResponseEntity<>(kategorijaSmestajaRepository.findAll(), HttpStatus.OK);
    }
}
