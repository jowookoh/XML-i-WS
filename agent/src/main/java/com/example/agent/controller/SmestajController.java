package com.example.agent.controller;

import com.example.agent.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/smestaj")
public class SmestajController {
	@Autowired
	SmestajRepository smestajRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/moj/{id}")
	public ResponseEntity mojiSmestaji(@PathVariable Long id){
		return ResponseEntity.ok(smestajRepository.findByAgent_Id(id));
	}
}
