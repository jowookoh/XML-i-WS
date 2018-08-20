package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.KategorijaSmestajaDto;
import sesta.projekat.model.KategorijaSmestaja;

import java.util.ArrayList;
import java.util.List;

@Component
public class KategorijaSmestajaUDto implements Converter<KategorijaSmestaja, KategorijaSmestajaDto> {
    @Override
    public KategorijaSmestajaDto convert(KategorijaSmestaja source) {
        KategorijaSmestajaDto kategorijaSmestajaDto = new KategorijaSmestajaDto(source.getId(), source.getNaziv());
        return kategorijaSmestajaDto;
    }

    public List<KategorijaSmestajaDto> convert(List<KategorijaSmestaja> source){
        List<KategorijaSmestajaDto> kategorijaSmestajaDtos = new ArrayList<>();
        for(KategorijaSmestaja kategorijaSmestaja : source){
            kategorijaSmestajaDtos.add(convert(kategorijaSmestaja));
        }
        return kategorijaSmestajaDtos;
    }
}
