package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Lokacija;
import com.example.agent.service.LokacijaService;
import com.example.agent.ws.LokacijaRequest;
import com.example.agent.ws.LokacijaResponse;
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
        GenerickiClient client = new GenerickiClient(LokacijaRequest.class, LokacijaResponse.class);
        LokacijaRequest lokacijaRequest = new LokacijaRequest();
        lokacijaRequest.setDrzava(lokacija.getDrzava());
        lokacijaRequest.setMesto(lokacija.getMesto());
        LokacijaResponse lokacijaResponse = client.send(lokacijaRequest, "lokacija");
        lokacija.setBekendId(lokacijaResponse.getBekendId());
        Lokacija loka = lokacijaService.novaLokacija(lokacija);
        if (loka != null) {
            return ResponseEntity.ok(loka);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
