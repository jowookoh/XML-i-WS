package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.Usluga;
import sesta.projekat.service.UslugaService;

import java.util.List;

@RestController
@RequestMapping(UslugaController.USLUGA_URI)
public class UslugaController {

    public static final String USLUGA_URI = "usluga";

    @Autowired
    private UslugaService uslugaService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Usluga> usluge = uslugaService.getAll();
        return ResponseEntity.ok(usluge);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getOne(@PathVariable final Long id){
        Usluga u = uslugaService.findOne(id);
        if (u == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteOne(@PathVariable final Long id){
        Usluga u = uslugaService.findOne(id);
        if (u == null){
            return ResponseEntity.notFound().build();
        }
        uslugaService.deleteOne(u);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Usluga u){
        u = uslugaService.save(u);
        return ResponseEntity.ok(u);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update(@RequestBody Usluga u, @PathVariable Long id){
        Usluga uUpdated;
        uUpdated = uslugaService.findOne(id);
        if (uUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        uUpdated.setNaziv(u.getNaziv());
        uUpdated = uslugaService.save(uUpdated);
        return ResponseEntity.ok(uUpdated);
    }
}
