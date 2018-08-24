package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.CenaDto;
import sesta.projekat.model.Cena;
import sesta.projekat.repository.CenaRepository;

@Component
public class DtoUCenu implements Converter<CenaDto, Cena> {
    @Autowired
    private CenaRepository cenaRepository;
    @Autowired
    private DtoUSmestaj dtoUSmestaj;
    @Override
    public Cena convert(CenaDto source) {
        Cena cena = new Cena();
        cena.setId(source.getId());
        cena.setMesec(source.getMesec());
        cena.setSmestaj(dtoUSmestaj.convert(source.getSmestajDto()));
        return cena;
    }
}
