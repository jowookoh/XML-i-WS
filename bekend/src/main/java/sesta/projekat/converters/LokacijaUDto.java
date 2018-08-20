package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.LokacijaDto;
import sesta.projekat.model.Lokacija;

import java.util.ArrayList;
import java.util.List;

@Component
public class LokacijaUDto implements Converter<Lokacija, LokacijaDto> {
    @Override
    public LokacijaDto convert(Lokacija source) {
        LokacijaDto lokacijaDto = new LokacijaDto(source.getId(), source.getDrzava(), source.getMesto());
        return lokacijaDto;
    }

    public List<LokacijaDto> convert(List<Lokacija> source){
        List<LokacijaDto> lokacijaDtos = new ArrayList<>();
        for(Lokacija lokacija : source){
            lokacijaDtos.add(convert(lokacija));
        }
        return lokacijaDtos;
    }
}
