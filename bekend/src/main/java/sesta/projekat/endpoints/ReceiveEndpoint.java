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

	@Autowired
	KategorijaSmestajaRepository kategorijaSmestajaRepository;

	@Autowired
	TipSmestajaRepository tipSmestajaRepository;

	@Autowired
	SlikaRepository slikaRepository;
	
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
		poruka.setRezervacija(rezervacijaRepository.findOne(request.getRezervacijaId()));
		poruka.setTekst(request.getTekst());
		poruka.setPoRedu(request.getPoRedu());
		porukaRepository.save(poruka);
		PorukaSendResponse response = new PorukaSendResponse();
		response.setBekendId(poruka.getId());
		return response;
	}
	
	@PayloadRoot(namespace = "http://xml/ws/rezervacijaFejk", localPart = "rezervacijaFejkRequest")
	@ResponsePayload
	public RezervacijaFejkResponse rrezervacijaFejk(@RequestPayload RezervacijaFejkRequest request) {
		Rezervacija rezervacija = new Rezervacija();
		rezervacija.setOd(request.getOd().toGregorianCalendar().getTime());
		rezervacija.setPaOndaDo(request.getPaOndaDo().toGregorianCalendar().getTime());
		rezervacija.setSmestaj(smestajRepository.findOne(request.getSmestajId()));
		rezervacijaRepository.save(rezervacija);
		RezervacijaFejkResponse response = new RezervacijaFejkResponse();
		response.setBekendId(rezervacija.getId());
		return response;
	}

	@PayloadRoot(namespace = "http://xml/ws/rezervacijaRealizovana", localPart = "rezervacijaRealizovanaRequest")
	@ResponsePayload
	public RezervacijaRealizovanaResponse rrezervacijaRealizovana(@RequestPayload RezervacijaRealizovanaRequest request){
		Rezervacija rezervacija=rezervacijaRepository.findOne(request.getBekendId());
		rezervacija.setRealizovana(true);
		rezervacijaRepository.save(rezervacija);
		RezervacijaRealizovanaResponse response = new RezervacijaRealizovanaResponse();
		response.setBekendId(rezervacija.getId());
		return response;
	}

	@PayloadRoot(namespace = "http://xml/ws/smestaj", localPart = "smestajRequest")
	@ResponsePayload
	public SmestajResponse rsmestaj(@RequestPayload SmestajRequest request){
		Smestaj smestaj = new Smestaj();
		smestaj.setAgent(korisnikRepository.findKorisnikByKime(request.getAgentKime()));
		smestaj.setBrojOsoba(request.getBrojOsoba());
		smestaj.setOpis(request.getOpis());
		smestaj.setKategorijaSmestaja(kategorijaSmestajaRepository.findOne(request.getKategorijaBekendId()));
		smestaj.setTipSmestaja(tipSmestajaRepository.findOne(request.getTipBekendId()));
		smestaj.setLokacija(lokacijaRepository.findOne(request.getLokacijaBekendId()));
		smestajRepository.save(smestaj);
		SmestajResponse response = new SmestajResponse();
		response.setBekendId(smestaj.getId());
		return response;
	}

	@PayloadRoot(namespace = "http://xml/ws/uslugaSmestaj", localPart = "uslugaSmestajRequest")
	@ResponsePayload
	public UslugaSmestajResponse ruslugaSmestaj(@RequestPayload UslugaSmestajRequest request){
		UslugaSmestaj uslugaSmestaj = new UslugaSmestaj();
		uslugaSmestaj.setSmestaj(smestajRepository.findOne(request.getSmestajBekendId()));
		uslugaSmestaj.setUsluga(uslugaRepository.findOne(request.getUslugaBekendId()));
		uslugaSmestajRepository.save(uslugaSmestaj);
		UslugaSmestajResponse response = new UslugaSmestajResponse();
		response.setBekendId(uslugaSmestaj.getId());
		return response;
	}

	@PayloadRoot(namespace = "http://xml/ws/slika", localPart = "slikaRequest")
	@ResponsePayload
	public SlikaResponse rslika(@RequestPayload SlikaRequest request){
		Slika slika = new Slika();
		slika.setSlika(request.getAdresa());
		slika.setSmestaj(smestajRepository.getOne(request.getSmestajBekendId()));
		slikaRepository.save(slika);
		SlikaResponse response = new SlikaResponse();
		response.setBekendId(slika.getId());
		return response;
	}
}
