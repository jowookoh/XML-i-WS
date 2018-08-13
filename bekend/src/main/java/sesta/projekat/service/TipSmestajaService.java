package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.TipSmestaja;
import sesta.projekat.repository.TipSmestajaRepository;

import java.util.List;

@Service
public class TipSmestajaService {

    @Autowired
    private TipSmestajaRepository tipSmestajaRepository;

    public TipSmestaja findOne(Long id) {
        return tipSmestajaRepository.findOne(id);
    }

    public TipSmestaja save(TipSmestaja tipSmestaja) {
        return tipSmestajaRepository.save(tipSmestaja);
    }

    public List<TipSmestaja> getAll() {
        return tipSmestajaRepository.findAll();
    }
}
