package sesta.projekat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.model.TipSmestaja;

@RestController
@RequestMapping("/tip")
public class TipKategorijeController {

	@RequestMapping(method = RequestMethod.GET, value = "/poz")
	public ResponseEntity hello(){
		TipSmestaja t = new TipSmestaja();
		t.setNaziv("okej");
		t.setId(134l);
		return ResponseEntity.ok(t);
	}
}
