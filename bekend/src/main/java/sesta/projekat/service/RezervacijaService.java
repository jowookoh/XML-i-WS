package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Rezervacija;
import sesta.projekat.repository.RezervacijaRepository;

import java.util.List;

@Service
public class RezervacijaService {

    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    public Rezervacija findOne(Long id) {
        return rezervacijaRepository.findOne(id);
    }

    public Rezervacija save(Rezervacija rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    public List<Rezervacija> getAll() {
        return rezervacijaRepository.findAll();
    }
}
