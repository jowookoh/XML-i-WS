package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Korisnik;
import com.example.agent.model.Rezervacija;
import com.example.agent.service.RezervacijaService;
import com.example.agent.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/api/rezervacija")
public class RezervacijaController {

    @Autowired
    RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.POST, value = "/fejk")
    public ResponseEntity samostalnoRezervisi(@RequestBody Rezervacija rezervacija) {
        try{
            GenerickiClient client = new GenerickiClient(RezervacijaFejkRequest.class, RezervacijaFejkResponse.class);

        RezervacijaFejkRequest rezervacijaFejkRequest = new RezervacijaFejkRequest();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(rezervacija.getOd());
        XMLGregorianCalendar od = null;
        try {
            od = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        rezervacijaFejkRequest.setOd(od);
        c.setTime(rezervacija.getPaOndaDo());
        XMLGregorianCalendar paOndaDo = null;
        try {
            paOndaDo = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        rezervacijaFejkRequest.setPaOndaDo(paOndaDo);
        rezervacijaFejkRequest.setSmestajId(rezervacija.getSmestaj().getBekendId());
        RezervacijaFejkResponse rezervacijaFejkResponse = client.send(rezervacijaFejkRequest, "rezervacijaFejk");
        rezervacija.setBekendId(rezervacijaFejkResponse.getBekendId());
        }catch (Exception e){}
        Rezervacija reza=rezervacijaService.novaFejk(rezervacija);
        if (reza != null) {
            return ResponseEntity.ok(reza);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/secured/izmeni")
    public ResponseEntity realizujRezu(@RequestBody Rezervacija rezervacija) {
        try{GenerickiClient client = new GenerickiClient(RezervacijaRealizovanaRequest.class, RezervacijaRealizovanaResponse.class);
        RezervacijaRealizovanaRequest rezervacijaRealizovanaRequest = new RezervacijaRealizovanaRequest();
        rezervacijaRealizovanaRequest.setBekendId(rezervacija.getBekendId());
        RezervacijaRealizovanaResponse rezervacijaRealizovanaResponse = client.send(rezervacijaRealizovanaRequest, "rezervacijaRealizovana");
        }catch (Exception e){}
        rezervacijaService.realizujRezervaciju(rezervacija);
        return ResponseEntity.ok(rezervacija);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/moje/{agentId}")
    public ResponseEntity rezeMojihSmestaja(@PathVariable Long agentId){
        List<Rezervacija> rezervacije = rezervacijaService.rezervacijeMojihSmestaja(agentId,false);
        return ResponseEntity.ok(rezervacije);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mojeSve/{agentId}")
    public ResponseEntity rezeMojihSmestajaSve(@PathVariable Long agentId){
        List<Rezervacija> rezervacije = rezervacijaService.rezervacijeMojihSmestaja(agentId,true);
        return ResponseEntity.ok(rezervacije);
    }
}
