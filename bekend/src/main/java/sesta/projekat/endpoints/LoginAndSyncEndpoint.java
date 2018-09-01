package sesta.projekat.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sesta.projekat.model.*;
import sesta.projekat.repository.PorukaRepository;
import sesta.projekat.service.*;
import sesta.projekat.ws.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
@Scope
public class LoginAndSyncEndpoint {
	private static final String SMESTAJ_URI = "http://xml/ws/smestaj";
	private static final String LOGIN_URI = "http://xml/ws/login";
	private static final String TIP_SMESTAJA_URI = "http://xml/ws/tipSmestaja";
	private static final String KATEGORIJA_SMESTAJA_URI = "http://xml/ws/kategorijaSmestaja";
	private static final String USLUGA_URI = "http://xml/ws/usluga";
	private static final String REZERVACIJA_URI = "http://xml/ws/rezervacija";
	private static final String PORUKA_URI = "http://xml/ws/poruka";

	@Autowired
	KorisnikService korisnikService;
	@Autowired
	TipSmestajaService tipSmestajaService;
	@Autowired
	KategorijaSmestajaService kategorijaSmestajaService;
	@Autowired
	UslugaService uslugaService;
	@Autowired
	RezervacijaService rezervacijaService;
	@Autowired
	PorukaService porukaService;

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

	@PayloadRoot(namespace = KATEGORIJA_SMESTAJA_URI, localPart = "kategorijaSmestajaRequest")
	@ResponsePayload
	public KategorijaSmestajaResponse sveKategorije(@RequestPayload KategorijaSmestajaRequest request) {
		List<KategorijaSmestaja> kategorijeSmestaja = kategorijaSmestajaService.getAll();
		KategorijaSmestajaResponse response = new KategorijaSmestajaResponse();
		for (KategorijaSmestaja kategorijaSmestaja : kategorijeSmestaja) {
			KategorijaSmestajaJedan kategorijaSmestajaJedan = new KategorijaSmestajaJedan();
			kategorijaSmestajaJedan.setBekendId(kategorijaSmestaja.getId());
			kategorijaSmestajaJedan.setOpis(kategorijaSmestaja.getNaziv());
			response.getKategorijaoviSmestaja().add(kategorijaSmestajaJedan);
		}
		return response;
	}

	@PayloadRoot(namespace = TIP_SMESTAJA_URI, localPart = "tipSmestajaRequest")
	@ResponsePayload
	public TipSmestajaResponse sviTipovi(@RequestPayload TipSmestajaRequest request) {
		List<TipSmestaja> tipoviSmestaja = tipSmestajaService.getAll();
		TipSmestajaResponse response = new TipSmestajaResponse();
		for (TipSmestaja tipSmestaja : tipoviSmestaja) {
			TipSmestajaJedan tipSmestajaJedan = new TipSmestajaJedan();
			tipSmestajaJedan.setBekendId(tipSmestaja.getId());
			tipSmestajaJedan.setOpis(tipSmestaja.getNaziv());
			response.getTipoviSmestaja().add(tipSmestajaJedan);
		}
		return response;
	}

	@PayloadRoot(namespace = USLUGA_URI, localPart = "uslugaRequest")
	@ResponsePayload
	public UslugaResponse sveUsluge(@RequestPayload UslugaRequest request) {
		List<Usluga> usluge = uslugaService.getAll();
		UslugaResponse response = new UslugaResponse();
		for (Usluga usluga : usluge) {
			UslugaJedan uslugaJedan = new UslugaJedan();
			uslugaJedan.setBekendId(usluga.getId());
			uslugaJedan.setOpis(usluga.getNaziv());
			response.getKategorijaoviSmestaja().add(uslugaJedan);
		}
		return response;
	}

	@PayloadRoot(namespace = REZERVACIJA_URI, localPart = "rezervacijaRequest")
	@ResponsePayload
	public RezervacijaResponse sveRezervacije(@RequestPayload RezervacijaRequest request) {
		List<Rezervacija> rezervacije = rezervacijaService.getAll();
		RezervacijaResponse response = new RezervacijaResponse();
		for (Rezervacija rezervacija : rezervacije) {
			if(rezervacija.getSmestaj().getAgent().getId() == request.getAgentId()){
				RezervacijaJedan rezervacijaJedan = new RezervacijaJedan();
				rezervacijaJedan.setBekendId(rezervacija.getId());
				rezervacijaJedan.setFejk(rezervacija.isFejk());
				rezervacijaJedan.setKime(rezervacija.getKlijent().getKime());
				rezervacijaJedan.setKomentar(rezervacija.getKomentar());
				rezervacijaJedan.setKorisnikBekendId(rezervacija.getKlijent().getId());
				rezervacijaJedan.setLozinka(rezervacija.getKlijent().getLozinka());
				rezervacijaJedan.setOcena(rezervacija.getOcena());
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(rezervacija.getOd());
				XMLGregorianCalendar dateOd = null;
				try {
					dateOd = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				}
				rezervacijaJedan.setOd(dateOd);
				c.setTime(rezervacija.getPaOndaDo());
				XMLGregorianCalendar datePaOndaDo = null;
				try {
					datePaOndaDo = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
				}
				rezervacijaJedan.setPaOndaDo(datePaOndaDo);
				rezervacijaJedan.setRealizovana(rezervacija.isRealizovana());
				rezervacijaJedan.setOdobrenKomentar(rezervacija.isOdobrenKomentar());
				response.getKategorijaoviSmestaja().add(rezervacijaJedan);
			}
		}
		return response;
	}



	@PayloadRoot(namespace = PORUKA_URI, localPart = "porukaRequest")
	@ResponsePayload
	public PorukaResponse svePoruke(@RequestPayload PorukaRequest request) {
		List<Poruka> poruke = porukaService.getAll();
		PorukaResponse response = new PorukaResponse();
		for (Poruka poruka : poruke) {
			if(poruka.getRezervacija().getSmestaj().getAgent().getId() == request.getAgentId()){
				PorukaJedan porukaJedan = new PorukaJedan();
				porukaJedan.setBekendId(poruka.getId());
				porukaJedan.setPoRedu(poruka.getPoRedu());
				porukaJedan.setPosiljalacBekendId(poruka.getPosiljalac().getId());
				porukaJedan.setRezervacijaBekendId(poruka.getRezervacija().getId());
				porukaJedan.setTekst(poruka.getTekst());
				response.getKategorijaoviSmestaja().add(porukaJedan);
			}
		}
		return response;
	}
}
