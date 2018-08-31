package com.example.agent.service;

import com.example.agent.model.UslugaSmestaj;
import com.example.agent.repository.UslugaSmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UslugaSmestajService {

    @Autowired
    UslugaSmestajRepository uslugaSmestajRepository;

    public List<UslugaSmestaj>  noveVeze(List<UslugaSmestaj> uslugaSmestaj){
        uslugaSmestaj=uslugaSmestajRepository.save(uslugaSmestaj);
        return uslugaSmestaj;
    }
}
