package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.model.Smestaj;
import sesta.projekat.service.SmestajService;

import java.util.List;

@RestController
@RequestMapping("/smestaj")
public class SmestajController {
    @Autowired
    private SmestajService smestajService;

    @RequestMapping(method = RequestMethod.GET, value = "/uzmiSve")
    public ResponseEntity uzmiSve(){
        List<Smestaj> smestaji = smestajService.getAll();

        return ResponseEntity.ok(smestaji);
    }
}
