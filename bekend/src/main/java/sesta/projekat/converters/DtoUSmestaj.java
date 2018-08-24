package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.SmestajDto;
import sesta.projekat.model.Smestaj;

@Component
public class DtoUSmestaj implements Converter<SmestajDto, Smestaj> {
    @Autowired
    private DtoUKategorijuSmestaja dtoUKategorijuSmestaja;
    @Autowired
    private DtoULokaciju dtoULokaciju;
    @Autowired
    private DtoUTipSmestaja dtoUTipSmestaja;
    @Override
    public Smestaj convert(SmestajDto source) {
        Smestaj smestaj = new Smestaj();
        smestaj.setId(source.getId());
        smestaj.setBrojOsoba(source.getBrojOsoba());
        smestaj.setKategorijaSmestaja(dtoUKategorijuSmestaja.convert(source.getKategorijaSmestajaDto()));
        smestaj.setTipSmestaja(dtoUTipSmestaja.convert(source.getTipSmestajaDto()));
        smestaj.setLokacija(dtoULokaciju.convert(source.getLokacijaDto()));
        smestaj.setOpis(source.getOpis());
        return smestaj;
    }
}
