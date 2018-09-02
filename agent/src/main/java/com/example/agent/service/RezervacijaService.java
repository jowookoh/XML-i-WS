package com.example.agent.service;

import com.example.agent.model.Rezervacija;
import com.example.agent.model.Smestaj;
import com.example.agent.repository.RezervacijaRepository;
import com.example.agent.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RezervacijaService {

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    SmestajRepository smestajRepository;

    public Rezervacija novaFejk(Rezervacija rezervacija){
        rezervacija.setFejk(true);
        rezervacija.setRealizovana(true);
        rezervacijaRepository.save(rezervacija);
        return rezervacija;
    }

    public void realizujRezervaciju(Rezervacija rezervacija){
        rezervacija.setRealizovana(true);
        rezervacijaRepository.save(rezervacija);
    }

    public List<Rezervacija> rezervacijeMojihSmestaja(Long agent, boolean sve){
        List<Smestaj> mojiSmestaji = smestajRepository.findByAgent_Id(agent);
        List<Rezervacija> rezeMojih = new ArrayList<>();
        for (Smestaj smestaj: mojiSmestaji) {
            List<Rezervacija> rezeSmestaja = rezervacijaRepository.findBySmestaj(smestaj);
            if(!sve) {
                for (Rezervacija rezervacija : rezeSmestaja) {
                    if (!rezervacija.isRealizovana()) {
                        rezeMojih.add(rezervacija);
                    }
                }
            }
            else {
                rezeMojih.addAll(rezeSmestaja);
            }
        }
        return rezeMojih;
    }
}
