package com.example.agent.service;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.Korisnik;
import com.example.agent.ws.*;
import org.springframework.stereotype.Service;

@Service
public class LoginAndSyncService {
	
	public boolean Login(Korisnik korisnik){
		GenerickiClient client = new GenerickiClient(LoginRequest.class, LoginResponse.class);
		LoginRequest request = new LoginRequest();
		request.setKime(korisnik.getKime());
		request.setLozinka(korisnik.getLozinka());
		LoginResponse response = client.send(request, "login");//client.login(korisnik.getKime(), korisnik.getLozinka());
		System.out.println(response.isPostoji());
		if (response.isPostoji()) Sync(korisnik);
		return response.isPostoji();
	}
	
	private void Sync(Korisnik korisnik) {
		//region tip smestaja
		GenerickiClient client = new GenerickiClient(TipSmestajaRequest.class, TipSmestajaResponse.class);
		TipSmestajaResponse tipSmestajaResponse = client.send(new TipSmestajaRequest(), "tipSmestaja");
		for (TipSmestajaJedan tipSmestajaJedan : tipSmestajaResponse.getTipoviSmestaja()) {
		
		}
		//endregion
		
		//region kategorija smestaja
		client = new GenerickiClient(KategorijaSmestajaRequest.class, KategorijaSmestajaResponse.class);
		KategorijaSmestajaResponse kategorijaSmestajaResponse = client.send(new KategorijaSmestajaRequest(), "kategorijaSmestaja");
		
		//endregion
		
		//region usluga
		client = new GenerickiClient(UslugaRequest.class, UslugaResponse.class);
		UslugaResponse uslugaResponse = client.send(new UslugaRequest(), "usluga");
		
		//endregion
		
		//region rezervacija => korisnik
			//rezervacija
		client = new GenerickiClient(RezervacijaRequest.class, RezervacijaResponse.class);
		RezervacijaResponse rezervacijaResponse = client.send(new RezervacijaRequest(), "rezervacija");
		
		//endregion
		
		//region poruka
		client = new GenerickiClient(PorukaRequest.class, PorukaResponse.class);
		PorukaResponse porukaResponse = client.send(new PorukaRequest(), "poruka");
		
		//endregion
	}
}
