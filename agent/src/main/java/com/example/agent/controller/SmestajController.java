package com.example.agent.controller;

import com.example.agent.model.TipSmestaja;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tip")
public class SmestajController {
	@RequestMapping(method = RequestMethod.GET, value = "/poz")
	public ResponseEntity hello(){
		TipSmestaja t = new TipSmestaja();
		t.setNaziv("okej");
		t.setId(135l);
		return ResponseEntity.ok(t);
	}
}
