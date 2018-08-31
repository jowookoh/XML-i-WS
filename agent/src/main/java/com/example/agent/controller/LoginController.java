package com.example.agent.controller;

import com.example.agent.client.GenerickiClient;
import com.example.agent.client.LoginClient;
import com.example.agent.model.Korisnik;
import com.example.agent.ws.LoginRequest;
import com.example.agent.ws.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity login(@RequestBody Korisnik korisnik) {
		//SmestajClient smestajClient = new SmestajClient();
		//System.out.println(smestajClient.getSmestaji().getSmestaji().get(0).getOpis());
		GenerickiClient client = new GenerickiClient(LoginRequest.class, LoginResponse.class);
		LoginRequest request = new LoginRequest();
		request.setKime(korisnik.getKime());
		request.setLozinka(korisnik.getLozinka());
		LoginResponse response = client.send(request, "login");//client.login(korisnik.getKime(), korisnik.getLozinka());
		System.out.println(response.isPostoji());
		return ResponseEntity.ok(response.isPostoji());
	}
}
