package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.TipSmestajaDto;
import sesta.projekat.model.TipSmestaja;

@Component
public class DtoUTipSmestaja implements Converter<TipSmestajaDto, TipSmestaja> {

    @Override
    public TipSmestaja convert(TipSmestajaDto source) {
        TipSmestaja tipSmestaja = new TipSmestaja();
        tipSmestaja.setNaziv(source.getNaziv());

        return tipSmestaja;
    }
}
