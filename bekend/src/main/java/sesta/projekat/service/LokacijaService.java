package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Lokacija;
import sesta.projekat.repository.LokacijaRepository;

import java.util.List;

@Service
public class LokacijaService {

    @Autowired
    private LokacijaRepository lokacijaRepository;

    public Lokacija findOne(Long id) {
        return lokacijaRepository.findOne(id);
    }

    public Lokacija save(Lokacija lokacija) {
        return lokacijaRepository.save(lokacija);
    }

    public List<Lokacija> getAll() {
        return lokacijaRepository.findAll();
    }
}
