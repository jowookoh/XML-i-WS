package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sesta.projekat.dto.CenaDto;
import sesta.projekat.dto.PretragaDto;
import sesta.projekat.dto.SmestajDtoResponse;
import sesta.projekat.model.*;
import sesta.projekat.service.*;

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
    @Autowired
    private SlikaService slikaService;
    @Autowired
    private UslugaSmestajService uslugaSmestajService;

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
        List<Lokacija> sveLokacija = lokacijaService.getAll();
        List<Lokacija> tempLokacije = new ArrayList<>();
        List<Smestaj> allSmestajs = smestajService.getAll();

        for(Lokacija lokacija : sveLokacija){
            if(lokacija.getMesto().contains(pretragaDto.getLokacija()) || lokacija.getDrzava().contains(pretragaDto.getLokacija())){
                tempLokacije.add(lokacija);
            }
        }

        //prvo nadji sve sa tom lokacijom koji uopste imaju listu cena
        for (Smestaj smestaj : allSmestajs) {
            for(Lokacija lokacija : tempLokacije) {
                if (smestaj.getLokacija().getId() == lokacija.getId()) {
                    if (smestaj.getCene().size() > 0) {
                        tempSmestaji.add(smestaj);
                    }
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

        List<SmestajDtoResponse> response = new ArrayList<>();
        for(Smestaj smestaj : vracanje){
            SmestajDtoResponse s = new SmestajDtoResponse();
            s.setOpis(smestaj.getOpis());

            List<Slika> sveSlike = slikaService.getAll();
            List<String> slike = new ArrayList<>();

            for(Slika slika : sveSlike){
                if(slika.getSmestaj().getId() == smestaj.getId()){
                    slike.add(slika.getSlika());
                }
            }
            s.setSlike(slike);

            List<CenaDto> cene = new ArrayList<>();
            for(Cena cena : smestaj.getCene()){
                CenaDto c = new CenaDto();
                c.setMesec(cena.getMesec());
                c.setVrednost(cena.getVrednost());
                cene.add(c);
            }
            s.setCene(cene);

            s.setKategorija(smestaj.getKategorijaSmestaja().getNaziv());
            s.setTipSmestaja(smestaj.getTipSmestaja().getNaziv());


            List<String> usluge = new ArrayList<>();
            for(UslugaSmestaj uslugaSmestaj : uslugaSmestajService.getAll()){
                if(uslugaSmestaj.getSmestaj().getId() == smestaj.getId()){
                    usluge.add(uslugaSmestaj.getUsluga().getNaziv());
                }
            }
            s.setUsluge(usluge);
            response.add(s);
        }
        return ResponseEntity.ok(response);
    }
}
