package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Cena;
import com.example.agent.repository.CenaRepository;
import com.example.agent.ws.CenaRequest;
import com.example.agent.ws.CenaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/api/cena")
public class CenaController {
    @Autowired
    CenaRepository cenaRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "/nove")
    public ResponseEntity cenovnikSmestaja(@RequestBody List<Cena> cene){
        try {
            GenerickiClient client = new GenerickiClient(CenaRequest.class, CenaResponse.class);
            for (Cena cena : cene) {
                CenaRequest cenaRequest = new CenaRequest();
                cenaRequest.setSmestajId(cena.getSmestaj().getBekendId());
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(cena.getMesec());
                XMLGregorianCalendar date = null;
                try {
                    date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
                cenaRequest.setMesec(date);
                cenaRequest.setVrednost(cena.getVrednost());
                CenaResponse cenaResponse = client.send(cenaRequest, "cena");
                cena.setBekendId(cenaResponse.getBekendId());
            }
        }catch (Exception e){}

        List<Cena> cent = cenaRepository.save(cene);
        if (cent != null) {
            return ResponseEntity.ok(cent);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
