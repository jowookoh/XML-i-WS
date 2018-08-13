package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.UslugaSmestaj;
import sesta.projekat.repository.UslugaSmestajRepository;

import java.util.List;

@Service
public class UslugaSmestajService {

    @Autowired
    private UslugaSmestajRepository uslugaSmestajRepository;

    public UslugaSmestaj findOne(Long id) {
        return uslugaSmestajRepository.findOne(id);
    }

    public UslugaSmestaj save(UslugaSmestaj uslugaSmestaj) {
        return uslugaSmestajRepository.save(uslugaSmestaj);
    }

    public List<UslugaSmestaj> getAll() {
        return uslugaSmestajRepository.findAll();
    }
}
