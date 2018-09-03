package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.client.LoginClient;
import com.example.agent.model.Korisnik;
import com.example.agent.service.LoginAndSyncService;
import com.example.agent.ws.LoginRequest;
import com.example.agent.ws.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginAndSyncController {
	
	@Autowired
	LoginAndSyncService loginAndSyncService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity login(@RequestBody Korisnik korisnik) {
		return ResponseEntity.ok(loginAndSyncService.Login(korisnik));
	}
}
