package com.example.agent.service;

import com.example.agent.model.Rezervacija;
import com.example.agent.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RezervacijaService {

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    public Rezervacija novaFejk(Rezervacija rezervacija){
        rezervacija.setFejk(true);
        rezervacijaRepository.save(rezervacija);
        return rezervacija;
    }

    public void realizujRezervaciju(Rezervacija rezervacija){
        rezervacija.setRealizovana(true);
        rezervacijaRepository.save(rezervacija);
    }


}
