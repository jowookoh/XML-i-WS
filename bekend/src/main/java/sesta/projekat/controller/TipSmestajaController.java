package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.TipSmestaja;
import sesta.projekat.service.TipSmestajaService;

import java.util.List;

@RestController
@RequestMapping(TipSmestajaController.TIP_SMESTAJA_URI)
public class TipSmestajaController {

    public static final String TIP_SMESTAJA_URI = "tipoviSmestaja";

    @Autowired
    private TipSmestajaService tipSmestajaService;

    @GetMapping
    public ResponseEntity getAll(){
        List<TipSmestaja> tipoviSmestaja = tipSmestajaService.getAll();
        return ResponseEntity.ok(tipoviSmestaja);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getOne(@PathVariable final Long id){
        TipSmestaja ts = tipSmestajaService.findOne(id);
        if (ts == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ts);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteOne(@PathVariable final Long id){
        TipSmestaja ts = tipSmestajaService.findOne(id);
        if (ts == null){
            return ResponseEntity.notFound().build();
        }
        tipSmestajaService.deleteOne(ts);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TipSmestaja ts){
        ts = tipSmestajaService.save(ts);
        return ResponseEntity.ok(ts);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity update(@RequestBody TipSmestaja ts, @PathVariable Long id){
        TipSmestaja tsUpdated = tipSmestajaService.findOne(id);
        if (tsUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        tsUpdated.setNaziv(ts.getNaziv());
        tsUpdated = tipSmestajaService.save(tsUpdated);
        return ResponseEntity.ok(tsUpdated);
    }
}
