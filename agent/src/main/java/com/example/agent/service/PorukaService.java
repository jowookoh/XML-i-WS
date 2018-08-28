package com.example.agent.service;

import com.example.agent.model.Poruka;
import com.example.agent.model.Rezervacija;
import com.example.agent.model.dto.PorukaDTO;
import com.example.agent.repository.PorukaRepository;
import com.example.agent.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PorukaService {

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    PorukaRepository porukaRepository;

    public List<PorukaDTO> porukaRezervacije(Long id){
        List<Poruka> poruke = porukaRepository.findByRezervacija(rezervacijaRepository.findById(id));
        ArrayList<PorukaDTO> porukeDTO = new ArrayList<>();

        for (Poruka poruka : poruke) {
            PorukaDTO porukaDTO=new PorukaDTO();
            porukaDTO.setId(poruka.getId());
            porukaDTO.setPosiljalacId(poruka.getIdPosiljalac());
            porukaDTO.setRezervacija(poruka.getRezervacija());
            porukaDTO.setTekst(poruka.getTekst());
            porukeDTO.add(porukaDTO);
        }
        return porukeDTO;
    }
}
