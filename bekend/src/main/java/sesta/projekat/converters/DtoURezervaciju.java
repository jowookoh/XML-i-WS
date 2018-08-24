package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.RezervacijaDto;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.service.RezervacijaService;
import sesta.projekat.service.SmestajService;

@Component
public class DtoURezervaciju implements Converter<RezervacijaDto, Rezervacija> {

    @Autowired
    RezervacijaService rezervacijaService;
    @Autowired
    SmestajService smestajService;

    @Override
    public Rezervacija convert(RezervacijaDto rezervacijaDto){
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setId(rezervacijaDto.getId());
        rezervacija.setSmestaj(smestajService.findOne(rezervacijaDto.getSmestajId()));
        rezervacija.setOd(rezervacijaDto.getPocetak());
        rezervacija.setPaOndaDo(rezervacijaDto.getKraj());
        rezervacija.setKomentar(rezervacijaDto.getKomentar());
        rezervacija.setOcena(rezervacija.getOcena());
        rezervacija.setOdobrenKomentar(rezervacija.isOdobrenKomentar());
        rezervacija.setRealizovana(rezervacija.isRealizovana());

        return rezervacija;
    }
}
