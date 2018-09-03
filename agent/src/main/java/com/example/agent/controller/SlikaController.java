package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Cena;
import com.example.agent.model.Slika;
import com.example.agent.repository.SlikaRepository;
import com.example.agent.ws.CenaRequest;
import com.example.agent.ws.CenaResponse;
import com.example.agent.ws.SlikaRequest;
import com.example.agent.ws.SlikaResponse;
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
@RequestMapping("/api/slika")
public class SlikaController {

    @Autowired
    SlikaRepository slikaRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "/nove")
    public ResponseEntity slikeSmestaja(@RequestBody List<Slika> slike){
    	try {
			GenerickiClient client = new GenerickiClient(SlikaRequest.class, SlikaResponse.class);
			for (Slika slika : slike) {
				SlikaRequest slikaRequest = new SlikaRequest();
				slikaRequest.setSmestajBekendId(slika.getBekendId());
				slikaRequest.setAdresa(slika.getSlika());
				SlikaResponse slikaResponse = client.send(slikaRequest, "slika");
				slika.setBekendId(slikaResponse.getBekendId());
			}
		}catch(Exception ignored){}
        List<Slika> slidze = slikaRepository.save(slike);
        if (slidze != null) {
            return ResponseEntity.ok(slidze);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
