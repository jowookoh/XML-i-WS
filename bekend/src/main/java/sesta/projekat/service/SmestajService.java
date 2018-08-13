package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Smestaj;
import sesta.projekat.repository.SmestajRepository;

import java.util.List;

@Service
public class SmestajService {

    @Autowired
    private SmestajRepository smestajRepository;

    public Smestaj findOne(Long id) {
        return smestajRepository.findOne(id);
    }

    public Smestaj save(Smestaj smestaj) {
        return smestajRepository.save(smestaj);
    }

    public List<Smestaj> getAll() {
        return smestajRepository.findAll();
    }
}
