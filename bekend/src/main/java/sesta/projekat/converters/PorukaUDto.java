package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.PorukaDto;
import sesta.projekat.model.Poruka;

@Component
public class PorukaUDto implements Converter<Poruka, PorukaDto> {
    @Override
    public PorukaDto convert(Poruka source) {
        PorukaDto porukaDto = new PorukaDto();
        porukaDto.setId(source.getId());
        porukaDto.setPosiljalacId(source.getIdPosiljalac());
        porukaDto.setRezervacijaId(source.getRezervacijaId());
        porukaDto.setTekst(source.getTekst());
        return porukaDto;
    }
}
