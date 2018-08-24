package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.CenaDto;
import sesta.projekat.model.Cena;

@Component
public class CenaUDto implements Converter<Cena, CenaDto> {
    @Autowired
    private SmestajUDto smestajUDto;
    @Override
    public CenaDto convert(Cena source) {
        CenaDto cenaDto = new CenaDto();
        cenaDto.setId(source.getId());
        cenaDto.setMesec(source.getMesec());
        cenaDto.setSmestajDto(smestajUDto.convert(source.getSmestaj()));
        return cenaDto;
    }
}
