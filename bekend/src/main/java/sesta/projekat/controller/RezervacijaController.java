package sesta.projekat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.converters.DtoURezervaciju;
import sesta.projekat.dto.PorukaDto;
import sesta.projekat.dto.RezervacijaDto;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.model.Smestaj;
import sesta.projekat.repository.RezervacijaRepository;
import sesta.projekat.repository.SmestajRepository;
import sesta.projekat.service.RezervacijaService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {
    @Autowired
    private DtoURezervaciju dtoURezervaciju;
    @Autowired
    private RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.GET, value = "/rezervisiSmestaj")
    public ResponseEntity novaRezervacija(@RequestBody RezervacijaDto rezervacijaDto){
        Rezervacija rezervacija = dtoURezervaciju.convert(rezervacijaDto);
        rezervacijaService.save(rezervacija);
        return ResponseEntity.ok(rezervacija);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/dodajPoruku")
    public ResponseEntity dodajPoruku(@RequestBody PorukaDto porukaDto){
        Rezervacija rezervacija = rezervacijaService.findOne(porukaDto.getRezervacijaId());
        rezervacija.setKomentar(porukaDto.getTekst());
        return ResponseEntity.ok(rezervacija);
    }
}
