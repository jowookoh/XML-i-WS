package com.example.agent.service;

import com.example.agent.client.GenerickiClient;
import com.example.agent.model.*;
import com.example.agent.repository.*;
import com.example.agent.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LoginAndSyncService {
	//region Autovajrovi
	@Autowired
	TipSmestajaRepository tipSmestajaRepository;
	
	@Autowired
	KategorijaSmestajaRepository kategorijaSmestajaRepository;
	
	@Autowired
	UslugaRepository uslugaRepository;
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	RezervacijaRepository rezervacijaRepository;
	
	@Autowired
	PorukaRepository porukaRepository;
	
	@Autowired
	SmestajRepository smestajRepository;
	
	@Autowired
	LokacijaRepository lokacijaRepository;
	
	@Autowired
	CenaRepository cenaRepository;
	
	@Autowired
	UslugaSmestajRepository uslugaSmestajRepository;
	
	@Autowired
	SlikaRepository slikaRepository;
	//endregion
	
	private Korisnik ja;
	
	public boolean Login(Korisnik korisnik) {
		GenerickiClient client = new GenerickiClient(LoginRequest.class, LoginResponse.class);
		LoginRequest request = new LoginRequest();
		request.setKime(korisnik.getKime());
		request.setLozinka(korisnik.getLozinka());
		LoginResponse response = client.send(request, "login");//client.login(korisnik.getKime(), korisnik.getLozinka());
		ja = korisnik;
		if (response.isPostoji()) try {
			Presync();
			Sync(korisnik);
		} catch (Exception ignored) {
		}
		System.out.println(ja.getKime());
		return response.isPostoji();
	}
	
	@Transactional
	protected void Presync() {
		//region lokacija
		List<Lokacija> lokacijas = lokacijaRepository.findAll();
		//endregion
		
		//region cena
		
		//endregion
		
		//region porukaSend
		
		//endregion
		
		//region rezervacijaFejk
		
		//endregion
		
		//region rezervacijaRealizovana
		
		//endregion
		
		//region smestaj
		
		//endregion
		
		//region uslugaSmestaj
		
		//endregion
		
		//region slika
		
		//endregion
		
	}
	
	@Transactional
	protected void Sync(Korisnik korisnik) {
		//region tip smestaja
		GenerickiClient client = new GenerickiClient(TipSmestajaRequest.class, TipSmestajaResponse.class);
		TipSmestajaResponse tipSmestajaResponse = client.send(new TipSmestajaRequest(), "tipSmestaja");
		for (TipSmestajaJedan tipSmestajaJedan : tipSmestajaResponse.getTipoviSmestaja()) {
			TipSmestaja tipSmestaja = tipSmestajaRepository.findTipSmestajaByBekendId(tipSmestajaJedan.getBekendId());
			if (tipSmestaja == null) {
				tipSmestaja = new TipSmestaja();
				tipSmestaja.setBekendId(tipSmestajaJedan.getBekendId());
				tipSmestaja.setNaziv(tipSmestajaJedan.getOpis());
				tipSmestajaRepository.save(tipSmestaja);
			} else {
				tipSmestaja.setNaziv(tipSmestajaJedan.getOpis());
				tipSmestajaRepository.save(tipSmestaja);
			}
		}
		//endregion
		
		//region kategorija smestaja
		client = new GenerickiClient(KategorijaSmestajaRequest.class, KategorijaSmestajaResponse.class);
		KategorijaSmestajaResponse kategorijaSmestajaResponse = client.send(new KategorijaSmestajaRequest(), "kategorijaSmestaja");
		for (KategorijaSmestajaJedan kategorijaSmestajaJedan : kategorijaSmestajaResponse.getKategorijaoviSmestaja()) {
			KategorijaSmestaja kategorijaSmestaja = kategorijaSmestajaRepository.findKategorijaSmestajaByBekendId(kategorijaSmestajaJedan.getBekendId());
			if (kategorijaSmestaja == null) {
				kategorijaSmestaja = new KategorijaSmestaja();
				kategorijaSmestaja.setBekendId(kategorijaSmestajaJedan.getBekendId());
				kategorijaSmestaja.setNaziv(kategorijaSmestajaJedan.getOpis());
				kategorijaSmestajaRepository.save(kategorijaSmestaja);
			} else {
				kategorijaSmestaja.setNaziv(kategorijaSmestajaJedan.getOpis());
				kategorijaSmestajaRepository.save(kategorijaSmestaja);
			}
		}
		//endregion
		
		//region usluga
		client = new GenerickiClient(UslugaRequest.class, UslugaResponse.class);
		UslugaResponse uslugaResponse = client.send(new UslugaRequest(), "usluga");
		for (UslugaJedan uslugaJedan : uslugaResponse.getKategorijaoviSmestaja()) {
			Usluga usluga = uslugaRepository.findUslugaByBekendId(uslugaJedan.getBekendId());
			if (usluga == null) {
				usluga = new Usluga();
				usluga.setBekendId(uslugaJedan.getBekendId());
				usluga.setNaziv(uslugaJedan.getOpis());
				uslugaRepository.save(usluga);
			} else {
				usluga.setNaziv(uslugaJedan.getOpis());
				uslugaRepository.save(usluga);
			}
		}
		//endregion
		
		//region rezervacija => korisnik
		//rezervacija
		client = new GenerickiClient(RezervacijaRequest.class, RezervacijaResponse.class);
		RezervacijaRequest request = new RezervacijaRequest();
		request.setAgentKime(ja.getKime());
		RezervacijaResponse rezervacijaResponse = client.send(request, "rezervacija");
		//korisnikRepository.deleteAll();
		korisnikRepository.save(ja);
		//rezervacijaRepository.deleteAll();
		for (RezervacijaJedan rezervacijaJedan : rezervacijaResponse.getKategorijaoviSmestaja()) {
			
			Rezervacija rezervacija = rezervacijaRepository.findRezervacijaByBekendId(rezervacijaJedan.getBekendId());
			Korisnik klijent = korisnikRepository.findKorisnikByBekendId(rezervacijaJedan.getKorisnikBekendId());
			if (klijent == null) {
				klijent = new Korisnik();
				klijent.setBekendId(rezervacijaJedan.getKorisnikBekendId());
				klijent.setKime(rezervacijaJedan.getKime());
				klijent.setLozinka(rezervacijaJedan.getLozinka());
				korisnikRepository.save(klijent);
			} else {
				klijent.setKime(rezervacijaJedan.getKime());
				klijent.setLozinka(rezervacijaJedan.getLozinka());
				korisnikRepository.save(klijent);
			}
			if (rezervacija == null) {
				rezervacija = new Rezervacija();
				rezervacija.setBekendId(rezervacijaJedan.getBekendId());
				rezervacija.setSmestaj(smestajRepository.findSmestajByBekendId(rezervacijaJedan.getSmestajBekendId()));
				rezervacija.setKlijent(klijent);
				rezervacija.setOd(rezervacijaJedan.getOd().toGregorianCalendar().getTime());
				rezervacija.setPaOndaDo(rezervacijaJedan.getPaOndaDo().toGregorianCalendar().getTime());
				rezervacija.setOcena(rezervacijaJedan.getOcena());
				rezervacija.setKomentar(rezervacijaJedan.getKomentar());
				rezervacija.setOdobrenKomentar(rezervacijaJedan.isOdobrenKomentar());
				rezervacija.setRealizovana(rezervacijaJedan.isRealizovana());
				rezervacija.setFejk(rezervacijaJedan.isFejk());
				rezervacijaRepository.save(rezervacija);
			} else {
				rezervacija.setOcena(rezervacijaJedan.getOcena());
				rezervacija.setKomentar(rezervacijaJedan.getKomentar());
				rezervacija.setOdobrenKomentar(rezervacijaJedan.isOdobrenKomentar());
				rezervacijaRepository.save(rezervacija);
			}
		}
		//endregion
		
		//region poruka
		client = new GenerickiClient(PorukaRequest.class, PorukaResponse.class);
		PorukaRequest porukaRequest = new PorukaRequest();
		porukaRequest.setAgentId(ja.getBekendId());
		PorukaResponse porukaResponse = client.send(porukaRequest, "poruka");
		//porukaRepository.deleteAll();
		for (PorukaJedan porukaJedan : porukaResponse.getKategorijaoviSmestaja()) {
			Poruka poruka = porukaRepository.findPorukaByBekendId(porukaJedan.getBekendId());
			if (poruka == null) {
				poruka = new Poruka();
				poruka.setBekendId(porukaJedan.getBekendId());
				poruka.setPosiljalac(korisnikRepository.findKorisnikByBekendId(porukaJedan.getBekendId()));
				poruka.setRezervacija(rezervacijaRepository.findRezervacijaByBekendId(porukaJedan.getRezervacijaBekendId()));
				poruka.setTekst(porukaJedan.getTekst());
				poruka.setPoRedu(porukaJedan.getPoRedu());
				porukaRepository.save(poruka);
			}
		}
		//endregion
	}
	
	@Transactional
	public Korisnik getJa(String kime) {
		Korisnik korisnik = korisnikRepository.findByKime(kime);
		if (korisnik == null) korisnikRepository.save(ja);
		return ja;
	}
}
