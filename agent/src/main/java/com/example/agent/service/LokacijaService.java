package com.example.agent.service;

import com.example.agent.model.Lokacija;
import com.example.agent.repository.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LokacijaService {
    @Autowired
    LokacijaRepository lokacijaRepository;

    public Lokacija novaLokacija(Lokacija lokacija){
        lokacija=lokacijaRepository.save(lokacija);
        return lokacija;
    }
}
