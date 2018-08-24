package sesta.projekat.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sesta.projekat.dto.SmestajDto;
import sesta.projekat.model.Smestaj;

@Component
public class SmestajUDto implements Converter<Smestaj, SmestajDto> {
    @Autowired
    private KategorijaSmestajaUDto kategorijaSmestajaUDto;
    @Autowired
    private LokacijaUDto lokacijaUDto;
    @Autowired
    private TipSmestajaUDto tipSmestajaUDto;
    @Override
    public SmestajDto convert(Smestaj source) {
        SmestajDto smestajDto = new SmestajDto();
        smestajDto.setBrojOsoba(source.getBrojOsoba());
        smestajDto.setId(source.getId());
        smestajDto.setKategorijaSmestajaDto(kategorijaSmestajaUDto.convert(source.getKategorijaSmestaja()));
        smestajDto.setLokacijaDto(lokacijaUDto.convert(source.getLokacija()));
        smestajDto.setOpis(source.getOpis());
        smestajDto.setTipSmestajaDto(tipSmestajaUDto.convert(source.getTipSmestaja()));
        return smestajDto;
    }
}
