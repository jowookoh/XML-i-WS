package com.example.agent.service;

import com.example.agent.model.Poruka;
import com.example.agent.repository.PorukaRepository;
import com.example.agent.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorukaService {

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    PorukaRepository porukaRepository;

    public List<Poruka> porukaRezervacije(Long id){
        List<Poruka> poruke = porukaRepository.findByRezervacija(rezervacijaRepository.findById(id));
        return poruke;
    }
}
