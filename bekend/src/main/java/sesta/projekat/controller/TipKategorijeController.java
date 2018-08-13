package sesta.projekat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tip")
public class TipKategorijeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/poz")
	public ResponseEntity hello(){
		return ResponseEntity.ok("poz");
	}
}
