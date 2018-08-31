package com.example.agent.controller;

import com.example.agent.model.Smestaj;
import com.example.agent.model.UslugaSmestaj;
import com.example.agent.repository.SmestajRepository;
import com.example.agent.service.UslugaSmestajService;
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
		Smestaj smeh = smestajRepository.save(smestaj);
		if (smeh != null) {
			return ResponseEntity.ok(smeh);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/uslugeSmestaja")
	public ResponseEntity kreiranjeSmestaja(@RequestBody List<UslugaSmestaj> uslugaSmestaj) {
		List<UslugaSmestaj> usme = uslugaSmestajService.noveVeze(uslugaSmestaj);
		if (usme != null) {
			return ResponseEntity.ok(usme);
		} else {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}