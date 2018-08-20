package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.TipSmestajaDto;
import sesta.projekat.model.TipSmestaja;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipSmestajaUDto implements Converter<TipSmestaja, TipSmestajaDto> {
    @Override
    public TipSmestajaDto convert(TipSmestaja source) {
        TipSmestajaDto tipSmestajaDto = new TipSmestajaDto();
        tipSmestajaDto.setNaziv(source.getNaziv());
        return tipSmestajaDto;
    }

    public List<TipSmestajaDto> convert(List<TipSmestaja> source){
        List<TipSmestajaDto> tipSmestajaDtos = new ArrayList<>();
        for(TipSmestaja tipSmestaja : source){
            tipSmestajaDtos.add(convert(tipSmestaja));
        }
        return tipSmestajaDtos;
    }
}
