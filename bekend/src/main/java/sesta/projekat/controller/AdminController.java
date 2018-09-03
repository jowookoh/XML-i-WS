package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.model.Korisnik;
import sesta.projekat.service.KorisnikService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody Korisnik korisnik) {
        if(korisnik.getKime() == null || korisnik.getLozinka() == null){
            return ResponseEntity.badRequest().build();
        }
        Korisnik admin = korisnikService.getAdmin(korisnik.getKime(), korisnik.getLozinka());
        if (admin == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }
}
