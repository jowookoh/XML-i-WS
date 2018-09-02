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

import java.time.LocalDate;
import java.time.ZoneId;
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
    @Autowired
    private CenaService cenaService;

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
            if(lokacija.getMesto().toLowerCase().contains(pretragaDto.getLokacija().toLowerCase()) || lokacija.getDrzava().toLowerCase().contains(pretragaDto.getLokacija().toLowerCase())){
                tempLokacije.add(lokacija);
            }
        }
        //prvo nadji sve sa tom lokacijom koji uopste imaju listu cena
        for (Smestaj smestaj : allSmestajs) {
            for(Lokacija lokacija : tempLokacije) {
                if (smestaj.getLokacija().getId() == lokacija.getId()) {
                    List<Cena> ceneSmestaja = new ArrayList<>();
                    for(Cena cena : cenaService.getAll()){
                        if(cena.getSmestaj().getId() == smestaj.getId()){
                            ceneSmestaja.add(cena);
                        }
                    }
                    if (ceneSmestaja.size() > 0) {
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
            List<Cena> ceneSmestaja = new ArrayList<>();
            for(Cena cena : cenaService.getAll()){
                if(cena.getSmestaj().getId() == smestaj.getId()){
                    ceneSmestaja.add(cena);
                }
            }
            int vrednost = 0;
            for(Cena cena : ceneSmestaja){
                CenaDto c = new CenaDto();
                Date datum = cena.getMesec();
                LocalDate date1 = pretragaDto.getPrvi().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = pretragaDto.getDrugi().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate dateCena = datum.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(date1.getMonth() == date2.getMonth()){
                    if(date1.getMonth() == dateCena.getMonth()) {
                        int brDana = date2.getDayOfMonth() - date1.getDayOfMonth();
                        vrednost += brDana * cena.getVrednost()*pretragaDto.getBrojOsoba();
                    }
                }else {
                    if (date1.getMonth() == dateCena.getMonth()) {
                        int mPocetak = date1.getMonth().getValue();
                        int dPocetak = date1.getDayOfMonth();
                        int brojDanaPrviDatum = uzmiBrojDana(mPocetak);
                        int brDana = brojDanaPrviDatum - dPocetak;
                        vrednost += brDana * cena.getVrednost()*pretragaDto.getBrojOsoba();
                    }
                    if (date2.getMonth().getValue() == dateCena.getMonth().getValue()) {
                        int mKraj = date2.getMonth().getValue();
                        int dKraj = date2.getDayOfMonth();
                        int brDana = dKraj;
                        vrednost += brDana * cena.getVrednost()*pretragaDto.getBrojOsoba();
                    }
                }
            }
            s.setCena(vrednost);
            double ocena = 0;
            int cnt = 0;
            s.setKomentari(new ArrayList<>());
            //prodji kroz snew neve rezervacije koje su vezane za taj smestaj i dodaj njihove komentare u smestaj
            //i pronadji srednju ocenu od svih tih rezervacija
            for(Rezervacija rezervacija : rezervacijaService.getAll()){
                if(rezervacija.getSmestaj().getId() == smestaj.getId()){
                    if(rezervacija.getKomentar() != null && !rezervacija.getKomentar().equals("")) {
                        s.getKomentari().add(rezervacija.getKomentar());
                    }
                    if(rezervacija.getOcena() >= 1 && rezervacija.getOcena() <= 5){
                        ocena = ocena + rezervacija.getOcena();
                        cnt = cnt + 1;
                    }
                }
            }
            s.setOcena(ocena / cnt);
            s.setKategorija(smestaj.getKategorijaSmestaja().getNaziv());
            s.setTipSmestaja(smestaj.getTipSmestaja().getNaziv());


            List<String> usluge = new ArrayList<>();
            for(UslugaSmestaj uslugaSmestaj : uslugaSmestajService.getAll()){
                if(uslugaSmestaj.getSmestaj().getId() == smestaj.getId()){
                    usluge.add(uslugaSmestaj.getUsluga().getNaziv());
                }
            }
            s.setUsluge(usluge);
            s.setId(smestaj.getId());

            response.add(s);
        }
        return ResponseEntity.ok(response);
    }

    private int uzmiBrojDana(int mesec){
        int retVal = 0;
        switch (mesec){
            case 1:
                retVal = 31;
                break;
            case 3:
                retVal = 31;
                break;
            case 5:
                retVal = 31;
                break;
            case 7:
                retVal = 31;
                break;
            case 8:
                retVal = 31;
                break;
            case 10:
                retVal = 31;
                break;
            case 12:
                retVal = 31;
                break;
            case 2:
                retVal = 28;
                break;
            case 4:
                retVal = 30;
                break;
            case 6:
                retVal = 30;
                break;
            case 9:
                retVal = 30;
                break;
            case 11:
                retVal = 30;
                break;

        }
        return retVal;
    }
}
