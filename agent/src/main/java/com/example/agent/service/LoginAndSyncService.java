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
	
	private Korisnik ja;
	
	public boolean Login(Korisnik korisnik){
		GenerickiClient client = new GenerickiClient(LoginRequest.class, LoginResponse.class);
		LoginRequest request = new LoginRequest();
		request.setKime(korisnik.getKime());
		request.setLozinka(korisnik.getLozinka());
		LoginResponse response = client.send(request, "login");//client.login(korisnik.getKime(), korisnik.getLozinka());
		ja = korisnik;
		System.out.println(response.isPostoji());
		if (response.isPostoji()) Sync(korisnik);
		return response.isPostoji();
	}
	
	@Transactional
	protected void Sync(Korisnik korisnik) {
		//region tip smestaja
		GenerickiClient client = new GenerickiClient(TipSmestajaRequest.class, TipSmestajaResponse.class);
		TipSmestajaResponse tipSmestajaResponse = client.send(new TipSmestajaRequest(), "tipSmestaja");
		tipSmestajaRepository.deleteAll();
		for (TipSmestajaJedan tipSmestajaJedan : tipSmestajaResponse.getTipoviSmestaja()) {
			TipSmestaja tipSmestaja = new TipSmestaja();
			tipSmestaja.setBekendId(tipSmestajaJedan.getBekendId());
			tipSmestaja.setNaziv(tipSmestajaJedan.getOpis());
			tipSmestajaRepository.save(tipSmestaja);
		}
		//endregion
		
		//region kategorija smestaja
		client = new GenerickiClient(KategorijaSmestajaRequest.class, KategorijaSmestajaResponse.class);
		KategorijaSmestajaResponse kategorijaSmestajaResponse = client.send(new KategorijaSmestajaRequest(), "kategorijaSmestaja");
		kategorijaSmestajaRepository.deleteAll();
		for (KategorijaSmestajaJedan kategorijaSmestajaJedan : kategorijaSmestajaResponse.getKategorijaoviSmestaja()){
			KategorijaSmestaja kategorijaSmestaja = new KategorijaSmestaja();
			kategorijaSmestaja.setBekendId(kategorijaSmestajaJedan.getBekendId());
			kategorijaSmestaja.setNaziv(kategorijaSmestajaJedan.getOpis());
			kategorijaSmestajaRepository.save(kategorijaSmestaja);
		}
		//endregion
		
		//region usluga
		client = new GenerickiClient(UslugaRequest.class, UslugaResponse.class);
		UslugaResponse uslugaResponse = client.send(new UslugaRequest(), "usluga");
		uslugaRepository.deleteAll();
		for (UslugaJedan uslugaJedan : uslugaResponse.getKategorijaoviSmestaja()){
			Usluga usluga = new Usluga();
			usluga.setBekendId(uslugaJedan.getBekendId());
			usluga.setNaziv(uslugaJedan.getOpis());
			uslugaRepository.save(usluga);
		}
		//endregion
		
		//region rezervacija => korisnik
			//rezervacija
		client = new GenerickiClient(RezervacijaRequest.class, RezervacijaResponse.class);
		RezervacijaResponse rezervacijaResponse = client.send(new RezervacijaRequest(), "rezervacija");
		korisnikRepository.deleteAll();
		korisnikRepository.save(ja);
		rezervacijaRepository.deleteAll();
		Set<Long> klijentBekendIdovi = new HashSet<>();
		for (RezervacijaJedan rezervacijaJedan : rezervacijaResponse.getKategorijaoviSmestaja()){
			Korisnik klijent = new Korisnik();
			klijent.setBekendId(rezervacijaJedan.getBekendId());
			klijent.setKime(rezervacijaJedan.getKime());
			klijent.setLozinka(rezervacijaJedan.getLozinka());
			if (klijentBekendIdovi.add(klijent.getBekendId())) korisnikRepository.save(klijent);
			Rezervacija rezervacija = new Rezervacija();
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
		}
		//endregion
		
		//region poruka
		client = new GenerickiClient(PorukaRequest.class, PorukaResponse.class);
		PorukaResponse porukaResponse = client.send(new PorukaRequest(), "poruka");
		porukaRepository.deleteAll();
		for (PorukaJedan porukaJedan : porukaResponse.getKategorijaoviSmestaja()){
			Poruka poruka = new Poruka();
			poruka.setBekendId(porukaJedan.getBekendId());
			poruka.setPosiljalac(korisnikRepository.findKorisnikByBekendId(porukaJedan.getBekendId()));
			poruka.setRezervacija(rezervacijaRepository.findRezervacijaByBekendId(porukaJedan.getRezervacijaBekendId()));
			poruka.setTekst(porukaJedan.getTekst());
			poruka.setPoRedu(porukaJedan.getPoRedu());
			porukaRepository.save(poruka);
		}
		//endregion
	}
}
