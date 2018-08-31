package sesta.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesta.projekat.model.KategorijaSmestaja;
import sesta.projekat.repository.KategorijaSmestajaRepository;

import java.util.List;

@Service
public class KategorijaSmestajaService {

    @Autowired
    private KategorijaSmestajaRepository kategorijaSmestajaRepository;

    public KategorijaSmestaja findOne(Long id) {
        return kategorijaSmestajaRepository.findOne(id);
    }

    public KategorijaSmestaja save(KategorijaSmestaja kategorijaSmestaja) {
        return kategorijaSmestajaRepository.save(kategorijaSmestaja);
    }

    public List<KategorijaSmestaja> getAll() {
        return kategorijaSmestajaRepository.findAll();
    }

    public void deleteOne(Long id){ kategorijaSmestajaRepository.delete(id);}

    public void deleteOne(KategorijaSmestaja ks) { kategorijaSmestajaRepository.delete(ks);}
}
