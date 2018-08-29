package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.dto.PretragaDto;
import sesta.projekat.model.Cena;
import sesta.projekat.model.Lokacija;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.model.Smestaj;
import sesta.projekat.service.LokacijaService;
import sesta.projekat.service.RezervacijaService;
import sesta.projekat.service.SmestajService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/smestaj")
public class SmestajController {
    @Autowired
    private SmestajService smestajService;
    @Autowired
    private LokacijaService lokacijaService;
    @Autowired
    private RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.GET, value = "/uzmiSve")
    public ResponseEntity uzmiSve() {
        List<Smestaj> smestaji = smestajService.getAll();

        return ResponseEntity.ok(smestaji);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trazi")
    public ResponseEntity pretrazi(@RequestBody PretragaDto pretragaDto) {
        List<Smestaj> smestajs = new ArrayList<>();
        List<Smestaj> vracanje = new ArrayList<>();
        List<Smestaj> tempSmestaji = new ArrayList<>();
        List<Date> tempMeseci = new ArrayList<>();
        Lokacija lokacija = lokacijaService.findOne(pretragaDto.getIdLokacije());
        List<Smestaj> allSmestajs = smestajService.getAll();

        //prvo nadji sve sa tom lokacijom koji uopste imaju listu cena
        for (Smestaj smestaj : allSmestajs) {
            if (smestaj.getLokacija().getId() == pretragaDto.getIdLokacije()) {
                if (smestaj.getCene() != null) {
                    tempSmestaji.add(smestaj);
                }
            }
        }

        //onda prodji kroz sve rezervacije i proveri da li je bilo koji od pronadjenih smestaja slobodan
        List<Rezervacija> allRezervacije = rezervacijaService.getAll();
        vracanje.addAll(tempSmestaji);
        for (Rezervacija rezervacija : allRezervacije) {
            for (Smestaj smestaj : tempSmestaji) {
                if (smestaj.getId() == rezervacija.getSmestaj().getId()) {
                    if (pretragaDto.getPrvi().after(rezervacija.getOd()) && pretragaDto.getPrvi().before(rezervacija.getPaOndaDo())) {
                        vracanje.remove(smestaj);
                    } else if (pretragaDto.getDrugi().after(rezervacija.getOd()) && pretragaDto.getDrugi().before(rezervacija.getPaOndaDo())) {
                        vracanje.remove(smestaj);
                    }
                }
            }
        }

        return ResponseEntity.ok(vracanje);
    }
}
