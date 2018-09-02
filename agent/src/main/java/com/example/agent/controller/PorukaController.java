package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Poruka;
import com.example.agent.service.PorukaService;
import com.example.agent.ws.PorukaSendRequest;
import com.example.agent.ws.PorukaSendResponse;
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
        GenerickiClient client = new GenerickiClient(PorukaSendRequest.class, PorukaSendResponse.class);
        PorukaSendRequest porukaSendRequest = new PorukaSendRequest();
        porukaSendRequest.setKime(poruka.getPosiljalac().getKime());
        porukaSendRequest.setPoRedu(poruka.getPoRedu());
        porukaSendRequest.setRezervacijaId(poruka.getRezervacija().getBekendId());
        porukaSendRequest.setTekst(poruka.getTekst());
        PorukaSendResponse porukaSendResponse = client.send(porukaSendRequest, "porukaSend");

        poruka.setBekendId(porukaSendResponse.getBekendId());
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
