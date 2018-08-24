package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Poruka;
import sesta.projekat.repository.PorukaRepository;

import java.util.List;

@Service
public class PorukaService {

    @Autowired
    private PorukaRepository porukaRepository;

    public Poruka findOne(Long id) {
        return porukaRepository.findOne(id);
    }

    public Poruka save(Poruka poruka) {
        return porukaRepository.save(poruka);
    }

    public List<Poruka> getAll() {
        return porukaRepository.findAll();
    }
}
