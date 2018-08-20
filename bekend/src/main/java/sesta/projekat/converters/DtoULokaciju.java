package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.LokacijaDto;
import sesta.projekat.model.Lokacija;

@Component
public class DtoULokaciju implements Converter<LokacijaDto, Lokacija> {


    @Override
    public Lokacija convert(LokacijaDto source) {
        Lokacija lokacija = new Lokacija();
        lokacija.setDrzava(source.getDrzava());
        lokacija.setMesto(source.getMesto());

        return lokacija;
    }
}
