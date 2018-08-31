package sesta.projekat.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sesta.projekat.model.Korisnik;
import sesta.projekat.service.KorisnikService;
import sesta.projekat.ws.*;

import java.util.ArrayList;
import java.util.List;

@Endpoint
@Scope
public class HelloWorldEndpoint {
	private static final String SMESTAJ_URI = "http://xml/ws/smestaj";
	private static final String LOGIN_URI = "http://xml/ws/login";
	
	@Autowired
	KorisnikService korisnikService;
	
	@PayloadRoot(namespace = SMESTAJ_URI, localPart = "smestajRequest")
	@ResponsePayload
	public SmestajResponse smesssssstaj(@RequestPayload SmestajRequest request) {
		SmestajJedan sj = new SmestajJedan();
		sj.setOpis("dobarr");
		SmestajJedan sd = new SmestajJedan();
		sd.setOpis("dobarr dva");
		SmestajResponse sr = new SmestajResponse();
		sr.getSmestaji().add(sj);
		sr.getSmestaji().add(sd);
		return sr;
	}
	
	@PayloadRoot(namespace = LOGIN_URI, localPart = "loginRequest")
	@ResponsePayload
	public LoginResponse login(@RequestPayload LoginRequest request) {
		List<Korisnik> korisnici = korisnikService.getAll();
		LoginResponse response = new LoginResponse();
		for (Korisnik korisnik : korisnici) {
			if (korisnik.getKime().equals(request.getKime()) && korisnik.getLozinka().equals(request.getLozinka()) &&
					korisnik.getTipKorisnika().equals("agent")) {
				response.setPostoji(true);
				return response;
			}
		}
		response.setPostoji(false);
		return response;
	}
}
