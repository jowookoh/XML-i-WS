package sesta.projekat.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.KategorijaSmestajaDto;
import sesta.projekat.model.KategorijaSmestaja;

@Component
public class DtoUKategorijuSmestaja implements Converter<KategorijaSmestajaDto, KategorijaSmestaja> {
    @Override
    public KategorijaSmestaja convert(KategorijaSmestajaDto source) {
        KategorijaSmestaja kategorijaSmestaja = new KategorijaSmestaja();
        kategorijaSmestaja.setId(source.getId());
        kategorijaSmestaja.setNaziv(source.getNaziv());

        return kategorijaSmestaja;
    }
}
