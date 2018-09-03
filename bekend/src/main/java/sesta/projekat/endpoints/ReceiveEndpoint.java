package sesta.projekat.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sesta.projekat.model.*;
import sesta.projekat.repository.*;
import sesta.projekat.ws.*;

import java.util.List;

@Endpoint
@Scope
public class ReceiveEndpoint {
	@Autowired
	LokacijaRepository lokacijaRepository;
	
	@Autowired
	CenaRepository cenaRepository;
	
	@Autowired
	SmestajRepository smestajRepository;
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	PorukaRepository porukaRepository;
	
	@Autowired
	RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	UslugaRepository uslugaRepository;
	
	@Autowired
	UslugaSmestajRepository uslugaSmestajRepository;
	
	@PayloadRoot(namespace = "http://xml/ws/lokacija", localPart = "lokacijaRequest")
	@ResponsePayload
	public LokacijaResponse rlokacija(@RequestPayload LokacijaRequest request) {
		Lokacija lokacija = new Lokacija();
		lokacija.setDrzava(request.getDrzava());
		lokacija.setMesto(request.getMesto());
		lokacijaRepository.save(lokacija);
		LokacijaResponse response = new LokacijaResponse();
		response.setBekendId(lokacija.getId());
		return response;
	}
	
	@PayloadRoot(namespace = "http://xml/ws/cena", localPart = "cenaRequest")
	@ResponsePayload
	public CenaResponse rcena(@RequestPayload CenaRequest request) {
		Cena cena = new Cena();
		cena.setSmestaj(smestajRepository.getOne(request.getSmestajId()));
		cena.setMesec(request.getMesec().toGregorianCalendar().getTime());
		cena.setVrednost(request.getVrednost());
		cenaRepository.save(cena);
		CenaResponse response = new CenaResponse();
		response.setBekendId(cena.getId());
		return response;
	}
	
	@PayloadRoot(namespace = "http://xml/ws/porukaSend", localPart = "porukaSendRequest")
	@ResponsePayload
	public PorukaSendResponse rporukaSend(@RequestPayload PorukaSendRequest request) {
		Poruka poruka = new Poruka();
		poruka.setPosiljalac(korisnikRepository.findKorisnikByKime(request.getKime()));
		poruka.setRezervacija(rezervacijaRepository.getOne(request.getRezervacijaId()));
		poruka.setTekst(request.getTekst());
		poruka.setPoRedu(request.getPoRedu());
		porukaRepository.save(poruka);
		PorukaSendResponse response = new PorukaSendResponse();
		response.setBekendId(poruka.getId());
		return response;
	}
	
	/*@PayloadRoot(namespace = "http://xml/ws/rezervacijaFejk", localPart = "rezervacijaFejkRequest")
	@ResponsePayload
	public RezervacijaFejkResponse rrezervacijaFejk(@RequestPayload RezervacijaFejkRequest request) {
		Rezervacija rezervacija = new Rezervacija();
		//rezervacija.set
		rezervacijaRepository.save(rezervacija);
		RezervacijaFejkResponse response = new RezervacijaFejkResponse();
		response.setBekendId(rezervacija.getId());
		return response;
	}*/
}
