package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Korisnik;
import sesta.projekat.service.KorisnikService;

import java.util.List;

@RestController
@RequestMapping(AgentController.AGENT_URI)
public class AgentController {

    public static final String AGENT_URI = "agent";

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Korisnik> agenti = korisnikService.getAllAgents();
        return ResponseEntity.ok(agenti);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getOne(@PathVariable final Long id){
        Korisnik k = korisnikService.findOne(id);
        if (k == null || !k.getTipKorisnika().equals("agent")){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(k);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteOne(@PathVariable final Long id){
        Korisnik k = korisnikService.findOne(id);
        if (k == null || !k.getTipKorisnika().equals("agent")){
            return ResponseEntity.notFound().build();
        }
        korisnikService.deleteOne(k);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Korisnik k){
        k.setTipKorisnika("agent");
        k = korisnikService.save(k);
        return ResponseEntity.ok(k);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update(@RequestBody Korisnik k, @PathVariable Long id){
        Korisnik kUpdated;
        kUpdated = korisnikService.findOne(id);
        if (kUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        kUpdated.setIme(k.getIme());
        kUpdated.setPrezime(k.getPrezime());
        kUpdated.setKime(k.getKime());
        kUpdated.setAdresa(k.getAdresa());
        kUpdated.setPoslovniMaticniBroj(k.getPoslovniMaticniBroj());
        kUpdated = korisnikService.save(kUpdated);
        return ResponseEntity.ok(kUpdated);
    }
}
