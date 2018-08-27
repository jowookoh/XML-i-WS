package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.PorukaDto;
import sesta.projekat.model.Poruka;
import sesta.projekat.service.PorukaService;
import sesta.projekat.service.RezervacijaService;

@Component
public class DtoUPoruku implements Converter<PorukaDto, Poruka> {
    @Autowired
    private PorukaService porukaService;
    @Autowired
    private RezervacijaService rezervacijaService;
    @Override
    public Poruka convert(PorukaDto source) {
        Poruka poruka = new Poruka();
        poruka.setId(source.getId());
        poruka.setIdPosiljalac(source.getPosiljalacId());
        poruka.setRezervacija(rezervacijaService.findOne(source.getRezervacijaId()));
        poruka.setTekst(source.getTekst());
        return poruka;
    }
}
