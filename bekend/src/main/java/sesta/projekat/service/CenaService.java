package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Cena;
import sesta.projekat.repository.CenaRepository;

import java.util.List;

@Service
public class CenaService {

    @Autowired
    private CenaRepository cenaRepository;

    public Cena findOne(Long id) {
        return cenaRepository.findOne(id);
    }

    public Cena save(Cena cena) {
        return cenaRepository.save(cena);
    }

    public List<Cena> getAll() {
        return cenaRepository.findAll();
    }
}
