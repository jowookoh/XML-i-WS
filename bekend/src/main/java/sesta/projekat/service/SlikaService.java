package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Slika;
import sesta.projekat.repository.SlikaRepository;

import java.util.List;

@Service
public class SlikaService {

    @Autowired
    private SlikaRepository slikaRepository;

    public Slika findOne(Long id) {
        return slikaRepository.findOne(id);
    }

    public Slika save(Slika slika) {
        return slikaRepository.save(slika);
    }

    public List<Slika> getAll() {
        return slikaRepository.findAll();
    }
}
