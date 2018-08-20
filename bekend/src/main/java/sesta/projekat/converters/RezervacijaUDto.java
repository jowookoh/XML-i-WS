package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.RezervacijaDto;
import sesta.projekat.model.Rezervacija;

import java.util.ArrayList;
import java.util.List;

@Component
public class RezervacijaUDto implements Converter<Rezervacija, RezervacijaDto> {
    @Override
    public RezervacijaDto convert(Rezervacija source) {
        RezervacijaDto rezervacijaDto = new RezervacijaDto();
        rezervacijaDto.setKomentar(source.getKomentar());
        rezervacijaDto.setPocetak(source.getOd());
        rezervacijaDto.setKraj(source.getPaOndaDo());
        rezervacijaDto.setOcena(source.getOcena());
        rezervacijaDto.setOdobrenKomentar(source.isOdobrenKomentar());
        rezervacijaDto.setRealizovana(source.isRealizovana());
        rezervacijaDto.setSmestajId(source.getSmestaj().getId());

        return rezervacijaDto;
    }

    public List<RezervacijaDto> convert(List<Rezervacija> source){
        List<RezervacijaDto> rezervacijaDtos = new ArrayList<>();
        for(Rezervacija rezervacija : source){
            rezervacijaDtos.add(convert(rezervacija));
        }
        return rezervacijaDtos;
    }
}
