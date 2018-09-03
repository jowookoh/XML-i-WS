package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Smestaj;
import com.example.agent.model.UslugaSmestaj;
import com.example.agent.repository.SmestajRepository;
import com.example.agent.service.UslugaSmestajService;
import com.example.agent.ws.SmestajRequest;
import com.example.agent.ws.SmestajResponse;
import com.example.agent.ws.UslugaSmestajRequest;
import com.example.agent.ws.UslugaSmestajResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smestaj")
public class SmestajController {
	@Autowired
	SmestajRepository smestajRepository;

	@Autowired
	UslugaSmestajService uslugaSmestajService;

	@RequestMapping(method = RequestMethod.GET, value = "/moj/{id}")
	public ResponseEntity mojiSmestaji(@PathVariable Long id) {
		return ResponseEntity.ok(smestajRepository.findByAgent_Id(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/nov")
	public ResponseEntity kreiranjeSmestaja(@RequestBody Smestaj smestaj) {
		try {
			GenerickiClient client = new GenerickiClient(SmestajRequest.class, SmestajResponse.class);
			SmestajRequest smestajRequest = new SmestajRequest();
			smestajRequest.setAgentKime(smestaj.getAgent().getKime());
			smestajRequest.setBrojOsoba(smestaj.getBrojOsoba());
			smestajRequest.setOpis(smestaj.getOpis());
			smestajRequest.setLokacijaBekendId(smestaj.getLokacija().getBekendId());
			smestajRequest.setKategorijaBekendId(smestaj.getKategorijaSmestaja().getBekendId());
			smestajRequest.setTipBekendId(smestaj.getTipSmestaja().getBekendId());
			SmestajResponse smestajResponse = client.send(smestajRequest, "smestaj");
			smestaj.setBekendId(smestajResponse.getBekendId());
		}catch (Exception e){}
		Smestaj smeh = smestajRepository.save(smestaj);
		if (smeh != null) {
			return ResponseEntity.ok(smeh);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/uslugeSmestaja")
	public ResponseEntity kreiranjeSmestaja(@RequestBody List<UslugaSmestaj> uslugaSmestaj) {
		System.out.println("vuko");
		try {
			GenerickiClient client = new GenerickiClient(UslugaSmestajRequest.class, UslugaSmestajResponse.class);
			for (UslugaSmestaj us : uslugaSmestaj) {
				UslugaSmestajRequest uslugaSmestajRequest = new UslugaSmestajRequest();
				uslugaSmestajRequest.setSmestajBekendId(us.getSmestaj().getBekendId());
				uslugaSmestajRequest.setUslugaBekendId(us.getUsluga().getBekendId());
				UslugaSmestajResponse uslugaSmestajResponse = client.send(uslugaSmestajRequest, "uslugaSmestaj");
				us.setBekendId(uslugaSmestajResponse.getBekendId());
			}
		}catch (Exception e){}
		List<UslugaSmestaj> usme = uslugaSmestajService.noveVeze(uslugaSmestaj);
		if (usme != null) {
			return ResponseEntity.ok(usme);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}