package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.Usluga;
import sesta.projekat.repository.UslugaRepository;

import java.util.List;

@Service
public class UslugaService {

    @Autowired
    private UslugaRepository uslugaRepository;

    public Usluga findOne(Long id) {
        return uslugaRepository.findOne(id);
    }

    public Usluga save(Usluga usluga) {
        return uslugaRepository.save(usluga);
    }

    public List<Usluga> getAll() {
        return uslugaRepository.findAll();
    }

    public void deleteOne(Long id){ uslugaRepository.delete(id);}

    public void deleteOne(Usluga u) { uslugaRepository.delete(u);}
}
